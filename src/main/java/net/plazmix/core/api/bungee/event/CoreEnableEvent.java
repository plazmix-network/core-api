package net.plazmix.core.api.bungee.event;

import lombok.Data;
import net.md_5.bungee.api.plugin.Event;
import net.plazmix.core.api.bungee.BungeeCoreApi;

@Data
public class CoreEnableEvent extends Event {

    private final BungeeCoreApi core;
}
