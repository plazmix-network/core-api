package net.plazmix.core.api.service.database.mapper;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public abstract class AbstractDataContainerBuilder<T, ID> implements DataContainerBuilder<T, ID> {

    protected String name;
    protected DataSource dataSource;
    protected Function<Data, T> objectMapper;
    protected Function<T, Data> dataMapper;
    protected final Map<String, Column> columnMap = new LinkedHashMap<>();

    @Override
    public DataContainerBuilder<T, ID> withName(String name) {
        this.name = Objects.requireNonNull(name);
        return this;
    }

    @Override
    public DataContainerBuilder<T, ID> withDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        return this;
    }

    @Override
    public DataContainerBuilder<T, ID> withColumn(Column column) {
        Column nonNullColumn = Objects.requireNonNull(column);
        columnMap.put(nonNullColumn.getName(), nonNullColumn);
        return this;
    }

    @Override
    public DataContainerBuilder<T, ID> withObjectMapper(Function<Data, T> mapper) {
        this.objectMapper = Objects.requireNonNull(mapper);
        return this;
    }

    @Override
    public DataContainerBuilder<T, ID> withDataMapper(Function<T, Data> mapper) {
        this.dataMapper = Objects.requireNonNull(mapper);
        return this;
    }
}
