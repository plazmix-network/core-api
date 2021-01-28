package net.plazmix.core.api.spigot;

import net.plazmix.core.api.CoreApi;
import net.plazmix.core.api.common.command.CommandBuilder;
import net.plazmix.core.api.spigot.inventory.view.builder.GlobalViewInventoryBuilder;
import net.plazmix.core.api.spigot.inventory.view.builder.PersonalViewInventoryBuilder;
import org.bukkit.plugin.Plugin;

/**
 * @author MasterCapeXD
 */
public interface SpigotCoreApi extends CoreApi {

    Plugin getPlugin();

    GlobalViewInventoryBuilder<?> newGlobalViewInventory();

    GlobalViewInventoryBuilder<?> newGlobalViewInventory(Plugin plugin);

    PersonalViewInventoryBuilder<?> newPersonalViewInventory();

    PersonalViewInventoryBuilder<?> newPersonalViewInventory(Plugin plugin);

    CommandBuilder newCommand(String holder, String name);

    CommandBuilder newCommand(Plugin plugin, String name);

    CommandBuilder newCommand(Plugin plugin, String holder, String name);
}
