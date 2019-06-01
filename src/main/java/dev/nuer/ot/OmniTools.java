package dev.nuer.ot;

import dev.nuer.ot.cmd.OtCmd;
import dev.nuer.ot.event.BlockDamageByOmniTool;
import dev.nuer.ot.event.OmniFunctionality;
import dev.nuer.ot.file.FileManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Main class for OmniTools
 */
public final class OmniTools extends JavaPlugin {
    //Store instance
    public static OmniTools instance;
    //Plugin logger
    public static Logger LOGGER;

    @Override
    public void onEnable() {
        instance = this;
        FileManager.load();
        OmniFunctionality.loadOmniToolBlocks();
        getCommand("omnitools").setExecutor(new OtCmd(this));
        getServer().getPluginManager().registerEvents(new BlockDamageByOmniTool(), this);
    }

    @Override
    public void onDisable() {
        OmniFunctionality.clearOmniLists();
    }
}
