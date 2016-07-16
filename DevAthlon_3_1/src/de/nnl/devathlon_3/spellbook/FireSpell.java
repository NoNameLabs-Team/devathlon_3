package de.nnl.devathlon_3.spellbook;

import org.bukkit.Material;
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
		return "Fires a fireball";
	}

	@Override
	public String getName() {
		return "Fireball";
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
	public void onRightClick(Player p) {
		ProjectileUtil.fireProjectile(p, 10, 4, EntityType.FIREBALL, 2.0, 0.0);
	}
	
}
