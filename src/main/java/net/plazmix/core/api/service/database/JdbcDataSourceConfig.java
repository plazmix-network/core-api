package net.plazmix.core.api.service.database;

/**
 * @author MasterCapeXD
 */
public interface JdbcDataSourceConfig {

    String getUrl();

    String getUsername();

    String getPassword();

    JdbcDataSourcePoolConfig getPoolConfig();

    JdbcDataSourceProperties getProperties();
}
