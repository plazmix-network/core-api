package net.plazmix.core.api.common.util;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Data;

import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

public class HashMapCachedDataContainer<T, K> implements CachedDataContainer<T, K> {

    private final Map<K, CachedData<T>> cache = Maps.newHashMap();

    @Override
    public Optional<T> getCachedData(K key) {
        return Optional.ofNullable(cache.getOrDefault(key, CachedData.of(null, data -> false)).getData());
    }

    @Override
    public void keep(K key, T data, Predicate<T> keepPredicate) {
        cache.put(key, CachedData.of(data, keepPredicate));
    }

    @Override
    public void invalidate(K key) {
        cache.remove(key);
    }

    @Override
    public void invalidateAll() {
        cache.clear();
    }

    @Override
    public void cleanup() {
        Sets.newHashSet(cache.keySet()).parallelStream()
                .filter(key -> !cache.get(key).shouldBeRemoved())
                .forEach(this::invalidate);
    }

    @Data(staticConstructor = "of")
    static class CachedData<T> {

        private final T data;
        private final Predicate<T> keepPredicate;

        boolean shouldBeRemoved() {
            return keepPredicate.test(data);
        }
    }
}
