package dev.nuer.ot.cmd;

import dev.nuer.ot.OmniTools;
import dev.nuer.ot.cmd.sub.GiveCmd;
import dev.nuer.ot.cmd.sub.HelpCmd;
import dev.nuer.ot.cmd.sub.ReloadCmd;
import dev.nuer.ot.utils.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OtCmd implements CommandExecutor {

    public OtCmd(OmniTools omniTools) {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("omnitools")) {
            if (args.length == 0) {
                HelpCmd.onCmd(sender);
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("h") || args[0].equalsIgnoreCase("help")) {
                    HelpCmd.onCmd(sender);
                }
                if (args[0].equalsIgnoreCase("r") || args[0].equalsIgnoreCase("reload")) {
                    ReloadCmd.onCmd(sender);
                }
            } else if (args.length == 4) {
                if (args[0].equalsIgnoreCase("g") || args[0].equalsIgnoreCase("give")) {
                    GiveCmd.onCmd(sender, args);
                }
            } else {
                if (sender instanceof Player) {
                    MessageUtil.message((Player) sender, "invalid-command", "{reason}",
                            "An error occurred. Please check your command syntax, then your configuration (stack trace console)");
                } else {
                    OmniTools.LOGGER.info("[OmniTools] Invalid command, check the GitHub wiki for command help.");
                }
            }
        }
        return true;
    }
}