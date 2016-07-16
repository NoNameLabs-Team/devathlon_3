package de.nnl.devathlon_3.spellbook;

import java.util.HashSet;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import de.nnl.devathlon_3.spells.Spell;
import de.nnl.devathlon_3.util.Util;

public class LighteningSpell implements Spell{

	public LighteningSpell(){}
	
	@Override
	public MaterialData[] getIngredients() {
		return new MaterialData[]{new MaterialData(Material.GOLD_INGOT), new MaterialData(Material.GOLD_INGOT), new MaterialData(Material.BLAZE_ROD), new MaterialData(Material.IRON_SPADE), new MaterialData(Material.BLAZE_ROD), new MaterialData(Material.IRON_FENCE), new MaterialData(Material.IRON_FENCE)};
	}

	@Override
	public String getLore() {
		return "Summons a mighty lightening";
	}

	@Override
	public String getName() {
		return "Thors Spell";
	}

	@Override
	public boolean isReusable() {
		return true;
	}

	@Override
	public int getManaCost() {
		return 10;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onRightClick(Player p) {
		Location loc = p.getTargetBlock((HashSet<Byte>)null, 100).getLocation();
		p.getWorld().spigot().strikeLightning(loc, false);
		
		for(int x = loc.getBlockX() - (Util.RANDOM.nextInt(10) + 2); x < loc.getBlockX() + Util.RANDOM.nextInt(15) + 2; x++){
			for(int y = loc.getBlockY() - (Util.RANDOM.nextInt(12) + 2); y < loc.getBlockY() + Util.RANDOM.nextInt(8) + 2; y++){
				for(int z = loc.getBlockZ() - (Util.RANDOM.nextInt(11) + 2); z < loc.getBlockZ() + + Util.RANDOM.nextInt(12) + 2; z++){
					
					if(Util.distance(x, y, z, loc.getBlockX()	, loc.getBlockY(), loc.getBlockZ()) <= 6.0 + Util.RANDOM.nextInt(8)){
						loc.getWorld().getBlockAt(new Location(loc.getWorld(), x, y, z)).setType(Material.FIRE);
					}
					
				}
			}
		}
		return true;
	}

}
