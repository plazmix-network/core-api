package net.plazmix.core.api.service.database;

public interface JdbcDataSourceConfig {

    String getUrl();

    String getUsername();

    String getPassword();

    JdbcDataSourcePoolConfig getPoolConfig();

    JdbcDataSourceProperties getProperties();
}
