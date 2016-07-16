package de.nnl.devathlon_3.spellbook;

import java.util.HashSet;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import de.nnl.devathlon_3.spells.Spell;

public class TeleportSpell implements Spell{

	public TeleportSpell(){
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onRightClick(Player p) {
		
		p.getWorld().spigot().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1, 0, 0, 0, 0, 0.1f, 10, 2);
		p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 0.5f, 0.5f);
		
		Block b = p.getTargetBlock((HashSet<Byte>) null, 50);
		Location l = new Location(b.getWorld(), b.getX(), b.getY() + 
				1, b.getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
		p.teleport(l);
		p.getWorld().spigot().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1, 0, 0, 0, 0, 0.1f, 10, 2);
		p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 0.5f, 0.5f);
		
		return true;
	}
	
	@Override
	public boolean isReusable() {
		return true;
	}
	
	@Override
	public String getName() {
		return "Teleport";
	}
	
	@Override
	public String getLore() {
		return "Teleports you to the location you are looking at";
	}
	
	@Override
	public MaterialData[] getIngredients() {
		return new MaterialData[] {new MaterialData(Material.ENDER_PEARL), new MaterialData(Material.ENDER_PEARL), new MaterialData(Material.END_ROD), new MaterialData(Material.EYE_OF_ENDER), new MaterialData(Material.END_ROD), new MaterialData(Material.ENDER_STONE), new MaterialData(Material.ENDER_STONE)};
	}
	
	@Override
	public int getManaCost() {
		return 5;
	}
	
}
