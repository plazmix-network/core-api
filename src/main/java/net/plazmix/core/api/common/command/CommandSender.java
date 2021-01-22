package net.plazmix.core.api.common.command;

import java.util.Optional;

/**
 * @author MasterCapeXD
 */
public interface CommandSender {

    String getName();

    boolean hasPermission(String permission);

    void sendMessage(String message);

    <T> Optional<T> resolveAs(Class<T> clazz);
}
