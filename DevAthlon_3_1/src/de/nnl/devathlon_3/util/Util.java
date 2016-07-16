package de.nnl.devathlon_3.util;

import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Util {

	public static Random RANDOM;
	public static Logger LOGGER;
	
	static {
		RANDOM = new Random();
		LOGGER = Bukkit.getLogger();
	}
	
	public static ItemStack createItemStack(Material material, int amount, String name) {
		ItemStack is = new ItemStack(material, amount);
		
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(name);
		is.setItemMeta(im);
		
		return is;
	}
}
