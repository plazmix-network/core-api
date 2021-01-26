package net.plazmix.core.api.common.orm;

import java.util.Collections;
import java.util.Map;

public final class QueryInfo {

    private final String query;
    private final Map<Integer, Column> preparedColumns;

    public QueryInfo(String query, Map<Integer, Column> preparedColumns) {
        this.query = query;
        this.preparedColumns = Collections.unmodifiableMap(preparedColumns);
    }

    public boolean isPrepared() {
        return query.contains("?") && !preparedColumns.isEmpty();
    }

    public String getQuery() {
        return query;
    }

    public boolean isPrepared(Column column) {
        return preparedColumns.containsValue(column);
    }

    public Column getColumn(int index) {
        return preparedColumns.getOrDefault(index, null);
    }

    public Iterable<Column> getPreparedColumns() {
        return preparedColumns.values();
    }

    public int getMaxIndex() {
        return preparedColumns.size();
    }
}
