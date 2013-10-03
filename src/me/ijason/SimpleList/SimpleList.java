package me.ijason.SimpleList;

import org.bukkit.plugin.java.JavaPlugin;

/**@author Jason Puglisi
 * @version 1.2.0
 */

public class SimpleList extends JavaPlugin {
	public static boolean pex = false;
	public static boolean sc = false;
	// Plugin enable
	public void onEnable() {
		getLogger().info("v" + getDescription().getVersion() + " enabled");
		getCommand("who").setExecutor(new List(this));
		getCommand("list").setExecutor(new List(this));
		getCommand("players").setExecutor(new List(this));
		pex = getServer().getPluginManager().getPlugin("PermissionsEx") != null;
		sc = getServer().getPluginManager().getPlugin("SupaChat") != null;
	}
	// Plugin disable
	public void onDisable() {
		getLogger().info("v" + getDescription().getVersion() + " disabled");
	}
	// PermissionsEx Enabled
	public static boolean pexEnabled() {
		return pex;
	}
	// SupaChat Enabled
	public static boolean scEnabled() {
		return sc;
	}
}
