package de.nnl.devathlon_3.spellbook;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import de.nnl.devathlon_3.spells.Spell;
import de.nnl.devathlon_3.util.ProjectileUtil;

public class WaterSpell implements Spell{

	public WaterSpell(){}

	@Override
	public MaterialData[] getIngredients() {
		return new MaterialData[]{new MaterialData(Material.PRISMARINE_SHARD), new MaterialData(Material.PRISMARINE_CRYSTALS), new MaterialData(Material.ICE), new MaterialData(Material.ICE), new MaterialData(Material.SNOW), new MaterialData(Material.SNOW)};
	}

	@Override
	public String getLore() {
		return "Shoots a snowball";
	}

	@Override
	public String getName() {
		return "SnowBall";
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
	public void onRightClick(Player p) {
		ProjectileUtil.fireProjectile(p, EntityType.SNOWBALL, 2.0, 0.0);
		for(int x = p.getLocation().getBlockX() - 4; x < p.getLocation().getBlockX() + 4; x++){
			for(int y = p.getLocation().getBlockY() - 4; y < p.getLocation().getBlockY() + 4; y++){
				for(int z = p.getLocation().getBlockZ() - 4; z < p.getLocation().getBlockZ() + 4; z++){
					
					if(p.getLocation().getWorld().getBlockAt(x, y, z).getType() == Material.FIRE){
						p.getLocation().getWorld().getBlockAt(x, y, z).setType(Material.AIR);
					}
					
				}
			}
		}
	}
	
}
