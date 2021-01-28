package net.plazmix.core.api.common.orm;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ColumnBuilder {

    private final Class<?> type;
    private String name;
    private boolean
            nullable = true,
            unique = false,
            insertable = true,
            updatable = true,
            primary = false;

    private int length;

    public ColumnBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ColumnBuilder setNullable(boolean nullable) {
        this.nullable = nullable;
        return this;
    }

    public ColumnBuilder setUnique(boolean unique) {
        this.unique = unique;
        return this;
    }

    public ColumnBuilder setInsertable(boolean insertable) {
        this.insertable = insertable;
        return this;
    }

    public ColumnBuilder setUpdatable(boolean updatable) {
        this.updatable = updatable;
        return this;
    }

    public ColumnBuilder setPrimary(boolean primary) {
        this.primary = primary;
        setNullable(!primary);
        setUnique(!primary);
        setInsertable(!primary);
        setUpdatable(!primary);
        return this;
    }

    public ColumnBuilder setLength(int length) {
        this.length = length;
        return this;
    }

    public Column build() {
        return new DataColumn(type, name, nullable, unique, insertable, updatable, primary, length);
    }

    @Data
    private static class DataColumn implements Column {
        private final Class<?> type;
        private final String name;
        private final boolean nullable, unique, insertable, updatable, primary;
        private final int length;
    }
}
