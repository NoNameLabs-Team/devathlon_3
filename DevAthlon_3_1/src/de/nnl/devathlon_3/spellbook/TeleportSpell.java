package de.nnl.devathlon_3.spellbook;

import java.util.HashSet;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import de.nnl.devathlon_3.spells.Spell;

public class TeleportSpell implements Spell{

	public TeleportSpell(){
		
	}
	//DA
	
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
		return "Teleports you to the location you are looking at";
	}
	
	@Override
	public Material[] getIngredients() {
		return new Material[] {Material.ENDER_PEARL, Material.ENDER_PEARL, Material.END_ROD, Material.EYE_OF_ENDER, Material.END_ROD, Material.ENDER_STONE, Material.ENDER_STONE};
	}
	
	@Override
	public int getManaCost() {
		return 5;
	}
	
}