package net.plazmix.core.api.common.orm;

import net.plazmix.core.api.common.util.Builder;

import javax.sql.DataSource;
import java.util.function.Function;

public interface DataContainerBuilder<T, ID> extends Builder<DataContainer<T, ID>> {

    DataContainerBuilder<T, ID> withName(String name);

    DataContainerBuilder<T, ID> withDataSource(DataSource dataSource);

    DataContainerBuilder<T, ID> withColumn(Column column);

    DataContainerBuilder<T, ID> withObjectMapper(Function<Data, T> mapper);

    DataContainerBuilder<T, ID> withDataMapper(Function<T, Data> mapper);
}
