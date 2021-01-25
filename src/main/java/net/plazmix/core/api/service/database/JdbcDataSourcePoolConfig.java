package net.plazmix.core.api.service.database;

public interface JdbcDataSourcePoolConfig {

    int getMaximumSize();

    int getMinimumIdle();

    long getMaximumLifetime();

    long getConnectionTimeout();
}
