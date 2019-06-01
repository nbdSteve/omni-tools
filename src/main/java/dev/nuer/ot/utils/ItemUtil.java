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

public class ItemUtil {

    public static void create(String material, String name, List<String> lore, List<String> enchantments, List<String> flags, Player player) {
        String[] materialParts = material.split(":");
        ItemStack item = new ItemStack(Material.getMaterial(materialParts[0].toUpperCase()), 1, Byte.parseByte(materialParts[1]));
        ItemMeta itemMeta = item.getItemMeta();
        if (name != null) {
            itemMeta.setDisplayName(ColorUtil.apply(name));
        }
        List<String> itemLore = new ArrayList<>();
        for (String line : lore) {
            itemLore.add(ColorUtil.apply(line));
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
