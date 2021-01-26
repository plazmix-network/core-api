package net.plazmix.core.api.service.database.mapper;

import java.util.Optional;
import java.util.function.Function;

public interface DataContainer<T, ID> {

    String getName();

    Iterable<Column> getColumns();

    Iterable<String> getColumnNames();

    Column getPrimaryColumn();

    Column getColumnByName(String columnName);

    void create();

    void delete();

    T save(T entity);

    Iterable<T> saveAll(Iterable<T> entities);

    T update(T entity);

    Iterable<T> updateAll(Iterable<T> entities);

    Optional<T> findById(ID id);

    Iterable<T> findAll();

    Iterable<T> findAllById(Iterable<ID> ids);

    void deleteById(ID id);

    void delete(T entity);

    void deleteAll(Iterable<T> entities);

    void deleteAll();

    Function<Data, T> getObjectMapper();

    Function<T, Data> getDataMapper();
}
