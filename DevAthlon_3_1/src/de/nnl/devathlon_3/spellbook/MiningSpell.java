package de.nnl.devathlon_3.spellbook;

import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dye;
import org.bukkit.material.MaterialData;

import de.nnl.devathlon_3.spells.Spell;
import de.nnl.devathlon_3.util.Util;

public class MiningSpell implements Spell{

	public MiningSpell(){}
	
	@SuppressWarnings("deprecation")
	@Override
	public MaterialData[] getIngredients() {
		return new MaterialData[]{new MaterialData(Material.GOLD_INGOT), new MaterialData(Material.GOLD_INGOT), new MaterialData(Material.INK_SACK, (byte) 4), new MaterialData(Material.DIAMOND_PICKAXE), new MaterialData(Material.REDSTONE), new MaterialData(Material.IRON_INGOT), new MaterialData(Material.IRON_INGOT),};
	}

	@Override
	public String getLore() {
		return "Mines ore for you in a big radiant";
	}

	@Override
	public String getName() {
		return "MiningSpell";
	}

	@Override
	public boolean isReusable() {
		return true;
	}

	@Override
	public int getManaCost() {
		return 5;
	}

	@Override
	public boolean onRightClick(Player p) {
		for(int x = p.getLocation().getBlockX() - (12 + Util.RANDOM.nextInt(4)); x < p.getLocation().getBlockX() + 12 + + Util.RANDOM.nextInt(15); x++){
			for(int y = p.getLocation().getBlockY() - (12 + Util.RANDOM.nextInt(12)); y < p.getLocation().getBlockY() + 12 + Util.RANDOM.nextInt(8); y++){
				for(int z = p.getLocation().getBlockZ() - (12 + + Util.RANDOM.nextInt(2)); z < p.getLocation().getBlockZ() + 12 + + Util.RANDOM.nextInt(12); z++){
					
					if(Util.distance(x, y, z, p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ()) <= 6.0 + Util.RANDOM.nextInt(8)){
						Block b = p.getLocation().getWorld().getBlockAt(x, y, z);
						
						p.getWorld().spigot().playEffect(p.getLocation(), Effect.FLAME, 1, 0, 0, 0, 0, 0.1f, 10, 20);
						p.getWorld().playSound(p.getLocation(), Sound.BLOCK_FURNACE_FIRE_CRACKLE, 0.5f, 0.5f);
						
						if(b.getType() == Material.DIAMOND_ORE)p.getInventory().addItem(new ItemStack(Material.DIAMOND));
						else if(b.getType() == Material.EMERALD_ORE)p.getInventory().addItem(new ItemStack(Material.EMERALD));
						else if(b.getType() == Material.IRON_ORE)p.getInventory().addItem(new ItemStack(Material.IRON_INGOT));
						else if(b.getType() == Material.GOLD_ORE)p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT));
						else if(b.getType() == Material.COAL_ORE)p.getInventory().addItem(new ItemStack(Material.COAL));
						else if(b.getType() == Material.LAPIS_ORE){
							ItemStack lapis = new ItemStack(Material.INK_SACK);
							Dye dye = new Dye();
							dye.setColor(DyeColor.BLUE);
							lapis.setData(dye);
							p.getInventory().addItem(lapis);
						}
						else if(b.getType() == Material.REDSTONE_ORE)p.getInventory().addItem(new ItemStack(Material.REDSTONE));
					}
					
				}
			}
		}
		return true;
	}

}
