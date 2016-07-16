package de.nnl.devathlon_3.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import de.nnl.devathlon_3.spells.Spell;
import de.nnl.devathlon_3.spells.SpellHandler;

public class SpellUtil {
	public static ShapedRecipe buildRecipe(Spell s, ItemStack item) {
		ShapedRecipe recipe = new ShapedRecipe(item);
		
		Material[] ingredients = s.getIngredients();
		
		String line1, line2, line3;
		
		line1 = ((ingredients.length > 0 && ingredients[0] != null) ? 'a' : ' ') + "1" + ((ingredients.length > 1 && ingredients[1] != null) ? 'b' : ' ');
		line2 = ((ingredients.length > 2 && ingredients[2] != null) ? 'c' : ' ') + ((ingredients.length > 3 && ingredients[3] != null) ? "d" : " ") + ((ingredients.length > 4 && ingredients[4] != null) ? 'e' : ' ');
		line3 = ((ingredients.length > 5 && ingredients[5] != null) ? 'f' : ' ') + "2" + ((ingredients.length > 6 && ingredients[6] != null) ? 'g' : ' ');
		
		recipe.shape(line1, line2, line3);
		
		recipe.setIngredient('1', s.isReusable() ? Material.DIAMOND : Material.COAL);
		recipe.setIngredient('2', s.isReusable() ? Material.BOOK : Material.PAPER);
		
		for (int i = 0; i < 7; i++) {
			if (ingredients.length > i && ingredients[i] != null) {
				recipe.setIngredient((char)(i + 'a'), ingredients[i]);
			}
		}
		
		return recipe;
	}
	
	public static ItemStack buildItem(Spell s) {
		ItemStack is = new ItemStack(s.isReusable() ? Material.BOOK :  Material.PAPER);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(ChatColor.DARK_PURPLE + s.getName());
		List<String> lore_list = new ArrayList<String>();
		lore_list.add(ChatColor.LIGHT_PURPLE + s.getLore());
		lore_list.add(ChatColor.GREEN + "Exp Cost: " + s.getExpCost() + " Level");
		
		im.setLore(lore_list);
		is.setItemMeta(im);
		is.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		
		return is;
	}
	
	public static ItemStack createRecipeBook(SpellHandler sp) {
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta bm = (BookMeta) book.getItemMeta();
		
		bm.setTitle(ChatColor.LIGHT_PURPLE + "Zauber-Buch");
		bm.setAuthor("GOTT");
		
		book.setItemMeta(bm);
		
		return book;
	}
}
