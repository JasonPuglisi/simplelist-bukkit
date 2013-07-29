package me.ijason.SimpleList;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Jason Puglisi
 * @version 1.1.0
 */

public class SimpleList extends JavaPlugin {

	@Override
	public void onEnable() {
		
		getLogger().info("Version " + getDescription().getVersion() + " loaded");
		
		if(getServer().getPluginManager().getPlugin("PermissionsEx") != null) { // If PermissionsEx is enabled, use prefix version and send notification.
			
			getCommand("who").setExecutor(new PexList(this));
			getCommand("list").setExecutor(new PexList(this));
			getCommand("players").setExecutor(new PexList(this));
			
			getLogger().info("PermissionsEx support enabled");
			
		}
		
		else { // PermissionsEx is not enabled. Use standard version.
			
			getCommand("who").setExecutor(new List(this));
			getCommand("list").setExecutor(new List(this));
			getCommand("players").setExecutor(new List(this));
			
		}
		
	}
	
	@Override
	public void onDisable() {
		
		getLogger().info("Version " + getDescription().getVersion() + " unloaded");
		
	}
	
}
