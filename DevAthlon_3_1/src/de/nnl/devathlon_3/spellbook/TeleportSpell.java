package de.nnl.devathlon_3.spellbook;

import java.util.HashSet;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import de.nnl.devathlon_3.spells.Spell;

public class TeleportSpell implements Spell{

	public TeleportSpell(){
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onRightClick(Player p) {
		Block b = p.getTargetBlock((HashSet<Byte>) null, 50);
		Location l = new Location(b.getWorld(), b.getX(), b.getY() + 1, b.getZ(), p.getLocation().getYaw(), p.getLocation().getPitch());
		p.teleport(l);
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
		return "Teleportiert dich an die Stelle an die du guckst!";
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
