package me.mnkyarts.items;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.Event.Result;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class playerhider implements Listener {
	
	public static ArrayList<Player> players = new ArrayList<>();

	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			
			if(players.contains(all)) {
				all.hidePlayer(e.getPlayer());
			}
			
		}
		
		e.getPlayer().getInventory().clear();
		
		ItemStack dust = new ItemStack(Material.GLOWSTONE_DUST);
		ItemMeta m = dust.getItemMeta();
		m.setDisplayName("§7Spieler: §asichtbar");
		dust.setItemMeta(m);
		
		e.getPlayer().getInventory().setItem(8, dust);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(e.getPlayer().getItemInHand().getType() == Material.GLOWSTONE_DUST){
			
			for(Player all : Bukkit.getOnlinePlayers()){
				e.getPlayer().hidePlayer(all);
				players.add(e.getPlayer());
			}
			
			ItemStack dust = new ItemStack(Material.SUGAR);
			ItemMeta m = dust.getItemMeta();
			m.setDisplayName("§7Spieler: §cunsichtbar");
			dust.setItemMeta(m);
			e.getPlayer().sendMessage("§7Alle Spieler sind nun §cunsichtbar.");
			e.getPlayer().setItemInHand(dust);
			return;
		}
			
			if(e.getPlayer().getItemInHand().getType() == Material.SUGAR){
				
				for(Player all : Bukkit.getOnlinePlayers()){
					e.getPlayer().showPlayer(all);
					players.remove(e.getPlayer());
				}
				
				ItemStack dust = new ItemStack(Material.GLOWSTONE_DUST);
				ItemMeta m = dust.getItemMeta();
				m.setDisplayName("§7Spieler: §asichtbar");
				dust.setItemMeta(m);
				e.getPlayer().sendMessage("§7Alle Spieler sind nun §asichtbar.");
				e.getPlayer().setItemInHand(dust);
			}
			
		}
	}
	
    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
    	
        if (event.getItemDrop().getItemStack().getType() == Material.GLOWSTONE_DUST || event.getItemDrop().getItemStack().getType() == Material.SUGAR) {
            event.setCancelled(true);
            
        }
    }
    
    @EventHandler
    public void onClickSlot(InventoryClickEvent e) {
        if (e.getSlot() == 8) {
            e.setResult(Result.DENY);
            e.setCancelled(true);
        }
    }
	
}
