package de.nnl.devathlon_3.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtil {
	
	/**
	 * Creates a itemstack with custom name
	 * @param material
	 * @param amount
	 * @param name
	 * @return
	 */
	public static ItemStack createItemStack(Material material, int amount, String name) {
		ItemStack is = new ItemStack(material, amount);
		
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(name);
		is.setItemMeta(im);
		
		return is;
	}
	
	/**
	 * Adds an invisible Enchanted effect to an itemstack
	 * @param is
	 */
	public static void addEnchantedEffect(ItemStack is) {
		ItemMeta im = is.getItemMeta();
		im.addEnchant(Enchantment.DIG_SPEED, 1, true);
		im.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_UNBREAKABLE);
		
		is.setItemMeta(im);
	}
}
