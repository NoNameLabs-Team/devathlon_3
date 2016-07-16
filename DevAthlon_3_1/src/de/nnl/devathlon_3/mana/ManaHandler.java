package de.nnl.devathlon_3.mana;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.server.v1_10_R1.IChatBaseComponent;
import net.minecraft.server.v1_10_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_10_R1.PacketPlayOutChat;

import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ManaHandler implements Listener {
	
	public Map<String, Integer> max_mana; 
	public Map<String, Integer> mana; 
	
	public ManaHandler() {
		max_mana = new HashMap<String, Integer>();
		mana = new HashMap<String, Integer>();
		
		
	}

	public void saveMana() {
		
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		
	}
	
	public static void sendManaBar(Player player, int mana, int max_mana){
        CraftPlayer p = (CraftPlayer) player;
        IChatBaseComponent cbc = ChatSerializer.a("{\"text\": \"" + mana + " / " + max_mana + "\"}");
        PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc,(byte) 2);
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(ppoc);
    }
}
