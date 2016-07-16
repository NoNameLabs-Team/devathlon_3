package de.nnl.devathlon_3.spells;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import de.nnl.devathlon_3.util.RecipeUtil;
import de.nnl.devathlon_3.util.Util;

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
					if(p.getGameMode() != GameMode.CREATIVE)p.setLevel(p.getLevel() - s.getManaCost());
					
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
	
	@EventHandler
	public void onPlayerInventoryClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		ItemStack item = event.getCurrentItem();
		
		if (item != null && inv.getName().equals("Rezepte")) {
			event.setCancelled(true);
			
			int currpage = Integer.valueOf(inv.getItem(8).getItemMeta().getDisplayName().split(" ")[0]);
			
			if(event.getSlot() == 13 && event.getWhoClicked().getGameMode() == GameMode.CREATIVE){
				
				event.getWhoClicked().getInventory().addItem(event.getClickedInventory().getItem(13));
			}
			
			if (item.equals(Util.createItemStack(Material.GLOWSTONE_DUST, 1, "Vorherige Seite"))) {
				RecipeUtil.applyRecipePageToInventory(spellHandler, currpage - 1, inv);
			} else if (item.equals(Util.createItemStack(Material.GLOWSTONE_DUST, 1, "Nächste Seite"))) {
				RecipeUtil.applyRecipePageToInventory(spellHandler, currpage + 1, inv);
			}
		}
	}
}
