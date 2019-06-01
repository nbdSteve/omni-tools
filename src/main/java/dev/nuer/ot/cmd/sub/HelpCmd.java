package dev.nuer.ot.cmd.sub;

import dev.nuer.ot.OmniTools;
import dev.nuer.ot.utils.MessageUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Class that handles the help argument of the main command
 */
public class HelpCmd {

    /**
     * Sends the help message from the configuration
     *
     * @param sender CommandSender, person sending the command
     */
    public static void onCmd(CommandSender sender) {
        if (sender instanceof Player) {
            if (sender.hasPermission("omnitools.help")) {
                MessageUtil.message((Player) sender, "help");
            } else {
                MessageUtil.message((Player) sender, "no-permission");
            }
        } else {
            OmniTools.LOGGER.info("[OmniTools] The help message can only be viewed by players.");
        }
    }
}
