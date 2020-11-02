package me.luligabi.betasheep;

import org.bukkit.plugin.java.JavaPlugin;

public class BetaSheep extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new SheepListener(), this);
	}
	@Override
	public void onDisable() {
		
	}

}
