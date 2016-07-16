package de.nnl.devathlon_3.spellbook;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.nnl.devathlon_3.spells.Spell;

public class HealSpell_LV1 implements Spell{

	//DA
	public HealSpell_LV1(){
		
	}
	
	@Override
	public void onRightClick(Player p) {
		p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1000, 5));
		p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 10));
		p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 500, 3));
		p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 35, 3));
	}
	
	@Override
	public boolean isReusable() {
		return true;
	}
	
	@Override
	public String getName() {
		return "Heal";
	}
	
	@Override
	public String getLore() {
		return "Heals you up";
	}
	
	@Override
	public MaterialData[] getIngredients() {
		return new MaterialData[] {new MaterialData(Material.GHAST_TEAR), new MaterialData(Material.GHAST_TEAR), new MaterialData(Material.GOLDEN_CARROT), new MaterialData(Material.GOLDEN_APPLE), new MaterialData(Material.GOLDEN_CARROT), new MaterialData(Material.SPECKLED_MELON), new MaterialData(Material.SPECKLED_MELON)};
	}
	
	@Override
	public int getManaCost() {
		return 10;
	}

}
