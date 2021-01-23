package net.plazmix.core.api.spigot.inventory;

import net.plazmix.core.api.spigot.inventory.view.InventoryBase;
import net.plazmix.core.api.spigot.inventory.view.InventoryView;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * @author MasterCapeXD
 */
public interface InventoryData {

    static InventoryData create(HumanEntity entity, Inventory inventory) {
        return new InventoryData() {

            @Override
            public Player getIssuer() {
                return (Player) entity;
            }

            @Override
            public Inventory getInventory() {
                return inventory;
            }
        };
    }

    Inventory getInventory();

    Player getIssuer();

    default InventoryBase getInventoryBase() {
        return ((InventoryView) getInventory().getHolder()).getOwner();
    }
}