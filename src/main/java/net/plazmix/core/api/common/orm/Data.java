package net.plazmix.core.api.common.orm;

import java.util.Collection;
import java.util.Map;

public interface Data {

    Collection<String> keySet();

    boolean hasObjectValue(String key);

    Object getObjectValue(String key);

    Object getObjectValue(String key, Object defaultIfNull);

    void writeObjectValue(String key, Object value);

    default boolean hasStringValue(String key) {
        return hasObjectValue(key) && getObjectValue(key) instanceof String;
    }

    default String getStringValue(String key) {
        return (String) getObjectValue(key);
    }

    default String getStringValue(String key, String defaultIfNull) {
        return (String) getObjectValue(key);
    }

    default void writeStringValue(String key, String value) {
        writeObjectValue(key, value);
    }

    default boolean hasByteValue(String key) {
        return hasObjectValue(key) && getObjectValue(key) instanceof Byte;
    }

    default byte getByteValue(String key) {
        return (Byte) getObjectValue(key);
    }

    default byte getByteValue(String key, byte defaultIfNull) {
        return (Byte) getObjectValue(key, defaultIfNull);
    }

    default void writeByteValue(String key, byte value) {
        writeObjectValue(key, value);
    }

    default boolean hasShortValue(String key) {
        return hasObjectValue(key) && getObjectValue(key) instanceof Short;
    }

    default short getShortValue(String key) {
        return (Short) getObjectValue(key);
    }

    default short getShortValue(String key, short defaultIfNull) {
        return (Short) getObjectValue(key, defaultIfNull);
    }

    default void writeShortValue(String key, short value) {
        writeObjectValue(key, value);
    }

    default boolean hasIntValue(String key) {
        return hasObjectValue(key) && getObjectValue(key) instanceof Integer;
    }

    default int getIntValue(String key) {
        return (Integer) getObjectValue(key);
    }

    default int getIntValue(String key, int defaultIfNull) {
        return (Integer) getObjectValue(key, defaultIfNull);
    }

    default void writeIntValue(String key, int value) {
        writeObjectValue(key, value);
    }

    default boolean hasLongValue(String key) {
        return hasObjectValue(key) && getObjectValue(key) instanceof Long;
    }

    default long getLongValue(String key) {
        return (Long) getObjectValue(key);
    }

    default long getLongValue(String key, long defaultIfNull) {
        return (Long) getObjectValue(key, defaultIfNull);
    }

    default void writeLongValue(String key, long value) {
        writeObjectValue(key, value);
    }

    default boolean hasDoubleValue(String key) {
        return hasObjectValue(key) && getObjectValue(key) instanceof Double;
    }

    default double getDoubleValue(String key) {
        return (double) getObjectValue(key);
    }

    default double getDoubleValue(String key, double defaultIfNull) {
        return (double) getObjectValue(key, defaultIfNull);
    }

    default void writeDoubleValue(String key, double value) {
        writeObjectValue(key, value);
    }

    default boolean hasFloatValue(String key) {
        return hasObjectValue(key) && getObjectValue(key) instanceof Float;
    }

    default float getFloatValue(String key) {
        return (float) getObjectValue(key);
    }

    default float getFloatValue(String key, float defaultIfNull) {
        return (float) getObjectValue(key, defaultIfNull);
    }

    default void writeFloatValue(String key, float value) {
        writeObjectValue(key, value);
    }

    default boolean hasBooleanValue(String key) {
        return hasObjectValue(key) && getObjectValue(key) instanceof Boolean;
    }

    default boolean getBooleanValue(String key) {
        return (boolean) getObjectValue(key);
    }

    default boolean getBooleanValue(String key, boolean defaultIfNull) {
        return (boolean) getObjectValue(key, defaultIfNull);
    }

    default void writeBooleanValue(String key, boolean value) {
        writeObjectValue(key, value);
    }

    default boolean hasByteArrayValue(String key) {
        return hasObjectValue(key) && getObjectValue(key) instanceof byte[];
    }

    default byte[] getByteArrayValue(String key) {
        return (byte[]) getObjectValue(key);
    }

    default byte[] getByteArrayValue(String key, byte[] defaultIfNull) {
        return (byte[]) getObjectValue(key, defaultIfNull);
    }

    default void writeByteArrayValue(String key, byte[] value) {
        writeObjectValue(key, value);
    }

    default boolean hasStringMapValue(String key) {
        return hasObjectValue(key) && getObjectValue(key) instanceof Map<?, ?>;
    }

    @SuppressWarnings("unchecked")
    default Map<String, String> getStringMapValue(String key) {
        return (Map<String, String>) getObjectValue(key);
    }

    @SuppressWarnings("unchecked")
    default Map<String, String> getStringMapValue(String key, Map<String, String> defaultIfNull) {
        return (Map<String, String>) getObjectValue(key, defaultIfNull);
    }

    default void writeStringMapValue(String key, Map<String, String> value) {
        writeObjectValue(key, value);
    }

    default boolean isEmpty() {
        return keySet().isEmpty();
    }

    void remove(String key);

    void clear();
}
