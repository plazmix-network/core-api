package net.plazmix.core.api.spigot.nametag;

import org.bukkit.entity.Player;

public interface Nametag {

    Player getPlayer();

    int getPriority();

    String getDisplayName();

    String getPrefix();

    String getSuffix();

    void updateAll(String prefix, String displayName, String suffix, int priority);

    void update(String prefix, String suffix, int priority);

    void update(String prefix, String suffix);

    void updateDisplayName(String displayName);

    void updatePrefix(String prefix);

    void updateSuffix(String suffix);
}