package de.nnl.devathlon_3.spellbook;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.material.MaterialData;

import de.nnl.devathlon_3.spells.Spell;
import de.nnl.devathlon_3.util.Util;

public class ColorSwap implements Spell{

	public ColorSwap(){}

	@SuppressWarnings("deprecation")
	@Override
	public MaterialData[] getIngredients() {
		return new MaterialData[]{new MaterialData(Material.WOOL, (byte) 1), new MaterialData(Material.WOOL, (byte) 12), new MaterialData(Material.WOOL, (byte) 15), new MaterialData(Material.WOOL, (byte) 14), new MaterialData(Material.WOOL, (byte) 3), new MaterialData(Material.WOOL, (byte) 11), new MaterialData(Material.WOOL, (byte) 6)};
	}

	@Override
	public String getLore() {
		return "Gives sheeps in a 12 block radiant a random colors";
	}

	@Override
	public String getName() {
		return "ColorSwap";
	}

	@Override
	public boolean isReusable() {
		return false;
	}

	@Override
	public int getManaCost() {
		return 6;
	}

	@Override
	public boolean onRightClick(Player p) {
		for(Entity entity : p.getWorld().getEntities()){
            if(entity instanceof Sheep){
            	p.getWorld().spigot().playEffect(entity.getLocation(), Effect.COLOURED_DUST, 1, 0, 0, 0, 0, 0.1f, 10, 2);
            	if(Util.distance(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ(), entity.getLocation().getBlockX(), entity.getLocation().getBlockY(), entity.getLocation().getBlockZ()) <= 12.0)((Sheep) entity).setColor(Util.randomDyeColor());
            }
        }
		
		return true;
	}
	
}
