package net.plazmix.core.api.common.orm.mysql;

import net.plazmix.core.api.common.orm.AbstractDataContainerBuilder;
import net.plazmix.core.api.common.orm.DataContainer;

public class MySqlDataContainerBuilder<T, ID> extends AbstractDataContainerBuilder<T, ID> {

    @Override
    public DataContainer<T, ID> build() {
        return new MySqlDataContainer<>(name, dataSource, columnMap, objectMapper, dataMapper);
    }
}
