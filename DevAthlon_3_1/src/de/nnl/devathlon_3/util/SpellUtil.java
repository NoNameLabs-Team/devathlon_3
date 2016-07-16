package de.nnl.devathlon_3.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.nnl.devathlon_3.spells.Spell;

public class SpellUtil {
	
	public static ItemStack buildItem(Spell s) {
		ItemStack is = new ItemStack(s.isReusable() ? Material.BOOK :  Material.PAPER);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.DARK_PURPLE + s.getName());
		List<String> lore_list = new ArrayList<String>();
		lore_list.add(ChatColor.LIGHT_PURPLE + s.getLore());
		lore_list.add(ChatColor.GREEN + "Mana Cost: " + s.getManaCost() + " Level");
		
		im.setLore(lore_list);
		is.setItemMeta(im);
		is.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		
		return is;
	}
}
