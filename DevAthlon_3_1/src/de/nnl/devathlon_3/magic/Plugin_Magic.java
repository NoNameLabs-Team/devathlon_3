package de.nnl.devathlon_3.magic;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import de.nnl.devathlon_3.mana.ManaHandler;
import de.nnl.devathlon_3.spellbook.CakeSpell;
import de.nnl.devathlon_3.spellbook.ColorSwap;
import de.nnl.devathlon_3.spellbook.FireSpell;
import de.nnl.devathlon_3.spellbook.LevelToManaSpell;
import de.nnl.devathlon_3.spellbook.ManaSpell;
import de.nnl.devathlon_3.spellbook.TeleportSpell;
import de.nnl.devathlon_3.spellbook.TreeSpell;
import de.nnl.devathlon_3.spellbook.SnowSpell;
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
		spellHandler.addSpell(new TeleportSpell());
		spellHandler.addSpell(new TreeSpell());
		spellHandler.addSpell(new FireSpell());
		spellHandler.addSpell(new SnowSpell());
		spellHandler.addSpell(new ColorSwap());
		spellHandler.addSpell(new LevelToManaSpell(manaHandler));
		spellHandler.addSpell(new ManaSpell(manaHandler));
		
		spellListener = new SpellListener(spellHandler, manaHandler);
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
			
			if (p.hasPermission("magic.recipes") && commandlabel.equalsIgnoreCase("rezepte")) {
				p.getInventory().addItem(RecipeUtil.createRecipeBook());
				return true;
			} else if (p.hasPermission("magic.mana") && commandlabel.equalsIgnoreCase("mana") && args.length > 0) {
				try {
					manaHandler.addMaximumMana(p, Integer.valueOf(args[0]));
				} catch (Exception e) {
					p.sendMessage("The first argument has to be an integer");
				}
				return true;
			}
		}
		return false;
		
	}
}
