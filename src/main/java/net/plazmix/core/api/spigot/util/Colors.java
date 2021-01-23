package net.plazmix.core.api.spigot.util;

import com.google.common.collect.Lists;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;

import java.util.List;

public final class Colors {

    private Colors() {
        throw new UnsupportedOperationException("This class cannot be instantiated!");
    }

    public static String colorize(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public static List<String> colorize(List<String> listOfStrings) {
        List<String> list = Lists.newArrayList();
        for (String str : listOfStrings)
            list.add(colorize(str));
        return list;
    }

    public static String decolorize(String str) {
        return ChatColor.stripColor(str);
    }

    public static List<String> decolorize(List<String> listOfStrings) {
        List<String> list = Lists.newArrayList();
        for (String str : listOfStrings)
            list.add(decolorize(str));
        return list;
    }

    public static Material getMaterialByColor(DyeColor color, String suffix) {
        return Material.getMaterial(color + "_" + suffix);
    }

    public static byte getByColor(ChatColor color) {
        switch (color) {
            case BLACK:
                return 3;
            case DARK_BLUE:
                return 4;
            case DARK_GREEN:
                return 5;
            case DARK_AQUA:
                return 6;
            case DARK_RED:
                return 7;
            case DARK_PURPLE:
                return 8;
            case GOLD:
                return 9;
            case GRAY:
                return 10;
            case DARK_GRAY:
                return 11;
            case BLUE:
                return 12;
            case GREEN:
                return 13;
            case AQUA:
                return 14;
            case RED:
                return 15;
            case LIGHT_PURPLE:
                return 16;
            case YELLOW:
                return 17;
            case WHITE:
                return 18;
            default:
                return 0;
        }
    }

    public static ChatColor getByByte(byte value) {
        switch (value) {
            case 3:
                return ChatColor.BLACK;
            case 4:
                return ChatColor.DARK_BLUE;
            case 5:
                return ChatColor.DARK_GREEN;
            case 6:
                return ChatColor.DARK_AQUA;
            case 7:
                return ChatColor.DARK_RED;
            case 8:
                return ChatColor.DARK_PURPLE;
            case 9:
                return ChatColor.GOLD;
            case 10:
                return ChatColor.GRAY;
            case 11:
                return ChatColor.DARK_GRAY;
            case 12:
                return ChatColor.BLUE;
            case 13:
                return ChatColor.GREEN;
            case 14:
                return ChatColor.AQUA;
            case 15:
                return ChatColor.RED;
            case 16:
                return ChatColor.LIGHT_PURPLE;
            case 17:
                return ChatColor.YELLOW;
            case 18:
                return ChatColor.WHITE;
            default:
                return ChatColor.BLACK;
        }
    }
}