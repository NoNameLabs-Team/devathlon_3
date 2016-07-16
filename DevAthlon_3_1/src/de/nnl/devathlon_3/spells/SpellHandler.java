package de.nnl.devathlon_3.spells;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class SpellHandler {	
	
	private Map<ItemStack, Spell> spells;
	
	public SpellHandler() {
		spells = new HashMap<ItemStack, Spell>();
	}
	
	public void addSpell(Spell s) {
		ItemStack i = buildItem(s);
		spells.put(i, s);
		
		Bukkit.getServer().addRecipe(buildRecipe(s, i));
	}
	
	public Spell getSpell(ItemStack i) {
		try {
			ItemStack i2 = i.clone();
			i2.setAmount(1);
			
			return spells.get(i2);
		} catch (Exception e) {}
		
		return null;
	}
	
	public ItemStack getItem(Spell s) {
		try {
			for(ItemStack i: spells.keySet()){
				if(spells.get(i).equals(s)) return i;
			}
		} catch(Exception e) {}
		
		return null;
	}
	
	public void removeSpell(Spell s) {
		for(ItemStack i: spells.keySet()){
			if(spells.get(i).equals(s)) spells.remove(i);
		}
	}
	
	public static ShapedRecipe buildRecipe(Spell s, ItemStack item) {
		ShapedRecipe recipe = new ShapedRecipe(item);
		
		Material[] ingredients = s.getIngredients();
		
		String line1, line2, line3;
		
		line1 = ((ingredients.length > 0 && ingredients[0] != null) ? 'a' : ' ') + "1" + ((ingredients.length > 1 && ingredients[1] != null) ? 'b' : ' ');
		line2 = ((ingredients.length > 2 && ingredients[2] != null) ? 'c' : ' ') + ((ingredients.length > 3 && ingredients[3] != null) ? "d" : " ") + ((ingredients.length > 4 && ingredients[4] != null) ? 'e' : ' ');
		line3 = ((ingredients.length > 5 && ingredients[5] != null) ? 'f' : ' ') + "2" + ((ingredients.length > 6 && ingredients[6] != null) ? 'g' : ' ');
		
		recipe.shape(line1, line2, line3);
		
		recipe.setIngredient('1', s.isReusable() ? Material.DIAMOND : Material.COAL_ORE);
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
}
