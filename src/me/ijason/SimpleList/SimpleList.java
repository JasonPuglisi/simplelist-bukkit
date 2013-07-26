package me.ijason.SimpleList;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Simple part of SimpleList
 * 
 * @author Jason Puglisi
 * @version 1.0
 */

public class SimpleList extends JavaPlugin {

	@Override
	public void onEnable() {
		getCommand("who").setExecutor(new List(this));
		getCommand("list").setExecutor(new List(this));
		getCommand("players").setExecutor(new List(this));
	}
	
	@Override
	public void onDisable() {
	}
	
}
