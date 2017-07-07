package com.indieguts.safeenderpearl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;

import com.indieguts.safeenderpearl.events.EnderpearlEvent;

public class Core extends JavaPlugin {

/*
 * Copyright (C) 2017 IndieGuts
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

	ConsoleCommandSender console = Bukkit.getConsoleSender();
	Date now = new Date();
	SimpleDateFormat time = new SimpleDateFormat("MM-dd-yyyy" + " '&7|&a' " + "HH:mm:ss");
	TimeZone timezone = Calendar.getInstance().getTimeZone();

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new EnderpearlEvent(this), this);
		//getCommand("command").setExecutor(new commandClass(this));
		getConfig().options().copyDefaults(true);
		getConfig().options().copyHeader(true);
		saveDefaultConfig();
		color("&8* &8&m-------|-----&8[ &aSafeEnderpearl &8]&m-----|-------&8 *");
		color(" ");
		color("   &fYou are currently running SafeEnderpearl");
		color("      &fSafeEnderpearl created by &aIndieGuts");
		color("       &fCurrently running version &a" + getDescription().getVersion());
		color(" ");
		color("&8* &8&m--------------------------------------------&8 *");
		debug("The time is currently &a" + time.format(now));
		debug("Timezone: &a" + timezone.getDisplayName() + " &7|&a " + timezone.getID());
		debug("The plugin has successfully been loaded!");
	}

	@Override
	public void onDisable() {
		color("&aSafeEnderpearl &fhas been disabled!");
		debug("The time is currently &a" + time.format(now));
		debug("Timezone: &a" + timezone.getDisplayName() + " &7|&a " + timezone.getID());
		debug("The plugin has successfully been loaded!");
	}

	public static void debug(String debugMessage){
		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&cDebug: &f" + debugMessage));
	}

	public static void color(String ConsoleColor){
		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "" + ConsoleColor));
	}
	
	public static void msgcolor(Player player, String MsgColor){
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "" + MsgColor));
	}
}
