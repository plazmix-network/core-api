package net.plazmix.core.api.spigot.sidebar;

import net.plazmix.core.api.common.util.Builder;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.function.Function;

public interface SidebarBuilder extends Builder<Sidebar> {

    SidebarBuilder setTitleApplier(Function<Player, String> titleApplier);

    SidebarBuilder setLinesApplier(Function<Player, List<String>> linesApplier);
}
