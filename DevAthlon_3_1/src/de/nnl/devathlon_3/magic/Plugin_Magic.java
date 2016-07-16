package de.nnl.devathlon_3.magic;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import de.nnl.devathlon_3.mana.ManaHandler;
import de.nnl.devathlon_3.spellbook.CakeSpell;
import de.nnl.devathlon_3.spellbook.HealSpell_LV1;
import de.nnl.devathlon_3.spellbook.LightSpell;
import de.nnl.devathlon_3.spellbook.SpeedSpell;
import de.nnl.devathlon_3.spellbook.TeleportSpell;
import de.nnl.devathlon_3.spellbook.TreeSpell;
import de.nnl.devathlon_3.spells.SpellHandler;
import de.nnl.devathlon_3.spells.SpellListener;
import de.nnl.devathlon_3.util.RecipeUtil;

public class Plugin_Magic extends JavaPlugin{
	
	SpellHandler spellHandler;
	SpellListener spellListener;
	ManaHandler manaHandler;
	
	public void onEnable(){
		spellHandler = new SpellHandler();
		manaHandler = new ManaHandler(this);
		
		spellHandler.addSpell(new CakeSpell());
		spellHandler.addSpell(new SpeedSpell());
		spellHandler.addSpell(new LightSpell());
		spellHandler.addSpell(new HealSpell_LV1());
		spellHandler.addSpell(new TeleportSpell());
		spellHandler.addSpell(new TreeSpell());
		
		spellListener = new SpellListener(spellHandler);
		Bukkit.getPluginManager().registerEvents(spellListener, this);
		Bukkit.getPluginManager().registerEvents(manaHandler, this);
	}
	
	public void onDisable() {
		manaHandler.saveMana();
		
		HandlerList.unregisterAll(spellListener);
		HandlerList.unregisterAll(manaHandler);
		Bukkit.getServer().resetRecipes();
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
