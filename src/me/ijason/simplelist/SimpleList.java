package me.ijason.simplelist;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**@author Jason Puglisi
 * @version 1.2.3
 */

public class SimpleList extends JavaPlugin {
	public static Plugin pex;
	public static Plugin sc;
	// Plugin enable
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		getLogger().info("v" + getDescription().getVersion() + " enabled");
		getCommand("who").setExecutor(new List(this));
		getCommand("list").setExecutor(new List(this));
		getCommand("players").setExecutor(new List(this));
		pex = pm.getPlugin("PermissionsEx");
		sc = pm.getPlugin("SupaChat");
	}
	// Plugin disable
	public void onDisable() {
		getLogger().info("v" + getDescription().getVersion() + " disabled");
	}
	// PermissionsEx Enabled
	public static boolean pexEnabled() {
		return pex != null;
	}
	// SupaChat Enabled
	public static boolean scEnabled() {
		return sc != null;
	}
}
