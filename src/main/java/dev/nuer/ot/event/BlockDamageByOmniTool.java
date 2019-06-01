package dev.nuer.ot.event;

import dev.nuer.ot.nbtapi.NBTItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

/**
 * Class that handles the OmniTool event
 */
public class BlockDamageByOmniTool implements Listener {

    @EventHandler
    public void blockBreak(BlockDamageEvent event) {
        //If the damage event is cancelled stop the task
        if (event.isCancelled()) return;
        //Create nbtitem from the players hand
        NBTItem item = new NBTItem(event.getPlayer().getInventory().getItemInMainHand());
        //Check that the tool is an omni tool
        try {
            if (item.getBoolean("ot.omni")) {
                //Run omni tool code
                OmniFunctionality.changeToolType(event.getBlock(), event.getPlayer());
            }
        } catch (Exception e) {
            //Do nothing, the item is not an omni tool
        }
    }
}
