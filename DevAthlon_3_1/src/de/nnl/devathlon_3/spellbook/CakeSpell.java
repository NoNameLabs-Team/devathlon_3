package de.nnl.devathlon_3.spellbook;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import de.nnl.devathlon_3.spells.Spell;

public class CakeSpell implements Spell{

	public CakeSpell(){
		
	}
	
	@Override
	public MaterialData[] getIngredients() {
		return new MaterialData[] {new MaterialData(Material.MILK_BUCKET), new MaterialData(Material.MILK_BUCKET), new MaterialData(Material.SUGAR), new MaterialData(Material.CAKE), new MaterialData(Material.SUGAR), new MaterialData(Material.WHEAT), new MaterialData(Material.WHEAT)};
	}

	@Override
	public String getLore() {
		return "The cake is a lie";
	}

	@Override
	public String getName() {
		return "CakeSpell";
	}

	@Override
	public boolean isReusable() {
		return false;
	}

	@Override
	public int getManaCost() {
		return 0;
	}

	@Override
	public void onRightClick(Player p) {
		p.sendMessage(ChatColor.RED + "The cake is a lie");
	}

}
