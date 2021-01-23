package net.plazmix.core.api.spigot.inventory.icon;

import net.plazmix.core.api.spigot.inventory.ClickData;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

/**
 * @author MasterCapeXD
 */
public interface Icon {

    Icon EMPTY = of(new ItemStack(Material.AIR));

    static Icon of(ItemStack itemStack) {
        return of(itemStack, data -> {
        });
    }

    static Icon of(ItemStack itemStack, Consumer<ClickData> consumer) {
        return new AbstractIcon(consumer) {

            @Override
            public ItemStack getIcon() {
                return itemStack;
            }
        };
    }

    ItemStack getIcon();

    Consumer<ClickData> getClickAction();
}