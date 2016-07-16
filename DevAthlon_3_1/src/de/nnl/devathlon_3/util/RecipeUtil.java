package de.nnl.devathlon_3.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import de.nnl.devathlon_3.spells.Spell;
import de.nnl.devathlon_3.spells.SpellHandler;

public class RecipeUtil {
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

	
	public static ItemStack createRecipeBook() {
		ItemStack book = new ItemStack(Material.BOOK);
		ItemMeta bm = book.getItemMeta();
		
		bm.setDisplayName(ChatColor.MAGIC + "--" + ChatColor.RESET + ChatColor.LIGHT_PURPLE + "Zauber-Buch" + ChatColor.RESET + ChatColor.MAGIC + "--");
		List<String> lore = new ArrayList<String>();
		lore.add("von " + ChatColor.GOLD + "Gott");
		bm.setLore(lore);
		
		book.setItemMeta(bm);
		
		return book;
	}
	
	public static Inventory createRecipeInventory(SpellHandler sp) {
		Inventory inv = Bukkit.createInventory(null, 9*3);
		
		applyRecipePageToInventory(sp, 1, inv);
		
		return inv;
	}
	
	public static void applyRecipePageToInventory(SpellHandler sp, int page, Inventory inv) {
		List<ShapedRecipe> recipes = sp.getRecipes();
		if (recipes.size()+1 > page) {
			if (recipes.size() > page) inv.setItem(26, Util.createItemStack(Material.GLOWSTONE_DUST, 1, "N�chste Seite"));
			if (1 < page) inv.setItem(25, Util.createItemStack(Material.GLOWSTONE_DUST, 1, "Vorherige Seite"));
						
			ShapedRecipe r = recipes.get(page-1);
			
			inv.setItem(13, r.getResult());
			for (int y = 0; y < r.getShape().length; y++) {
				for (int x = 0; x < r.getShape()[y].length(); x++) {
					inv.setItem(y * 9 + x, r.getIngredientMap().get(r.getShape()[y].charAt(x)));
				}
			}
			
			
		} else {
			for (int i = 0; i < 27; i++) inv.setItem(i, new ItemStack(Material.BARRIER));
		}
		
	}
}