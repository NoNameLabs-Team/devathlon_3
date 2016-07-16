package de.nnl.devathlon_3.mana;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.server.v1_10_R1.IChatBaseComponent;
import net.minecraft.server.v1_10_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_10_R1.PacketPlayOutChat;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class ManaHandler implements Listener {
	private Plugin plugin;
	
	private Map<String, Integer> max_mana; 
	private Map<String, Integer> mana; 
	
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
	}

	public void saveMana() {
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
		
		sendManaBar(p, mana.get(p.getName()), max_mana.get(p.getName()));
	}
	
	public static void sendManaBar(Player player, int mana, int max_mana){
        CraftPlayer p = (CraftPlayer) player;
        IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + mana + " / " + max_mana + "\"}");
        PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc,(byte) 2);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(ppoc);
    }
}
