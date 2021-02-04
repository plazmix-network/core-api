package net.plazmix.core.api.bungee.util;

import com.google.common.collect.Lists;
import net.md_5.bungee.api.ChatColor;

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
}