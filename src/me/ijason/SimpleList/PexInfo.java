package me.ijason.SimpleList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PexInfo {
	public static String getPrefix(Player player) {
		String prefix = PermissionsEx.getUser(player).getPrefix();
		String color = "";
		for (int i = 0; i < prefix.length() - 1; i++) {
			if (prefix.charAt(i) == '&') color = ChatColor.translateAlternateColorCodes('&', prefix.substring(i , i + 2));
		}
		return color;
	}
}
