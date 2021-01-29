package net.plazmix.core.api.common.util;

import java.util.Optional;
import java.util.function.Predicate;

public interface CachedDataContainer<T, K> {

    Optional<T> getCachedData(K key);

    void keep(K key, T data, Predicate<T> keepPredicate);

    void invalidate(K key);

    void invalidateAll();

    void cleanup();

    default T getCachedData(K key, T def, Predicate<T> keepPredicate) {
        return getCachedData(key).orElseGet(() -> {
            keep(key, def, keepPredicate);
            return def;
        });
    }
}
