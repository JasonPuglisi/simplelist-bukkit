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
		String color = "";
		if (prefix != null) {
			for (int i = 0; i < prefix.length() - 1; i++) {
				if (prefix.charAt(i) == '&') color = ChatColor.translateAlternateColorCodes('&', prefix.substring(i , i + 2));
			}
		}
		return color;
	}
}
