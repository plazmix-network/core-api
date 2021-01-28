package net.plazmix.core.api.common.orm.mysql;

import net.plazmix.core.api.common.orm.*;
import org.apache.commons.lang.StringUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class MySqlDataContainer<T, ID> extends AbstractDataContainer<T, ID> {

    private static String getDatabaseType(Class<?> clazz, boolean unique, int length) {
        if (clazz.isAssignableFrom(Long.class))
            return "BIGINT";
        else if (clazz.isAssignableFrom(Integer.class))
            return "MEDIUMINT";
        else if (clazz.isAssignableFrom(Short.class))
            return "SMALLINT";
        else if (clazz.isAssignableFrom(Byte.class) || clazz.isAssignableFrom(Boolean.class))
            return "TINYINT";
        else if (clazz.isAssignableFrom(Double.class))
            return "DOUBLE";
        else if (clazz.isAssignableFrom(Float.class))
            return "FLOAT";
        else if (clazz.isAssignableFrom(String.class)) {
            if (unique)
                return String.format("VARCHAR(%s)", length);
            else
                return "MEDIUMTEXT";
        } else
            return null;
    }

    private final DataSource dataSource;

    public MySqlDataContainer(String name, DataSource dataSource, Map<String, Column> columnMap, Function<Data, T> objectMapper, Function<T, Data> dataMapper) {
        super(name, columnMap, objectMapper, dataMapper);
        this.dataSource = dataSource;
    }

    @Override
    public void create() {
        String values = StringUtils.join(StreamSupport.stream(getColumns().spliterator(), false)
                .map(column -> {

                    String type = getDatabaseType(column.getType(), column.isUnique() || column.isPrimary(), column.length());
                    if (type == null)
                        throw new IllegalArgumentException("Unsupported column type: " + column.getType().getSimpleName());

                    StringBuilder valueBuilder = new StringBuilder(
                            "`" + column.getName() + "` " + type);
                    if (column.isPrimary())
                        valueBuilder.append(" PRIMARY KEY");
                    else if (column.isUnique())
                        valueBuilder.append(" UNIQUE");
                    else if (!column.isNullable())
                        valueBuilder.append(" NOT NULL");

                    return valueBuilder.toString();

                }).collect(Collectors.toList()), ", ");
        String sql = String.format(
                "CREATE TABLE IF NOT EXISTS `%s` (%s);",
                getName(), values);

        try (Connection connection = dataSource.getConnection()) {
            connection.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete() {
        try (Connection connection = dataSource.getConnection()) {
            connection.createStatement().execute(String.format("DROP TABLE %s;", getName()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private QueryInfo getSaveSql() {
        AtomicInteger index = new AtomicInteger(1);
        Map<Integer, Column> preparedColumns = new HashMap<>();

        String
                columns = StringUtils.join(StreamSupport.stream(getColumns().spliterator(), false)
                .map(column -> String.format("`%s`", column.getName()))
                .collect(Collectors.toList()), ", "),

                insertChars = StringUtils.join(StreamSupport.stream(getColumns().spliterator(), false)
                        .map(column -> {
                            preparedColumns.put(index.getAndIncrement(), column);
                            return "?";
                        })
                        .collect(Collectors.toList()), ", "),

                updateColumns = StringUtils.join(StreamSupport.stream(getColumns().spliterator(), false)
                        .filter(Column::isUpdatable)
                        .map(column -> String.format("`%s` = VALUES(`%s`)", column.getName(), column.getName()))
                        .collect(Collectors.toList()), ", ");

        return new QueryInfo(String.format("INSERT INTO `%s` (%s) VALUES (%s) ON DUPLICATE KEY UPDATE %s;", getName(), columns, insertChars, updateColumns), preparedColumns);
    }

    private QueryInfo getUpdateSql() {
        AtomicInteger index = new AtomicInteger(1);
        Map<Integer, Column> preparedColumns = new HashMap<>();

        String set = StringUtils.join(StreamSupport.stream(getColumns().spliterator(), false)
                .filter(Column::isUpdatable)
                .map(column -> {
                    preparedColumns.put(index.getAndIncrement(), column);
                    return column.getName() + "=?";
                })
                .collect(Collectors.toList()), ", ");

        preparedColumns.put(index.incrementAndGet(), getPrimaryColumn());
        return new QueryInfo(String.format("UPDATE `%s` SET %s WHERE `%s`=?", getName(), set, getPrimaryColumn().getName()), preparedColumns);
    }

    @Override
    public T save(T entity) {
        Data data = getDataMapper().apply(entity);
        try (Connection connection = dataSource.getConnection()) {
            QueryInfo queryInfo = getSaveSql();
            PreparedStatement statement = connection.prepareStatement(queryInfo.getQuery());

            if (queryInfo.isPrepared()) {
                for (int i = 1; i <= queryInfo.getMaxIndex(); i++) {
                    Column column = queryInfo.getColumn(i);
                    setValue(column, data.getObjectValue(column.getName(), null), statement, i);
                }
            }
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> entities) {
        for (T entity : entities)
            save(entity);
        return entities;
    }

    @Override
    public T update(T entity) {
        Data data = getDataMapper().apply(entity);
        try (Connection connection = dataSource.getConnection()) {
            QueryInfo queryInfo = getUpdateSql();
            PreparedStatement statement = connection.prepareStatement(queryInfo.getQuery());

            if (queryInfo.isPrepared()) {
                for (int i = 1; i <= queryInfo.getMaxIndex(); i++) {
                    Column column = queryInfo.getColumn(i);
                    setValue(column, data.getObjectValue(column.getName(), null), statement, i);
                }
            }
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public Iterable<T> updateAll(Iterable<T> entities) {
        for (T entity : entities)
            update(entity);
        return entities;
    }

    @Override
    public Optional<T> findById(ID id) {
        String values = StringUtils.join(getColumnNames(), ", ");
        String sql = String.format("SELECT %s FROM `%s` WHERE `%s`=? LIMIT 1;", values, getName(), getPrimaryColumn().getName());

        Data data = new HashMapData();
        data.writeObjectValue(getPrimaryColumn().getName(), id);
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                for (Column column : getColumns()) {
                    if (column.isPrimary())
                        continue;
                    data.writeObjectValue(column.getName(), resultSet.getObject(column.getName()));
                }
            }
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(getObjectMapper().apply(data));
    }

    @Override
    public Iterable<T> findAll() {
        String sql = String.format("SELECT * FROM `%s`;", getName());

        List<T> list = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Data data = new HashMapData();
                for (Column column : getColumns())
                    data.writeObjectValue(column.getName(), resultSet.getObject(column.getName()));
                T result = getObjectMapper().apply(data);
                if (result != null)
                    list.add(result);
            }
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Iterable<T> findAllById(Iterable<ID> ids) {
        List<T> list = new ArrayList<>();
        for (ID id : ids)
            findById(id).ifPresent(list::add);
        return list;
    }

    @Override
    public void deleteById(ID id) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(String.format("DELETE FROM `%s` WHERE `%s`=?;", getName(), getPrimaryColumn().getName()));
            statement.setObject(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void delete(T entity) {
        Data data = getDataMapper().apply(entity);
        deleteById((ID) data.getObjectValue(getPrimaryColumn().getName()));
    }

    @Override
    public void deleteAll(Iterable<T> entities) {
        for (T entity : entities)
            delete(entity);
    }

    @Override
    public void deleteAll() {
        try (Connection connection = dataSource.getConnection()) {
            connection.createStatement().execute(String.format("DELETE FROM %s;", getName()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setValue(Column column, Object value, PreparedStatement statement, int index) throws SQLException {
        if (getDatabaseType(column.getType(), false, 0) == null)
            throw new IllegalArgumentException("Unsupported class type: " + column.getType().getSimpleName());
        statement.setObject(index, value);
    }
}
