package de.nnl.devathlon_3.magic;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import de.nnl.devathlon_3.spellbook.CakeSpell;
import de.nnl.devathlon_3.spellbook.SpeedSpell;
import de.nnl.devathlon_3.spells.SpellHandler;
import de.nnl.devathlon_3.spells.SpellListener;

public class Plugin_Magic extends JavaPlugin{
	
	SpellHandler spellHandler;
	SpellListener spellListener;
	
	public void onEnable(){
		spellHandler = new SpellHandler();

		spellHandler.addSpell(new CakeSpell());
		spellHandler.addSpell(new SpeedSpell());
		
		spellListener = new SpellListener(spellHandler);
		Bukkit.getPluginManager().registerEvents(spellListener, this);
	}
	
	public void onDisable() {
		HandlerList.unregisterAll(spellListener);
	}
	

}
