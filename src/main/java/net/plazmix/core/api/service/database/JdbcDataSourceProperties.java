package net.plazmix.core.api.service.database;

/**
 * @author MasterCapeXD
 */
public interface JdbcDataSourceProperties {

    boolean cachePreparedStatements();

    int getCacheSize();

    int getCacheSqlLimit();
}
