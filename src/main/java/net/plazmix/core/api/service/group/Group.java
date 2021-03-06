package net.plazmix.core.api.service.group;

import lombok.Getter;
import net.plazmix.core.api.Core;

@Getter
public enum Group {

    PLAYER("&7", "", "&7Игрок", false),

    METEOR("&e", "", "&e&lMeteor", false),
    COMET("&d", "", "&d&lComet", false),
    STAR("&6", "", "&6&lStar", false),
    GALAXY("&5", "", "&5&lGalaxy", false),
    COSMO("&1", "", "&1&lCosmo", false),

    CHAT_MODER("&2&lCHAT MODER &2", "", "&2&lCHAT MODER", true),
    MODER("&9&lMODER &9", "", "&9&lMODER", true),
    TRUE_MODER("&3&lMODER+ &3", "", "&3&lMODER+", true),
    MANAGER("&9&lMANAGER &9", "", "&9&lMANAGER", true),
    CURATOR("&c&lCURATOR &c", "", "&c&lCURATOR", true),
    DEV("&9&lDEV &9", "", "&9&lDEV", true),
    ADMIN("&4&lADMIN &4", "", "&4&lADMIN", true);

    private final String prefix, suffix, displayName;
    private final boolean staff;

    Group(String prefix, String suffix, String displayName, boolean staff) {
        this.prefix = Core.getApi().colorize(prefix);
        this.suffix = Core.getApi().colorize(suffix);
        this.displayName = Core.getApi().colorize(displayName);
        this.staff = staff;
    }
}
