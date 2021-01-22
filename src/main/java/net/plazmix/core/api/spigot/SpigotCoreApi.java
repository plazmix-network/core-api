package net.plazmix.core.api.spigot;

import net.plazmix.core.api.CoreApi;
import net.plazmix.core.api.common.command.CommandBuilder;
import org.bukkit.plugin.Plugin;

/**
 * @author MasterCapeXD
 */
public interface SpigotCoreApi extends CoreApi {

    Plugin getPlugin();

    CommandBuilder newCommand(String holder, String name);

    CommandBuilder newCommand(Plugin plugin, String name);

    CommandBuilder newCommand(Plugin plugin, String holder, String name);
}
