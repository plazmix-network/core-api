package net.plazmix.core.api.service;

/**
 * @author MasterCapeXD
 */
public interface Service {

    String getName();

    void enable() throws Exception;

    void disable() throws Exception;

    boolean isEnabled();
}
