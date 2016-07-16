package de.nnl.devathlon_3.spells;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import de.nnl.devathlon_3.util.RecipeUtil;
import de.nnl.devathlon_3.util.SpellUtil;

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
				
				if (s.getManaCost() <= p.getLevel()) {
					p.setLevel(p.getLevel() - s.getManaCost());
					
					if (!s.isReusable()) {
						if (i.getAmount() == 1) {
							//TODO: REMOVE ITEM
						} else {
							i.setAmount(i.getAmount() - 1);
						}
					}
					
					//TODO: BETTER SOUND!w
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_HAT, 0.5f, 0.5f);
					s.onRightClick(p);
				} else {
					p.playSound(p.getLocation(), Sound.BLOCK_LAVA_POP, 0.5f, 0.5f);
				}
			}
		}
		
		if (i != null && i.getType() == Material.BOOK && i.equals(RecipeUtil.createRecipeBook())) {
			e.setCancelled(true);
			p.openInventory(RecipeUtil.createRecipeInventory(spellHandler));
		}
	}
}
