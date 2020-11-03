package me.luligabi.betasheep;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerShearEntityEvent;
import org.bukkit.inventory.ItemStack;

public class SheepListener implements Listener {
	
	@EventHandler
	public void onBetaShearing(EntityDamageByEntityEvent e) { //TODO: Add config to toggle healing the sheep after the hit
		if(e.getEntityType() != EntityType.SHEEP) return;
		Sheep s = (Sheep) e.getEntity();
		if(!s.isAdult()) return;
		dropWool(s, s.getColor());
	}
	@EventHandler
	public void onVanillaShearing(PlayerShearEntityEvent e) {
		e.setCancelled(true); //TODO: Add config to toggle vanilla shearing.
	}
	private void dropWool(Sheep s, DyeColor d) {
		double randomWool = Math.floor(Math.random() * (3 - 1 + 1) + 1); // randomized 1-3 wool drop
		ItemStack wool = new ItemStack(Material.WOOL, (int) randomWool, d.getData()); 
		s.setSheared(true);
		s.getWorld().dropItemNaturally(s.getLocation(), wool); 
	}
} 
