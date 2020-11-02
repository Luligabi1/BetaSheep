package me.luligabi.betasheep;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class SheepListener implements Listener {
	
	@EventHandler
	public void on(EntityDamageByEntityEvent e) {
		if(e.getEntityType() != EntityType.SHEEP) return;
		Sheep s = (Sheep) e.getEntity();
		if(!s.isAdult()) return;
		giveWool(s, s.getColor());
	}
	private void giveWool(Sheep s, DyeColor d) {
		ItemStack wool = new ItemStack(Material.WOOL, 1, d.getData()); //TODO: Add randomized 1-3 wool drop
		s.setSheared(true);
		s.getWorld().dropItemNaturally(s.getLocation(), wool); 
	}
} //TODO: Disable shearing with shears.
