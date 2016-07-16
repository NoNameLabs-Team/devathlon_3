package de.nnl.devathlon_3.spells;

import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

public interface Spell {
	
	/**
	 * @return an Array of MateriialData for the crafting recipe 
	 * (TOP-Left, Top-Right, LeftMiddle, Middle-Middle, Right-Middle, Bottom-Left, Bottom-Right)
	 */
	public MaterialData[] getIngredients();
	
	/**
	 * @return the lore of the item
	 */
	public String getLore();
	
	/**
	 * @return the name of the spell
	 */
	public String getName();
	
	/**
	 * @return if the spell is reusable (won't break after one use)
	 */
	public boolean isReusable();
	
	/**
	 * @return the cost of mana
	 */
	public int getManaCost();
		
	/**
	 * Called when a Player rightclicks with the item of the spell
	 * @param p the Player that rightclicked
	 * @return if the spell has successfully been executed
	 */
	public boolean onRightClick(Player p);
}
