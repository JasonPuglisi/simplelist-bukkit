package me.ijason.SimpleList;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Jason Puglisi
 * @version 1.0.1
 */

public class SimpleList extends JavaPlugin {

	@Override
	public void onEnable() {
		getLogger().info("Version " + getDescription().getVersion() + " loaded");
		getCommand("who").setExecutor(new List(this));
		getCommand("list").setExecutor(new List(this));
		getCommand("players").setExecutor(new List(this));
	}
	
	@Override
	public void onDisable() {
		getLogger().info("Version " + getDescription().getVersion() + " unloaded");
	}
	
}
