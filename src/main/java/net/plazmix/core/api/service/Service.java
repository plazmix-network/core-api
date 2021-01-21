package net.plazmix.core.api.service;

public interface Service {

    String getName();

    void enable() throws Exception;

    void disable() throws Exception;

    boolean isEnabled();
}
