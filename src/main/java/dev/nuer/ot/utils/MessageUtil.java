package dev.nuer.ot.utils;

import dev.nuer.ot.file.FileManager;
import org.bukkit.entity.Player;

/**
 * Class that handles sending messages
 */
public class MessageUtil {

    /**
     * Send a default message to the player
     *
     * @param path   String, the internal path for the message
     * @param player Player, the player to send the message to
     */
    public static void message(Player player, String path) {
        for (String line : FileManager.get("config").getStringList("messages." + path)) {
            player.sendMessage(ColorUtil.colorize(line));
        }
    }

    /**
     * Send a message to the player which contains 1 placeholder
     *
     * @param path        String, the internal path for the message
     * @param player      Player, the player to send the message to
     * @param placeholder String, the first placeholder
     * @param replacement String, the first replacement
     */
    public static void message(Player player, String path, String placeholder, String replacement) {
        for (String line : FileManager.get("config").getStringList("messages." + path)) {
            player.sendMessage(ColorUtil.colorize(line).replace(placeholder, replacement));
        }
    }
}
