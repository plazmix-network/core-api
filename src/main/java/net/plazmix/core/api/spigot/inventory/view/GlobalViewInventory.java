package net.plazmix.core.api.spigot.inventory.view;

import net.plazmix.core.api.spigot.inventory.icon.Icon;

/**
 * @author MasterCapeXD
 */
public interface GlobalViewInventory extends InventoryBase {

    String getTitle();

    Icon getIcon(int slot);

    GlobalViewInventory setIcon(int slot, Icon icon);

    void clearSlot(int slot);

    default boolean isEmptySlot(int slot) {
        return getIcon(slot) == null;
    }
}