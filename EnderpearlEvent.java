package com.indieguts.safeenderpearl.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;

import com.indieguts.safeenderpearl.Core;

public class EnderpearlEvent implements Listener {

	private final Core core;
	public EnderpearlEvent(Core core) {
		this.core = core;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void teleportEvent(PlayerTeleportEvent event) {
		if (event.getCause() == TeleportCause.ENDER_PEARL) {     
			Player player = (Player) event.getPlayer();
			Location locto = event.getTo();
			if (player.hasPermission("se.bypass")){
				return;
			} else {
			if (locto.add(0, 1, 0).getBlock().getType().isSolid()) {
				player.playSound(player.getLocation(), Sound.ENTITY_IRONGOLEM_HURT, 10, 10);
				event.setCancelled(true);
				player.getInventory().addItem(new ItemStack(Material.ENDER_PEARL));
				if (core.getConfig().getString("messages.deny-enderpearl").equals("")) {
					return;
				} else {
					player.sendMessage(ChatColor.translateAlternateColorCodes('&', "" + core.getConfig().getString("messages.deny-enderpearl")));
				}
				
			}
			}
		}
	}
}
