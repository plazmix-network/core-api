package net.plazmix.core.api.spigot.inventory.view.builder;

import net.plazmix.core.api.spigot.inventory.icon.Icon;
import net.plazmix.core.api.spigot.inventory.view.GlobalViewInventory;

/**
 * @author MasterCapeXD
 */
public interface GlobalViewInventoryBuilder<T extends GlobalViewInventoryBuilder<T>> extends InventoryBaseBuilder<T, GlobalViewInventory> {

    T setTitle(String title);

    String getTitle();

    T withIcon(int slot, Icon icon);
}