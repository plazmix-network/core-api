package net.plazmix.core.api.service.group;

import lombok.Getter;
import net.plazmix.core.api.Core;

@Getter
public enum Group {

    PLAYER("&7", "", "&7Игрок", false),

    METEOR("&e[Meteor] ", "", "&e&lMeteor", false),
    COMET("&d[Comet] ", "", "&d&lComet", false),
    STAR("&6[Star] ", "", "&6&lStar", false),
    GALAXY("&5[Galaxy] ", "", "&5&lGalaxy", false),
    COSMO("&9[Cosmo]", "", "&9&lCosmo", false),

    MEDIA("&с[&fMedia&с] ", "", "&6&lMedia", false),
    PARTNER("&6[&fPARTNER&6] ", "", "&6&lPartner", false),
    HEAD_MEDIA("&d[HeadMedia] ", "", "&d&lHeadMedia", true),

    EVENT_MAKER("&a[Event] ", "", "&a&lEvent", true),
    CHAT_MODER("&a[ChatModer] ", "", "&a&lChatModer", true),
    MODER("&b[Moder] ", "", "&b&lModer", true),
    TRUE_MODER("&3[TrueModer] ", "", "&3&lTrueModer", true),
    BUILDER("&d[Builder] ", "", "&d&lBuilder", true),
    HEAD_BUILDER("&d[HeadBuilder] ", "", "&d&lHeadBuilder", true),
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
