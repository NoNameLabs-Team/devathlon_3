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
	
	public void addSpell(Spell s) {
		ItemStack i = SpellUtil.buildItem(s);
		spells.put(i, s);
		
		ShapedRecipe r = RecipeUtil.buildRecipe(s, i);
		recipes.add(r);
		Bukkit.getServer().addRecipe(r);
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
	
	public List<ShapedRecipe> getRecipes() {
		return recipes;
	}
}
