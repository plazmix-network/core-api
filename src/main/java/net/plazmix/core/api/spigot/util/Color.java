package net.plazmix.core.api.spigot.util;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;

public enum Color {

    BLACK(ChatColor.BLACK, DyeColor.BLACK, 15), DARK_GRAY(ChatColor.DARK_GRAY, DyeColor.GRAY, 7),
    GRAY(ChatColor.GRAY, DyeColor.SILVER, 8), BLUE(ChatColor.BLUE, DyeColor.BLUE, 11),
    TEAL(ChatColor.DARK_AQUA, DyeColor.CYAN, 9), AQUA(ChatColor.AQUA, DyeColor.LIGHT_BLUE, 3),
    GREEN(ChatColor.DARK_GREEN, DyeColor.GREEN, 13), LIME(ChatColor.GREEN, DyeColor.LIME, 5),
    PURPLE(ChatColor.DARK_PURPLE, DyeColor.PURPLE, 10), PINK(ChatColor.LIGHT_PURPLE, DyeColor.PINK, 2),
    BROWN(ChatColor.DARK_RED, DyeColor.BROWN, 12), RED(ChatColor.RED, DyeColor.RED, 14),
    ORANGE(ChatColor.GOLD, DyeColor.ORANGE, 1), YELLOW(ChatColor.YELLOW, DyeColor.YELLOW, 4),
    WHITE(ChatColor.WHITE, DyeColor.WHITE, 0);

    private final ChatColor chatColor;
    private final DyeColor dyeColor;
    private final org.bukkit.Color bukkitColor;
    private final byte colorData;

    Color(ChatColor chatColor, DyeColor dyeColor, int colorData) {
        this.chatColor = chatColor;
        this.dyeColor = dyeColor;
        this.bukkitColor = dyeColor.getColor();
        this.colorData = (byte) colorData;
    }

    public ChatColor toChatColor() {
        return chatColor;
    }

    public DyeColor toDyeColor() {
        return dyeColor;
    }

    public org.bukkit.Color toBukkitColor() {
        return bukkitColor;
    }

    public byte getColorData() {
        return colorData;
    }
}