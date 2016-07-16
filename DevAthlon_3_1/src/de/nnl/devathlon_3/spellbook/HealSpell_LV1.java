package de.nnl.devathlon_3.spellbook;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.nnl.devathlon_3.spells.Spell;

public class HealSpell_LV1 implements Spell{

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
		return "Light";
	}
	
	@Override
	public String getLore() {
		return "Give you light for 100 Seconds";
	}
	
	@Override
	public Material[] getIngredients() {
		return new Material[] {Material.TORCH, Material.TORCH, Material.POTION, Material.BLAZE_ROD, Material.POTION, Material.GLOWSTONE_DUST, Material.GLOWSTONE_DUST};
	}
	
	@Override
	public int getExpCost() {
		return 10;
	}

}
