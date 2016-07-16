package de.nnl.devathlon_3.spellbook;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import de.nnl.devathlon_3.mana.ManaHandler;
import de.nnl.devathlon_3.spells.Spell;

public class ManaSpell implements Spell {
	private ManaHandler manaHandler;
	
	public ManaSpell(ManaHandler manaHandler) {
		this.manaHandler = manaHandler;
	}
	
	
	@Override
	public MaterialData[] getIngredients() {
		return new MaterialData[] {new MaterialData(Material.RED_ROSE), new MaterialData(Material.RED_ROSE), new MaterialData(Material.CARROT), new MaterialData(Material.APPLE), new MaterialData(Material.POTATO), new MaterialData(Material.YELLOW_FLOWER), new MaterialData(Material.YELLOW_FLOWER)};
	}

	@Override
	public String getLore() {
		return "Refills 10 Mana";
	}

	@Override
	public String getName() {
		return "ManaRefill";
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
	public boolean onRightClick(Player p) {
		return manaHandler.addMana(p, 10);		
	}

}
