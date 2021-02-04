package net.plazmix.core.api.spigot.sidebar;

import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public interface Sidebar {

    Function<Player, String> getTitleApplier();

    Function<Player, List<String>> getLinesApplier();

    void update();

    boolean isUsing();

    boolean contains(Player player);

    void addPlayer(Player player);

    void addPlayers(Collection<? extends Player> players);

    void removePlayer(Player player);

    void removePlayers(Collection<? extends Player> players);

    void removeAll();
}
