package de.nnl.devathlon_3.spellbook;

import org.bukkit.Material;
import org.bukkit.entity.Player;
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
	public Material[] getIngredients() {
		return new Material[] {Material.GHAST_TEAR, Material.GHAST_TEAR, Material.GOLDEN_CARROT, Material.GOLDEN_APPLE, Material.GOLDEN_CARROT, Material.SPECKLED_MELON, Material.SPECKLED_MELON};
	}
	
	@Override
	public int getExpCost() {
		return 10;
	}

}
