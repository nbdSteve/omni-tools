package dev.nuer.ot.utils;

import org.bukkit.ChatColor;

public class ColorUtil {

    /**
     * Will apply the Bukkit color codes to the specified message
     *
     * @param message String, the message to colorize
     * @return String
     */
    public static String apply(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
