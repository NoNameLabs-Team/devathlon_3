package de.nnl.devathlon_3.spellbook;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.nnl.devathlon_3.spells.Spell;
import de.nnl.devathlon_3.util.Util;

public class FelSpell implements Spell{

	public FelSpell(){}

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
		
		p.getWorld().playSound(p.getLocation(), Sound.ENTITY_WITHER_DEATH, 0.5f, 0.5f);
		p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20 * 210, 3));
		
		for(Entity entity : p.getWorld().getEntities()){
            if(entity instanceof LivingEntity){
            	if(!(entity instanceof Player) && !(entity instanceof EnderDragon) && !(entity instanceof Wither)) {
            		if(Util.distance(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ(), entity.getLocation().getBlockX(), entity.getLocation().getBlockY(), entity.getLocation().getBlockZ()) <= 12.0) {
                		p.getWorld().spigot().playEffect(entity.getLocation(), Effect.HAPPY_VILLAGER, 1, 0, 0, 0, 0, 0.1f, 10, 2);
                		((LivingEntity) entity).setHealth(0);
                	}
            	}
            }
        }
		
		for(int x = p.getLocation().getBlockX() - (12 + Util.RANDOM.nextInt(4)); x < p.getLocation().getBlockX() + 12 + + Util.RANDOM.nextInt(15); x++){
			for(int y = p.getLocation().getBlockY() - (12 + Util.RANDOM.nextInt(12)); y < p.getLocation().getBlockY() + 12 + Util.RANDOM.nextInt(8); y++){
				for(int z = p.getLocation().getBlockZ() - (12 + + Util.RANDOM.nextInt(2)); z < p.getLocation().getBlockZ() + 12 + + Util.RANDOM.nextInt(12); z++){
					
					if(Util.distance(x, y, z, p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ()) <= 6.0 + Util.RANDOM.nextInt(8)){
						Block b = p.getLocation().getWorld().getBlockAt(x, y, z);
						
						if(b.getType() != Material.AIR){
							p.getWorld().spigot().playEffect(new Location(b.getWorld(), b.getLocation().getX(), b.getLocation().getY() + 1, b.getLocation().getZ()), Effect.HAPPY_VILLAGER, 1, 0, 0, 0, 0, 0.1f, 10, 2);
						
							if(b.getType() == Material.GRASS){
								b.setType(Material.DIRT);
								b.setData((byte)(2));
							}
							else if(b.getType() == Material.DIRT)b.setData((byte) 1);
							else if(b.getType() == Material.SAPLING || b.getType() == Material.YELLOW_FLOWER|| b.getType() == Material.RED_ROSE|| b.getType() == Material.YELLOW_FLOWER)b.setType(Material.DEAD_BUSH);
							else if(b.getType() == Material.DOUBLE_PLANT)b.setType(Material.REDSTONE);
							else if(b.getType() == Material.LOG || b.getType() == Material.LOG_2){
								if(Util.RANDOM.nextInt(10) < 3)b.setType(Material.HUGE_MUSHROOM_1);
								else b.setType(Material.AIR);
							}
							else if(b.getType() == Material.LEAVES || b.getType() == Material.WATER_LILY ||b.getType() == Material.VINE || b.getType() == Material.LEAVES_2)
								if(Util.RANDOM.nextInt(10) < 3)b.setType(Material.HUGE_MUSHROOM_2);
								else b.setType(Material.AIR);
							else if(b.getType() == Material.STONE) b.setType(Material.COBBLESTONE);
							else if(b.getType() == Material.LONG_GRASS){
								switch(Util.RANDOM.nextInt(2)){
								case 0:
									b.setType(Material.WEB);
									break;
								case 1:
									b.setType(Material.FIRE);
									break;
								}
							}
							else if(b.getType() == Material.SAND || b.getType() == Material.GRAVEL) b.setType(Material.SOUL_SAND);
							else if(b.getType() == Material.WATER)b.setType(Material.LAVA);
							else if(b.getType() == Material.STATIONARY_WATER) b.setType(Material.STATIONARY_LAVA);
						}
					}
					
				}
			}
		}
		
		return true;
	}
	
}
