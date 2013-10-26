package me.ijason.SimpleList;

import me.javoris767.supachat.SupaChat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ScInfo extends JavaPlugin {
	static Plugin supachatplugin = SimpleList.sc;
	public static String getPrefix(Player player) {
		String prefix = ((SupaChat) supachatplugin).info.getKey(player, "prefix");
		if (prefix != null) return ChatColor.translateAlternateColorCodes('&', prefix);
		return "";
	}
}
