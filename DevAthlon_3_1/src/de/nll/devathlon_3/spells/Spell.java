package de.nll.devathlon_3.spells;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public interface Spell {
	
	public Material[] getIngredients();
	
	public String getLore();
	
	public String getName();
	
	public boolean isReusable();
	
	public int getExpCost();
		
	public void onRightClick(Player p);
}
