package net.plazmix.core.api.common.orm;

import com.google.common.base.Preconditions;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

public abstract class AbstractDataContainer<T, ID> implements DataContainer<T, ID> {

    private final String name, primaryColumnName;
    private final Map<String, Column> columnMap;
    private final Function<Data, T> objectMapper;
    private final Function<T, Data> dataMapper;

    protected AbstractDataContainer(String name, Map<String, Column> columnMap, Function<Data, T> objectMapper, Function<T, Data> dataMapper) {
        this.name = name;
        this.columnMap = Collections.unmodifiableMap(columnMap);
        this.primaryColumnName = getPrimaryColumnName(columnMap);
        this.objectMapper = objectMapper;
        this.dataMapper = dataMapper;
    }

    private String getPrimaryColumnName(Map<String, Column> columnMap) {
        String primaryColumnName = null;
        for (Column column : columnMap.values()) {
            if (primaryColumnName != null)
                throw new IllegalArgumentException("Container cannot contain more than one primary column!");
            if (column.isPrimary()) {
                primaryColumnName = column.getName();
                break;
            }
        }

        if (primaryColumnName == null)
            throw new IllegalArgumentException("Primary column not found!");

        return primaryColumnName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Iterable<Column> getColumns() {
        return columnMap.values();
    }

    @Override
    public Collection<String> getColumnNames() {
        return columnMap.keySet();
    }

    @Override
    public Column getPrimaryColumn() {
        return getColumnByName(primaryColumnName);
    }

    @Override
    public Column getColumnByName(String columnName) {
        Preconditions.checkArgument(columnMap.containsKey(columnName), "Column %s is not found!", columnName);
        return columnMap.get(columnName);
    }

    @Override
    public Function<Data, T> getObjectMapper() {
        return objectMapper;
    }

    @Override
    public Function<T, Data> getDataMapper() {
        return dataMapper;
    }
}
