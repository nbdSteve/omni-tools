package dev.nuer.ot.event;

import dev.nuer.ot.nbtapi.NBTItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

public class BlockBreakByOmniTool implements Listener {

    @EventHandler
    public void blockBreak(BlockDamageEvent event) {
        if (event.isCancelled()) return;
        NBTItem item = new NBTItem(event.getPlayer().getInventory().getItemInMainHand());
        try {
            if (item.getBoolean("ot.omni")) {
                OmniFunctionality.changeToolType(event.getBlock(), event.getPlayer());
            }
        } catch (Exception e) {
            return;
        }
    }
}
