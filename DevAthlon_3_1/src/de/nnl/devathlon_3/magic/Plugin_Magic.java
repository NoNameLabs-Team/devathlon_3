package de.nnl.devathlon_3.magic;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.nnl.devathlon_3.spells.Spell;
import de.nnl.devathlon_3.spells.SpellHandler;
import de.nnl.devathlon_3.spells.SpellListener;

public class Plugin_Magic extends JavaPlugin{
	
	SpellHandler spellHandler;
	SpellListener spellListener;
	
	public void onEnable(){
		spellHandler = new SpellHandler();
		
		spellHandler.addSpell(new Spell() {
			
			@Override
			public void onRightClick(Player p) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10, 2));
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
				return "Speeds you up for 10 Seconds";
			}
			
			@Override
			public Material[] getIngredients() {
				return new Material[] {Material.SUGAR, Material.SUGAR, Material.IRON_BOOTS, null, Material.IRON_BOOTS, Material.SUGAR, Material.SUGAR};
			}
			
			@Override
			public int getExpCost() {
				return 1;
			}
		});
		
		spellListener = new SpellListener(spellHandler);
		Bukkit.getPluginManager().registerEvents(spellListener, this);
	}
	
	public void onDisable() {
		HandlerList.unregisterAll(spellListener);
	}
	

}
