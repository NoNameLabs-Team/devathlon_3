package de.nnl.devathlon_3.spellbook;

import java.util.HashSet;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.material.Dye;
import org.bukkit.material.MaterialData;

import de.nnl.devathlon_3.spells.Spell;
import de.nnl.devathlon_3.util.Util;

public class TreeSpell implements Spell{

	public TreeSpell(){}

	@Override
	public String getLore() {
		return "Generates a random tree";
	}

	@Override
	public String getName() {
		return ChatColor.GREEN + "TreeSpell";
	}

	@Override
	public boolean isReusable() {
		return false;
	}

	@Override
	public int getManaCost() {
		return 15;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onRightClick(Player p) {
		Block b = p.getTargetBlock((HashSet<Byte>) null, 15);
		
		Location l;
		if(b.getType() != Material.AIR)l = new Location(b.getWorld(), b.getX(), b.getY(), b.getZ());
		else l = new Location(b.getWorld(), b.getX(), b.getY() + 1, b.getZ());
		TreeType type = TreeType.TREE;
		
		switch(Util.RANDOM.nextInt(13)){
		
		case(0):
			type = TreeType.ACACIA;
			break;
		case(1):
			type = TreeType.BIG_TREE;
			break;
		case(2):
			type = TreeType.BIRCH;
			break;
		case(3):
			type = TreeType.COCOA_TREE;
			break;
		case(4):
			type = TreeType.DARK_OAK;
			break;
		case(5):
			type = TreeType.JUNGLE;
			break;
		case(6):
			type = TreeType.JUNGLE_BUSH;
			break;
		case(7):
			type = TreeType.MEGA_REDWOOD;
			break;
		case(8):
			type = TreeType.REDWOOD;
			break;
		case(9):
			type = TreeType.SMALL_JUNGLE;
			break;
		case(10):
			type = TreeType.SWAMP;
			break;
		case(11):
			type = TreeType.TALL_BIRCH;
			break;
		case(12):
			type = TreeType.TALL_REDWOOD;
			break;
		}
		
		if(l.getBlock().getWorld().generateTree(l, type)){
			p.getWorld().spigot().playEffect(b.getLocation(), Effect.CLOUD, 1, 0, 0, 0, 0, 0.1f, 10, 18);
			return true;
		}
		else return false;
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public MaterialData[] getIngredients() {
		return new MaterialData[]{new MaterialData(Material.LEAVES, (byte) 2), new MaterialData(Material.LEAVES, (byte) 3), new MaterialData(Material.LOG), new MaterialData(new Dye(DyeColor.BROWN).getItemType()), new MaterialData(Material.LOG_2), new MaterialData(Material.SAPLING, (byte) 1), new MaterialData(Material.SAPLING, (byte) 5)};
	}

}
