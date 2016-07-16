package de.nnl.devathlon_3.spellbook;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;
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
	public MaterialData[] getIngredients() {
		return new MaterialData[] {new MaterialData(Material.SUGAR), new MaterialData(Material.SUGAR), new MaterialData(Material.IRON_BOOTS), null, new MaterialData(Material.IRON_BOOTS), new MaterialData(Material.SUGAR), new MaterialData(Material.SUGAR)};
	}
	
	@Override
	public int getManaCost() {
		return 1;
	}
	
}
