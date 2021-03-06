package de.nnl.devathlon_3.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.nnl.devathlon_3.spells.Spell;

public class SpellUtil {

	/**
	 * Creates an item stack from a spell
	 * @param s
	 * @return
	 */
	public static ItemStack buildItem(Spell s) {
		ItemStack is = new ItemStack(s.isReusable() ? Material.BOOK :  Material.PAPER);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.DARK_PURPLE + s.getName());
		List<String> lore_list = new ArrayList<String>();
		lore_list.add(ChatColor.LIGHT_PURPLE + s.getLore());
		lore_list.add(ChatColor.GREEN + "Mana Cost: " + s.getManaCost());
		if (s.isReusable()) {
			lore_list.add(ChatColor.GREEN + "REUSABLE");
		} else {
			lore_list.add(ChatColor.RED + "NOT REUSABLE");
		}
		
		im.setLore(lore_list);
		is.setItemMeta(im);
		
		ItemUtil.addEnchantedEffect(is);
		
		return is;
	}
}
