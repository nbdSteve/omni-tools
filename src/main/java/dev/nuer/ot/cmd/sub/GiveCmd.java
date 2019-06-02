package dev.nuer.ot.cmd.sub;

import dev.nuer.ot.OmniTools;
import dev.nuer.ot.file.FileManager;
import dev.nuer.ot.utils.ItemUtil;
import dev.nuer.ot.utils.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Class that handles the give argument of the main command
 */
public class GiveCmd {

    /**
     * Gives the player the specified tool
     *
     * @param sender CommandSender, person sending the command
     * @param args   String[], list of command arguments
     */
    public static void onCmd(CommandSender sender, String[] args) {
        if (sender.hasPermission("omnitools.admin")) {
            try {
                Player target = Bukkit.getPlayer(args[1]);
                if (!Bukkit.getOnlinePlayers().contains(target)) {
                    if (sender instanceof Player) {
                        MessageUtil.message((Player) sender, "invalid-command", "{reason}",
                                "The player you are trying to give that tool to is not online");
                    } else {
                        OmniTools.LOGGER.info("[OmniTools] Invalid command, check the in game help command for command help.");
                    }
                    return;
                }
                ItemUtil.create(args[2],
                        FileManager.get("tools").getString(args[3] + ".name"),
                        FileManager.get("tools").getStringList(args[3] + ".lore"),
                        FileManager.get("tools").getStringList(args[3] + ".enchantments"),
                        FileManager.get("tools").getStringList(args[3] + ".item-flags"),
                        target);
                if (sender instanceof Player) {
                    MessageUtil.message((Player) sender, "give", "{player}", target.getName());
                }
                OmniTools.LOGGER.info("[OmniTools] Success! " + target.getName() + " has received an OmniTool. The tool was given to them by: " + sender.getName());
            } catch (Exception e) {
                e.printStackTrace();
                if (sender instanceof Player) {
                    MessageUtil.message((Player) sender, "invalid-command", "{reason}",
                            "An error occurred. Please check your command syntax, then your configuration (stack trace console)");
                } else {
                    OmniTools.LOGGER.info("[OmniTools] Invalid command, check the in game help command for command help.");
                }
            }
        } else {
            if (sender instanceof Player) {
                MessageUtil.message((Player) sender, "no-permission");
            }
        }
    }
}