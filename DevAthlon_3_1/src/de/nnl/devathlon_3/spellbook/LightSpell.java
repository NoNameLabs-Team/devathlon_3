package de.nnl.devathlon_3.spellbook;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.nnl.devathlon_3.spells.Spell;

public class LightSpell implements Spell{

	public LightSpell(){
		
	}
	
	@Override
	public void onRightClick(Player p) {
		p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 2000, 2));
	}
	
	@Override
	public boolean isReusable() {
		return true;
	}
	
	@Override
	public String getName() {
		return "Light";
	}
	
	@Override
	public String getLore() {
		return "Give you light for 100 Seconds";
	}
	
	@Override
	public MaterialData[] getIngredients() {
		return new MaterialData[] {new MaterialData(Material.TORCH), new MaterialData(Material.TORCH), new MaterialData(Material.POTION), new MaterialData(Material.BLAZE_ROD), new MaterialData(Material.POTION), new MaterialData(Material.GLOWSTONE_DUST), new MaterialData(Material.GLOWSTONE_DUST)};
	}
	
	@Override
	public int getManaCost() {
		return 2;
	}

}
