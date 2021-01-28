package net.plazmix.core.api.common.orm;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMapData implements Data {

    private final Map<String, Object> dataMap = new HashMap<>();

    @Override
    public Collection<String> keySet() {
        return Collections.unmodifiableSet(dataMap.keySet());
    }

    @Override
    public boolean hasObjectValue(String key) {
        return dataMap.containsKey(key);
    }

    @Override
    public Object getObjectValue(String key) {
        return dataMap.get(key);
    }

    @Override
    public Object getObjectValue(String key, Object defaultIfNull) {
        return dataMap.getOrDefault(key, defaultIfNull);
    }

    @Override
    public void writeObjectValue(String key, Object value) {
        dataMap.put(key, value);
    }

    @Override
    public void remove(String key) {
        dataMap.remove(key);
    }

    @Override
    public void clear() {
        dataMap.clear();
    }
}
