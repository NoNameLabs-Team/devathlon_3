package de.nnl.devathlon_3.spellbook;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.nnl.devathlon_3.spells.Spell;

public class CakeSpell implements Spell{

	public CakeSpell(){
		
	}
	
	@Override
	public Material[] getIngredients() {
		return new Material[] {Material.MILK_BUCKET, Material.MILK_BUCKET, Material.SUGAR, Material.CAKE, Material.SUGAR, Material.WHEAT, Material.WHEAT};
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
		p.sendMessage("The cake is a lie");
	}

}
