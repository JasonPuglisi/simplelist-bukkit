package me.ijason.SimpleList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class List implements CommandExecutor {
	private SimpleList plugin;
	public List(SimpleList plugin) {
		this.setPlugin(plugin);
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// Too many arguments
		if (args.length != 0) {
			sender.sendMessage(ChatColor.YELLOW + "Too many arguments.");
			return true;
		}
		// Make list
		Player[] players = Bukkit.getOnlinePlayers();
		String list = "";
		String pexPrefix = "";
		String pexSuffix = "";
		String scPrefix = "";
		String scSuffix = "";
		for(int i = 0; i < players.length; i++) {
			if (SimpleList.pexEnabled()) {
				pexPrefix = PexInfo.getPrefix(players[i]);
				pexSuffix = PexInfo.getSuffix(players[i]);
			}
			if (SimpleList.scEnabled()) {
				scPrefix = ScInfo.getPrefix();
				scSuffix = ScInfo.getSuffix();
			}
			list += scPrefix + pexPrefix + players[i].getDisplayName() + pexSuffix + scSuffix + ChatColor.WHITE + ", ";
		}
		// No players online
		if (players.length == 0) {
			sender.sendMessage(ChatColor.YELLOW + "No players online.");
			return true;
		}
		// Send list
		sender.sendMessage(ChatColor.YELLOW + "Online Players (" + players.length + "): " + ChatColor.WHITE + list.substring(0, list.length() - 2));
		return true;
	}
	// Getter and setter
	public SimpleList getPlugin() {
		return plugin;
	}
	public void setPlugin(SimpleList plugin) {
		this.plugin = plugin;
	}
}
