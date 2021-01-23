package net.plazmix.core.api.spigot.inventory.view.builder;

import net.plazmix.core.api.common.util.Builder;
import net.plazmix.core.api.spigot.inventory.InventoryData;
import net.plazmix.core.api.spigot.inventory.view.InventoryBase;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.Plugin;

import java.util.function.Consumer;

/**
 * @author MasterCapeXD
 */
public interface InventoryBaseBuilder<B extends InventoryBaseBuilder<B, R>, R extends InventoryBase> extends Builder<R> {

    Plugin getPlugin();

    B setType(InventoryType type);

    InventoryType getType();

    B setOpeningAction(Consumer<InventoryData> consumer);

    B setClosingAction(Consumer<InventoryData> consumer);

    Consumer<InventoryData> getOpeningAction();

    Consumer<InventoryData> getClosingAction();

    B setChestRows(int rows);

    int getChestRows();
}