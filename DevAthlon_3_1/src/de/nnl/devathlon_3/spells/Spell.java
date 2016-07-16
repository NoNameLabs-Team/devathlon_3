package de.nnl.devathlon_3.spells;

import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

public interface Spell {
	
	public MaterialData[] getIngredients();
	
	public String getLore();
	
	public String getName();
	
	public boolean isReusable();
	
	public int getManaCost();
		
	public boolean onRightClick(Player p);
}
