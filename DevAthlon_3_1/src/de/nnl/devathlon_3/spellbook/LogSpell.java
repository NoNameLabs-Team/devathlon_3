package de.nnl.devathlon_3.spellbook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import de.nnl.devathlon_3.spells.Spell;

public class LogSpell implements Spell{

	public LogSpell(){}
	
	@Override
	public MaterialData[] getIngredients() {
		return new MaterialData[]{new MaterialData(Material.CHEST), new MaterialData(Material.CHEST), new MaterialData(Material.LEATHER_CHESTPLATE), new MaterialData(Material.DIAMOND_AXE), new MaterialData(Material.LEATHER_CHESTPLATE), new MaterialData(Material.LOG), new MaterialData(Material.LOG)};
	}

	@Override
	public String getLore() {
		return "Harvest magicly a tree";
	}

	@Override
	public String getName() {
		return "LogFeller";
	}

	@Override
	public boolean isReusable() {
		return true;
	}

	@Override
	public int getManaCost() {
		return 8;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onRightClick(Player p) {
		Block b = p.getTargetBlock((HashSet<Byte>)null, 3);
		
		if(b.getType() != Material.LOG && b.getType() != Material.LOG_2)return false;
		else{
		
			List<Block> logs = new ArrayList<>();
			logs.add(b);
			getWood(logs, b);
			
			for(Block b2: logs){
				
				p.getInventory().addItem(new ItemStack(Material.WOOD, 1, b2.getData()));
				b2.setType(Material.AIR);
				
			}
			
			return true;
		}
	}

	private void getWood(List<Block> logs, Block b){
		for(int x = b.getLocation().getBlockX() - 2; x < b.getLocation().getBlockX() + 2; x++){
			for(int y = b.getLocation().getBlockY() - 2; y < b.getLocation().getBlockY() + 2; y++){
				for(int z = b.getLocation().getBlockZ() - 2; z < b.getLocation().getBlockZ() + 2; z++){
					
					Block b2 = b.getWorld().getBlockAt(x, y, z);
					
					if(b2.getType() == Material.LOG || b2.getType() == Material.LOG_2){
						if(!logs.contains(b2)){
							logs.add(b2);
							getWood(logs, b2);
						}
					}
					
				}
			}
		}
	}
	
}
