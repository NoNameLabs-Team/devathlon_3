package de.nnl.devathlon_3.util;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.util.Vector;

public class ProjectileUtil {

	public static void fireProjectile(Player p, EntityType type, Vector velocity, Location location) {
		if (type != EntityType.SNOWBALL && type != EntityType.EGG && type != EntityType.ENDER_PEARL && type != EntityType.ARROW && type != EntityType.FIREBALL) return;
		Projectile projectile = (Projectile) p.getWorld().spawnEntity(location, type);
		
		projectile.setVelocity(velocity);
		projectile.setCustomNameVisible(false);
		projectile.setShooter(p);
	}
	
	public static void fireProjectile(Player p, EntityType type, Vector velocity) {
		if (type != EntityType.SNOWBALL && type != EntityType.EGG && type != EntityType.ENDER_PEARL && type != EntityType.ARROW && type != EntityType.FIREBALL) return;
		Projectile projectile = (Projectile) p.getWorld().spawnEntity(p.getEyeLocation(), type);
		
		projectile.setVelocity(velocity);
		projectile.setCustomNameVisible(false);
		projectile.setShooter(p);
	}
	
	public static void fireProjectile(Player p, EntityType type, double strenght, double miss) {
		fireProjectile(p, type, p.getEyeLocation().getDirection().multiply(strenght).add(new Vector((Util.RANDOM.nextDouble()*2 -1)*miss, (Util.RANDOM.nextDouble()*2 -1)*miss, (Util.RANDOM.nextDouble()*2 -1)*miss)));
	}
	
}
