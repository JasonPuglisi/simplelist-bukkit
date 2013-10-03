package me.ijason.SimpleList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PexInfo {
	public static String getPrefix(Player player) {
		return ChatColor.translateAlternateColorCodes('&', PermissionsEx.getUser(player).getPrefix());
	}
	public static String getSuffix(Player player) {
		return ChatColor.translateAlternateColorCodes('&', PermissionsEx.getUser(player).getSuffix());
	}
}
