package net.plazmix.core.api.service.channel;

public interface Subscriber {

    String getName();

    void handle(String key, Object result);
}
