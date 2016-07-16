package de.nnl.devathlon_3.spellbook;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import de.nnl.devathlon_3.mana.ManaHandler;
import de.nnl.devathlon_3.spells.Spell;

public class LevelToMana implements Spell{

	private ManaHandler mh;
	public LevelToMana(ManaHandler mh){
		this.mh = mh;
	}

	@SuppressWarnings("deprecation")
	@Override
	public MaterialData[] getIngredients() {
		return new MaterialData[]{new MaterialData(Material.DIAMOND),new MaterialData(Material.DIAMOND),new MaterialData(Material.GOLDEN_APPLE),new MaterialData(Material.RAW_FISH, (byte) 3),new MaterialData(Material.GOLDEN_APPLE),new MaterialData(Material.EMERALD),new MaterialData(Material.EMERALD)};
	}

	@Override
	public String getLore() {
		return "Converts 5 Level to 2 Maximum Mana";
	}

	@Override
	public String getName() {
		return "Level-Mana-Converter";
	}

	@Override
	public boolean isReusable() {
		return false;
	}

	@Override
	public int getManaCost() {
		return 2;
	}

	@Override
	public boolean onRightClick(Player p) {
		if(p.getLevel() < 5) {
			return false;
		} else {
			p.setLevel(p.getLevel() - 5);
			mh.addMana(p, 2);
			return true;
			
		}
	}
	
}
