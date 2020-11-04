package me.luligabi.betasheep;

import org.bukkit.plugin.java.JavaPlugin;

public class BetaSheep extends JavaPlugin {
	
	public static BetaSheep plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new SheepListener(), this);
	}
}
