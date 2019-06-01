package dev.nuer.ot.cmd.sub;

import dev.nuer.ot.OmniTools;
import dev.nuer.ot.event.OmniFunctionality;
import dev.nuer.ot.file.FileManager;
import dev.nuer.ot.utils.MessageUtil;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Class that handles the reload argument of the main command
 */
public class ReloadCmd {

    /**
     * Reloads all internal maps and file configurations for the plugin
     *
     * @param sender CommandSender, person sending the command
     */
    public static void onCmd(CommandSender sender) {
        if (sender instanceof Player) {
            if (sender.hasPermission("omnitools.admin")) {
                //Reload and instantiate all configuration sections
                OmniFunctionality.clearOmniLists();
                FileManager.reload();
                OmniFunctionality.loadOmniToolBlocks();
                MessageUtil.message((Player) sender, "reload");
            } else {
                MessageUtil.message((Player) sender, "no-permission");
            }
        } else {
            //Reload and instantiate all configuration sections
            OmniFunctionality.clearOmniLists();
            FileManager.reload();
            OmniFunctionality.loadOmniToolBlocks();
            OmniTools.LOGGER.info("[OmniTools] Reloaded all tool maps and configuration files.");
        }
    }
}