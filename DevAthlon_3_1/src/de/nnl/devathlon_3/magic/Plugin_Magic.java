package de.nnl.devathlon_3.magic;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import de.nnl.devathlon_3.spellbook.CakeSpell;
import de.nnl.devathlon_3.spellbook.HealSpell_LV1;
import de.nnl.devathlon_3.spellbook.LightSpell;
import de.nnl.devathlon_3.spellbook.SpeedSpell;
import de.nnl.devathlon_3.spellbook.TeleportSpell;
import de.nnl.devathlon_3.spells.SpellHandler;
import de.nnl.devathlon_3.spells.SpellListener;
import de.nnl.devathlon_3.util.RecipeUtil;
import de.nnl.devathlon_3.util.SpellUtil;

public class Plugin_Magic extends JavaPlugin{
	
	SpellHandler spellHandler;
	SpellListener spellListener;
	
	public void onEnable(){
		spellHandler = new SpellHandler();

		spellHandler.addSpell(new CakeSpell());
		spellHandler.addSpell(new SpeedSpell());
		spellHandler.addSpell(new LightSpell());
		spellHandler.addSpell(new HealSpell_LV1());
		spellHandler.addSpell(new TeleportSpell());
		
		spellListener = new SpellListener(spellHandler);
		Bukkit.getPluginManager().registerEvents(spellListener, this);
	}
	
	public void onDisable() {
		HandlerList.unregisterAll(spellListener);
	}
	
	public boolean onCommand(CommandSender sender, Command command, String commandlabel, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			if (p.isOp() && commandlabel.equalsIgnoreCase("rezepte")) {
				p.getInventory().addItem(RecipeUtil.createRecipeBook());
				return true;
			}
		}
		return false;
		
	}
}
