package net.plazmix.core.api.spigot.inventory.view;

import net.plazmix.core.api.spigot.inventory.ClickData;
import net.plazmix.core.api.spigot.inventory.InventoryData;
import net.plazmix.core.api.spigot.inventory.icon.Icon;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.function.Consumer;

/**
 * @author MasterCapeXD
 */
public interface InventoryBase {

    Plugin getPlugin();

    InventoryType getType();

    Consumer<InventoryData> getOpeningAction();

    Consumer<InventoryData> getClosingAction();

    Collection<Player> getCurrentViewers();

    Icon getIcon(ClickData data);

    int getSlots();

    void open(Player player);

    void close(Player player);

    void refresh();

    default boolean isViewing(Player player) {
        return getCurrentViewers().contains(player);
    }

    default boolean isEmptyClick(ClickData data) {
        return getIcon(data) == null;
    }
}