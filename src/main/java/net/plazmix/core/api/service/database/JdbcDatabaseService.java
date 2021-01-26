package net.plazmix.core.api.service.database;

import net.plazmix.core.api.service.Service;

import javax.sql.DataSource;
import java.io.File;
import java.util.Optional;

public interface JdbcDatabaseService extends Service {

    JdbcDataSourceConfig configureFromFile(File file);

    DataSource createDataSource(String id, JdbcDataSourceConfig config);

    Optional<DataSource> getDataSource(String id);

    void invalidateDataSource(String id);
}
