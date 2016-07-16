package de.nnl.devathlon_3.spells;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import de.nnl.devathlon_3.util.RecipeUtil;
import de.nnl.devathlon_3.util.SpellUtil;

public class SpellHandler {	
	
	private Map<ItemStack, Spell> spells;
	private List<ShapedRecipe> recipes;
	
	public SpellHandler() {
		spells = new HashMap<ItemStack, Spell>();
		recipes = new ArrayList<ShapedRecipe>();
	}
	
	/**
	 * Add a spell to the game
	 * @param s the Spell
	 */
	public void addSpell(Spell s) {
		ItemStack i = SpellUtil.buildItem(s);
		spells.put(i, s);
		
		ShapedRecipe r = RecipeUtil.buildRecipe(s, i);
		recipes.add(r);
		Bukkit.getServer().addRecipe(r);
	}
	
	/**
	 * Get a Spell from an itemstack
	 * @param i the ItemStack
	 * @return the spell if one exists or null
	 */
	public Spell getSpell(ItemStack i) {
		try {
			ItemStack i2 = i.clone();
			i2.setAmount(1);
			
			return spells.get(i2);
		} catch (Exception e) {}
		
		return null;
	}
	
	/**
	 * Get an itemstack from a spell
	 * @param s the Spell
	 * @return the itemstack if one exists or null
	 */
	public ItemStack getItem(Spell s) {
		try {
			for(ItemStack i: spells.keySet()){
				if(spells.get(i).equals(s)) return i;
			}
		} catch(Exception e) {}
		
		return null;
	}
	
	/**
	 * @return A list of all registered spell-recipes
	 */
	public List<ShapedRecipe> getRecipes() {
		return recipes;
	}
}
