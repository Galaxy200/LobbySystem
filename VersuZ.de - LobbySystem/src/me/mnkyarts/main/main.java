package me.mnkyarts.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.mnkyarts.items.playerhider;

public class main extends JavaPlugin {
	
    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§7§m-------------------------------------");
        Bukkit.getConsoleSender().sendMessage("§5VersuZ §8| §bName§7: Lobby System");
        Bukkit.getConsoleSender().sendMessage("§5VersuZ §8| §bAuthor§7: MnkyArts");
        Bukkit.getConsoleSender().sendMessage("§5VersuZ §8| §bVersion§7: 1.0");
        Bukkit.getConsoleSender().sendMessage("§7");
        Bukkit.getConsoleSender().sendMessage("§5VersuZ §8| §aSystem Activated");
        Bukkit.getConsoleSender().sendMessage("§7§m-------------------------------------");
        Bukkit.getPluginManager().registerEvents(new playerhider(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§7§m-------------------------------------");
        Bukkit.getConsoleSender().sendMessage("§5VersuZ §8| §bName§7: Lobby System");
        Bukkit.getConsoleSender().sendMessage("§5VersuZ §8| §bAuthor§7: MnkyArts");
        Bukkit.getConsoleSender().sendMessage("§5VersuZ §8| §bVersion§7: 1.0");
        Bukkit.getConsoleSender().sendMessage("§7");
        Bukkit.getConsoleSender().sendMessage("§5VersuZ §8| §4System Deactivated");
        Bukkit.getConsoleSender().sendMessage("§7§m-------------------------------------");
    }

}
