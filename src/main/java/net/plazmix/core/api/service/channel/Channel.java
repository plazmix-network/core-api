package net.plazmix.core.api.service.channel;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface Channel {

    String getName();

    boolean hasEntry(String key);

    Channel sendString(String key, String value);

    Channel sendLong(String key, long value);

    Channel sendInt(String key, int value);

    Channel sendShort(String key, short value);

    Channel sendByte(String key, byte value);

    Channel sendDouble(String key, double value);

    Channel sendFloat(String key, float value);

    Channel sendBoolean(String key, boolean value);

    Channel sendStringSet(String key, Set<String> value);

    Channel addElement(String key, String value);

    Channel removeElement(String key, String value);

    Channel addAll(String key, Collection<String> value);

    Channel removeAll(String key, Collection<String> value);

    Channel sendStringMap(String key, Map<String, String> value);

    Channel putEntry(String key, String mapKey, String mapValue);

    Channel removeEntry(String key, String... mapKeys);

    String retrieveString(String key);

    long retrieveLong(String key);

    int retrieveInt(String key);

    short retrieveShort(String key);

    byte retrieveByte(String key);

    double retrieveDouble(String key);

    float retrieveFloat(String key);

    boolean retrieveBoolean(String key);

    Set<String> retrieveStringSet(String key);

    Map<String, String> retrieveStringMap(String key);

    Map<String, Object> retrieveMatching(String keyMatcher);

    Channel delete(String key);

    Channel deleteMatching(String keyMatcher);

    Channel deleteAll();

    void subscribe(String keyMatcher, Subscriber subscriber);

    void unsubscribe(String keyMatcher, Subscriber subscriber);

    void unsubscribe(Subscriber subscriber);
}
