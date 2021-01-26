package net.plazmix.core.api.service.database;

/**
 * @author MasterCapeXD
 */
public interface JdbcDataSourcePoolConfig {

    int getMaximumSize();

    int getMinimumIdle();

    long getMaximumLifetime();

    long getConnectionTimeout();
}
