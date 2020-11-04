package me.luligabi.betasheep;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.inventory.ItemStack;

public class SheepListener implements Listener {
	
	FileConfiguration cfg = BetaSheep.plugin.getConfig();
	
	@EventHandler
	public void onBetaShearing(EntityDamageByEntityEvent e) { 
		if(e.getEntityType() != EntityType.SHEEP) return;
		Sheep s = (Sheep) e.getEntity();
		if(!s.isAdult() || s.isSheared()) return;
		dropWool(s, s.getColor());
	}
	@EventHandler
	public void onVanillaShearing(PlayerShearEntityEvent e) {
		e.setCancelled(cfg.getBoolean("disableVanillaShearing")); 
	}
	private void dropWool(Sheep s, DyeColor d) {
		double randomWool = Math.floor(Math.random() * (3 - 1 + 1) + 1); // randomized 1-3 wool drop
		ItemStack wool = new ItemStack(Material.WOOL, (int) randomWool, d.getData()); 
		s.setSheared(true);
		s.getWorld().dropItemNaturally(s.getLocation(), wool); 
	}
} 
