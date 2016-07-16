package de.nnl.devathlon_3.mana;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.server.v1_10_R1.IChatBaseComponent;
import net.minecraft.server.v1_10_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_10_R1.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import de.nnl.devathlon_3.spells.Spell;

public class ManaHandler implements Listener {
	private Plugin plugin;
	
	private Map<String, Integer> max_mana; 
	private Map<String, Integer> mana; 
	
	private int taskID;
	
	public ManaHandler(Plugin plugin) {
		this.plugin = plugin;
		max_mana = new HashMap<String, Integer>();
		mana = new HashMap<String, Integer>();
		

		File f = new File(plugin.getDataFolder(), "mana.yml");
		if (f.exists()) {
			YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
			
			int amount = config.getInt("players");
			
			for (int i = 0; i < amount; i++) {
				String player = config.getString("player" + i);
				
				mana.put(player, config.getInt("mana" + i));
				max_mana.put(player, config.getInt("max_mana" + i));				
			}
			
		} else {
			try {
				plugin.getDataFolder().mkdirs();
				f.createNewFile();
			} catch (IOException e) {}
		}
		
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
			
			@Override
			public void run() {
				for (Player p: Bukkit.getOnlinePlayers()) {
					addMana(p, 1);
				}
			}
		}, 20L, 20L);
	}

	public void saveMana() {
		Bukkit.getScheduler().cancelTask(taskID);
		
		File f = new File(plugin.getDataFolder(), "mana.yml");
		
		if (f.exists()) {
			YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
			
			config.set("players", max_mana.keySet().size());
			
			int x = 0;
			for (String player: max_mana.keySet()) {
				config.set("player" + x, player);
				config.set("mana" + x, mana.get(player));
				config.set("max_mana" + x, max_mana.get(player));	
				x++;
			}
			try {
				config.save(f);
			} catch (IOException e) {}
		} else {
			try {
				plugin.getDataFolder().mkdirs();
				f.createNewFile();
			} catch (IOException e) {}
		}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if (!max_mana.containsKey(p.getName())) {
			max_mana.put(p.getName(), 10);
			mana.put(p.getName(), 10);
		}

		updateMana(p);
	}
	
	public boolean useSpell(Spell s, Player p) {
		if (s.getManaCost() <= mana.get(p.getName())) {
			return true;
		}
		return false;
	}
	
	public boolean addMana(Player p, int amount) {
		boolean result = mana.get(p.getName()) < max_mana.get(p.getName());
		mana.put(p.getName(), Math.min(mana.get(p.getName()) + amount, max_mana.get(p.getName())));
		updateMana(p);
		return result;
	}
	
	public void addMaximumMana(Player p, int amount) {
		max_mana.put(p.getName(), Math.max(1, max_mana.get(p.getName()) + amount));
		updateMana(p);
	}
	
	public void updateMana(Player p) {
		if (mana.get(p.getName()) > max_mana.get(p.getName())) mana.put(p.getName(), max_mana.get(p.getName()));
		if (mana.get(p.getName()) < 0) mana.put(p.getName(), 0);
		
		sendManaBar(p, mana.get(p.getName()), max_mana.get(p.getName()));
	}
	
	public static void sendManaBar(Player player, int mana, int max_mana) {
        CraftPlayer p = (CraftPlayer) player;
        
        String text = ChatColor.AQUA + "" + mana + " [" + ChatColor.RED;
        
        for (int i = 0; i < (50*mana)/max_mana; i++) {
        	text += "|";
        }
        
        text += ChatColor.WHITE;
        
        for (int i = 0; i < 50 - (50*mana)/max_mana; i++) {
        	text += "|";
        }
        
        text += ChatColor.AQUA + "] " + max_mana;
        
        IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + text + "\"}");
        PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc,(byte) 2);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(ppoc);
    }
}
