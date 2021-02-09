package net.plazmix.core.api.spigot.event;

import lombok.Data;
import lombok.Getter;
import net.plazmix.core.api.spigot.SpigotCoreApi;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Data
public class CoreEnableEvent extends Event {

    @Getter
    private static final HandlerList handlerList = new HandlerList();

    @Getter
    private final SpigotCoreApi core;

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
