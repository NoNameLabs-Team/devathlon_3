package de.nnl.devathlon_3.spells;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SpellListener implements Listener {
	
	private SpellHandler spellHandler;
	
	public SpellListener(SpellHandler spellHandler) {
		this.spellHandler = spellHandler;
	}
		
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		ItemStack i = e.getItem();
		Player p = e.getPlayer();
		
		if (i != null && e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Spell s = spellHandler.getSpell(i);
			
			if (s != null) {
				e.setCancelled(true);
				
				if (s.getExpCost() <= p.getLevel()) {
					p.setLevel(p.getLevel() - s.getExpCost());
					
					if (!s.isReusable()) i.setAmount(i.getAmount() - 1);
					
					s.onRightClick(p);
					p.sendMessage(ChatColor.GREEN + "Du hast " + s.getName() + " benutzt! :D");
				} else {
					p.sendMessage(ChatColor.RED + "Nicht genug Level!");
				}
			}
		}
	}
}
