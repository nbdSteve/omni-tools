package dev.nuer.ot.utils;

import dev.nuer.ot.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that handles creating and item
 */
public class ItemUtil {

    /**
     * Creates an item from the specified arguments
     *
     * @param material     String, the item material
     * @param name         String, the items name
     * @param lore         List<String>, the lore for the item
     * @param enchantments List<String>, list of enchantments for the item
     * @param flags        List<String>, list of item flags for the item
     * @param player       Player, the player to give the item to
     */
    public static void create(String material, String name, List<String> lore, List<String> enchantments, List<String> flags, Player player) {
        //String[] materialParts = material.split(":");
        //ItemStack item = new ItemStack(Material.getMaterial(materialParts[0].toUpperCase()), 1, Byte.parseByte(materialParts[1]));
        ItemStack item = new ItemStack(Material.getMaterial(material.toUpperCase()));
        ItemMeta itemMeta = item.getItemMeta();
        if (name != null) {
            itemMeta.setDisplayName(ColorUtil.colorize(name));
        }
        List<String> itemLore = new ArrayList<>();
        for (String line : lore) {
            itemLore.add(ColorUtil.colorize(line));
        }
        itemMeta.setLore(itemLore);
        if (enchantments != null) {
            for (String enchantment : enchantments) {
                String[] enchantmentParts = enchantment.split(":");
                itemMeta.addEnchant(Enchantment.getByName(enchantmentParts[0].toUpperCase()),
                        Integer.parseInt(enchantmentParts[1]), true);
            }
        }
        if (flags != null) {
            for (String flag : flags) {
                itemMeta.addItemFlags(ItemFlag.valueOf(flag.toUpperCase()));
            }
        }
        item.setItemMeta(itemMeta);
        NBTItem nbtItem = new NBTItem(item);
        nbtItem.setBoolean("ot.omni", true);
        if (player != null) {
            player.getInventory().addItem(nbtItem.getItem());
        }
    }
}
