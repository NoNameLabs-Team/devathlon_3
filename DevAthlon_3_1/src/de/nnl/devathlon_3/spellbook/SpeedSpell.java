package de.nnl.devathlon_3.spellbook;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.nnl.devathlon_3.spells.Spell;

public class SpeedSpell implements Spell{

	public SpeedSpell(){
		
	}
	
	@Override
	public void onRightClick(Player p) {
		p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2000, 2));
	}
	
	@Override
	public boolean isReusable() {
		return true;
	}
	
	@Override
	public String getName() {
		return "Speed";
	}
	
	@Override
	public String getLore() {
		return "Speeds you up for 100 Seconds";
	}
	
	@Override
	public Material[] getIngredients() {
		return new Material[] {Material.SUGAR, Material.SUGAR, Material.IRON_BOOTS, null, Material.IRON_BOOTS, Material.SUGAR, Material.SUGAR};
	}
	
	@Override
	public int getManaCost() {
		return 1;
	}
	
}
