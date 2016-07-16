package de.nnl.devathlon_3.spellbook;

import java.util.HashSet;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import de.nnl.devathlon_3.spells.Spell;

public class LighteningSpell implements Spell{

	public LighteningSpell(){}
	
	@Override
	public MaterialData[] getIngredients() {
		return new MaterialData[]{new MaterialData(Material.GOLD_INGOT), new MaterialData(Material.GOLD_INGOT), new MaterialData(Material.BLAZE_ROD), new MaterialData(Material.IRON_SPADE), new MaterialData(Material.BLAZE_ROD), new MaterialData(Material.IRON_FENCE), new MaterialData(Material.IRON_FENCE)};
	}

	@Override
	public String getLore() {
		return "Summons a mighty lightening";
	}

	@Override
	public String getName() {
		return "Thors Spell";
	}

	@Override
	public boolean isReusable() {
		return true;
	}

	@Override
	public int getManaCost() {
		return 10;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onRightClick(Player p) {
		p.getWorld().strikeLightning(p.getTargetBlock((HashSet<Byte>)null, 100).getLocation());
		return true;
	}

}
