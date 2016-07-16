package de.nnl.devathlon_3.spellbook;

import java.util.HashSet;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import de.nnl.devathlon_3.spells.Spell;
import de.nnl.devathlon_3.util.ProjectileUtil;
import de.nnl.devathlon_3.util.Util;

public class ArrowSpell implements Spell {
	Plugin plugin;
	
	public ArrowSpell(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public MaterialData[] getIngredients() {
		return new MaterialData[] {new MaterialData(Material.ARROW), new MaterialData(Material.ARROW), new MaterialData(Material.BOW), new MaterialData(Material.SKULL_ITEM), new MaterialData(Material.BOW), new MaterialData(Material.ARROW), new MaterialData(Material.ARROW)};
	}

	@Override
	public String getLore() {
		return "Summon a hail of arrows";
	}

	@Override
	public String getName() {
		return ChatColor.GRAY + "ArrowHail";
	}

	@Override
	public boolean isReusable() {
		return true;
	}

	@Override
	public int getManaCost() {
		return 10;
	}

	@Override
	public boolean onRightClick(final Player p) {
		@SuppressWarnings("deprecation")
		final Location loc = p.getTargetBlock((HashSet<Byte>)null, 100).getLocation();
		
		new BukkitRunnable() {
			
			int i = 0;
			@Override
			public void run() {
				i++;
				
				Location loc2 = new Location(loc.getWorld(), loc.getX() + Util.RANDOM.nextDouble()*10-5, loc.getY() + Util.RANDOM.nextInt(5) + 25, loc.getZ() + Util.RANDOM.nextDouble()*10-5);
				ProjectileUtil.fireProjectile(p, EntityType.ARROW, new Vector(0, -1, 0), loc2);

				if(Util.RANDOM.nextInt(15) < 2){
					p.getWorld().spigot().playEffect(p.getLocation(), Effect.BOW_FIRE, 1, 0, 0, 0, 0, 0.1f, 10, 2);
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SKELETON_SHOOT, 0.5f, 0.5f);
				}
				
				if (i % 200 == 0) {
					cancel();
				}
			}
		}.runTaskTimer(plugin, 0L, 1L);
		
		return true;
	}

}
