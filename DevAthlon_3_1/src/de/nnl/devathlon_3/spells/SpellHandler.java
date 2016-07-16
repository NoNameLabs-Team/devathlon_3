package de.nnl.devathlon_3.spells;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import de.nnl.devathlon_3.util.SpellUtil;

public class SpellHandler {	
	
	private Map<ItemStack, Spell> spells;
	
	public SpellHandler() {
		spells = new HashMap<ItemStack, Spell>();
	}
	
	public void addSpell(Spell s) {
		ItemStack i = SpellUtil.buildItem(s);
		spells.put(i, s);
		
		Bukkit.getServer().addRecipe(SpellUtil.buildRecipe(s, i));
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
}
