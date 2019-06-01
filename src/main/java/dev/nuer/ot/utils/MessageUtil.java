package dev.nuer.ot.utils;

import dev.nuer.ot.file.FileManager;
import org.bukkit.entity.Player;

public class MessageUtil {

    /**
     * Send a default message to the player
     *
     * @param path String, the internal path for the message
     * @param player   Player, the player to send the message to
     */
    public static void message(Player player, String path) {
        for (String line : FileManager.get("config").getStringList("messages." + path)) {
            player.sendMessage(ColorUtil.apply(line));
        }
    }

    public static void message(Player player, String path, String placeholder, String replacement) {
        for (String line : FileManager.get("config").getStringList("messages." + path)) {
            player.sendMessage(ColorUtil.apply(line).replace(placeholder, replacement));
        }
    }
}
