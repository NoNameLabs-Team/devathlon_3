package de.nnl.devathlon_3.spellbook;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;

import de.nnl.devathlon_3.spells.Spell;
import de.nnl.devathlon_3.util.ProjectileUtil;

public class FireSpell implements Spell{

	public FireSpell(){
		
	}

	@Override
	public MaterialData[] getIngredients() {
		MaterialData lava = new MaterialData(Material.LAVA_BUCKET);
		return new MaterialData[]{lava, lava, new MaterialData(Material.MAGMA_CREAM), new MaterialData(Material.FLINT_AND_STEEL), new MaterialData(Material.BLAZE_POWDER), lava, lava};
	}

	@Override
	public String getLore() {
		return "Shoots a fireball";
	}

	@Override
	public String getName() {
		return ChatColor.DARK_RED + "Fireball";
	}

	@Override
	public boolean isReusable() {
		return true;
	}

	@Override
	public int getManaCost() {
		return 7;
	}

	@Override
	public boolean onRightClick(Player p) {
		p.getWorld().spigot().playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 1, 0, 0, 0, 0, 0.1f, 10, 20);
		p.getWorld().playSound(p.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 0.5f, 0.5f);
		ProjectileUtil.fireProjectile(p, EntityType.FIREBALL, 2.0, 0.0);
		
		return true;
	}
	
}
