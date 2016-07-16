package de.nnl.devathlon_3.spellbook;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.material.MaterialData;

import de.nnl.devathlon_3.spells.Spell;
import de.nnl.devathlon_3.util.Util;

public class Fel implements Spell{

	public Fel(){}

	@SuppressWarnings("deprecation")
	@Override
	public MaterialData[] getIngredients() {
		return new MaterialData[]{new MaterialData(Material.DIRT, (byte) 1), new MaterialData(Material.DIRT, (byte) 2), new MaterialData(Material.EMERALD), new MaterialData(Material.NETHER_STAR), new MaterialData(Material.EMERALD), new MaterialData(Material.SOUL_SAND), new MaterialData(Material.SOUL_SAND)};
	}

	@Override
	public String getLore() {
		return "Strong magic that destroys live";
	}

	@Override
	public String getName() {
		return ChatColor.DARK_GREEN + "Fel";
	}

	@Override
	public boolean isReusable() {
		return true;
	}

	@Override
	public int getManaCost() {
		return 25;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onRightClick(Player p) {
		
		for(Entity entity : p.getWorld().getEntities()){
            if(entity instanceof LivingEntity){
            	if(!(entity instanceof Player) && !(entity instanceof EnderDragon) && !(entity instanceof Wither))if(Util.distance(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockY(), entity.getLocation().getBlockX(), entity.getLocation().getBlockY(), entity.getLocation().getBlockZ()) <= 12.0)((LivingEntity) entity).setHealth(0);
            }
        }
		
		for(int x = p.getLocation().getBlockX() - 4; x < p.getLocation().getBlockX() + 4; x++){
			for(int y = p.getLocation().getBlockY() - 3; y < p.getLocation().getBlockY() + 3; y++){
				for(int z = p.getLocation().getBlockZ() - 4; z < p.getLocation().getBlockZ() + 4; z++){
					
					Block b = p.getLocation().getWorld().getBlockAt(x, y, z);
					
					if(b.getType() == Material.GRASS)b.setData((byte)(2));
					else if(b.getType() == Material.DIRT)b.setData((byte) 1);
					else if(b.getType() == Material.SAPLING || b.getType() == Material.YELLOW_FLOWER|| b.getType() == Material.RED_ROSE|| b.getType() == Material.YELLOW_FLOWER)b.setType(Material.DEAD_BUSH);
					else if(b.getType() == Material.DOUBLE_PLANT)b.setData((byte) 3);
					else if(b.getType() == Material.LOG ||b.getType() == Material.VINE || b.getType() == Material.LOG_2 || b.getType() == Material.LEAVES || b.getType() == Material.LEAVES_2)b.setType(Material.AIR);
					else if(b.getType() == Material.STONE) b.setType(Material.COBBLESTONE);
					else if(b.getType() == Material.SAND || b.getType() == Material.GRAVEL) b.setType(Material.SOUL_SAND);
					
				}
			}
		}
		
		return true;
	}
	
}