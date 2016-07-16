package de.nnl.devathlon_3.spellbook;

import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import de.nnl.devathlon_3.spells.Spell;

public class SnowSpell implements Spell{

	public SnowSpell(){}

	@Override
	public MaterialData[] getIngredients() {
		return new MaterialData[]{new MaterialData(Material.PRISMARINE_SHARD), new MaterialData(Material.PRISMARINE_CRYSTALS), new MaterialData(Material.ICE), new MaterialData(Material.WATER_BUCKET), new MaterialData(Material.ICE), new MaterialData(Material.SNOW_BLOCK), new MaterialData(Material.SNOW_BLOCK)};
	}

	@Override
	public String getLore() {
		return "Cold here";
	}

	@Override
	public String getName() {
		return Color.AQUA + "Snow";
	}

	@Override
	public boolean isReusable() {
		return true;
	}

	@Override
	public int getManaCost() {
		return 4;
	}

	@Override
	public boolean onRightClick(Player p) {
		p.getWorld().playEffect(p.getLocation(), Effect.EXTINGUISH, 1);
		
		for(int x = p.getLocation().getBlockX() - 4; x < p.getLocation().getBlockX() + 4; x++){
			for(int y = p.getLocation().getBlockY() - 1; y < p.getLocation().getBlockY() + 1; y++){
				for(int z = p.getLocation().getBlockZ() - 4; z < p.getLocation().getBlockZ() + 4; z++){
					
					Block b = p.getLocation().getWorld().getBlockAt(x, y, z);
					
					if(b.getType() == Material.FIRE)b.setType(Material.AIR);
					else if(b.getType() == Material.WATER || b.getType() == Material.STATIONARY_WATER)b.setType(Material.ICE);
					else if(b.getType() == Material.LAVA || b.getType() == Material.STATIONARY_LAVA)b.setType(Material.OBSIDIAN);
					
				}
			}
		}
		
		return true;
	}
	
}
