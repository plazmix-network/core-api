package net.plazmix.core.api.service.database;

public interface JdbcDataSourceProperties {

    boolean cachePreparedStatements();

    int getCacheSize();

    int getCacheSqlLimit();
}
