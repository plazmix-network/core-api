package net.plazmix.core.api.spigot.command;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import net.plazmix.core.api.common.command.CommandSender;

import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SpigotCommandSender implements CommandSender {

    public static CommandSender of(org.bukkit.command.CommandSender sender) {
        return new SpigotCommandSender(sender);
    }

    private final org.bukkit.command.CommandSender sender;

    @Override
    public String getName() {
        return sender.getName();
    }

    @Override
    public boolean hasPermission(String permission) {
        return sender.hasPermission(permission);
    }

    @Override
    public void sendMessage(String message) {
        sender.sendMessage(message);
    }

    @Override
    public <T> Optional<T> resolveAs(Class<T> clazz) {
        try {
            T type = (T) sender;
            return Optional.of(type);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
