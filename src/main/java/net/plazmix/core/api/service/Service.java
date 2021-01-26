package net.plazmix.core.api.service;

import net.plazmix.core.api.Core;

/**
 * @author MasterCapeXD
 */
public interface Service {

    String getName();

    void enable() throws Exception;

    void disable() throws Exception;

    boolean isEnabled();

    default void reload() {
        try {
            disable();
            enable();
        } catch (Exception e) {
            Core.getApi().getLogger().severe("Unable to reload service " + getName() + ". Details: " + e.getMessage());
        }
    }
}
