package net.plazmix.core.api.service.group;

import lombok.Getter;
import net.plazmix.core.api.spigot.util.Colors;

@Getter
public enum Group {

    PLAYER("&7", "", "&7Игрок", false),

    METEOR("&e", "", "&e&lMeteor", false),
    COMET("&d", "", "&d&lComet", false),
    STAR("&6", "", "&6&lStar", false),
    GALAXY("&5", "", "&5&lGalaxy", false),
    COSMO("&1", "", "&1&lCosmo", false);

    private final String prefix, suffix, displayName;
    private final boolean staff;

    Group(String prefix, String suffix, String displayName, boolean staff) {
        this.prefix = Colors.colorize(prefix);
        this.suffix = Colors.colorize(suffix);
        this.displayName = Colors.colorize(displayName);
        this.staff = staff;
    }
}
