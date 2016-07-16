package de.nnl.devathlon_3.spellbook;

import org.bukkit.Material;
import org.bukkit.entity.Player;
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
	public Material[] getIngredients() {
		return new Material[] {Material.TORCH, Material.TORCH, Material.POTION, Material.BLAZE_ROD, Material.POTION, Material.GLOWSTONE_DUST, Material.GLOWSTONE_DUST};
	}
	
	@Override
	public int getExpCost() {
		return 2;
	}

}
