package utils;

import org.bukkit.ChatColor;

public class ColorUtils {
    public static String colorMsg(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
