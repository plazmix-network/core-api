package net.plazmix.core.api.spigot.inventory.icon;

import net.plazmix.core.api.spigot.inventory.ClickData;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.function.Consumer;

/**
 * @author MasterCapeXD
 */
public abstract class AbstractIcon implements Icon {

    private final Consumer<ClickData> clickAction;

    public AbstractIcon(Consumer<ClickData> clickAction) {
        this.clickAction = clickAction;
    }

    @Override
    public Consumer<ClickData> getClickAction() {
        return clickAction;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (!(obj instanceof Icon))
            return false;

        Icon icon = (Icon) obj;
        return this.getIcon().equals(icon.getIcon()) && this.clickAction == icon.getClickAction();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(clickAction).append(getIcon()).toHashCode();
    }
}