package net.plazmix.core.api.service.database.mapper.mysql;

import net.plazmix.core.api.service.database.mapper.AbstractDataContainerBuilder;
import net.plazmix.core.api.service.database.mapper.DataContainer;

public class MySqlDataContainerBuilder<T, ID> extends AbstractDataContainerBuilder<T, ID> {

    @Override
    public DataContainer<T, ID> build() {
        return new MySqlDataContainer<>(name, dataSource, columnMap, objectMapper, dataMapper);
    }
}
