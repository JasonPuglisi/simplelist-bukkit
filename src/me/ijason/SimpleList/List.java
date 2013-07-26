package me.ijason.SimpleList;

import org.bukkit.command.CommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

/**
 * Useful part of SimpleList
 * 
 * @author Jason Puglisi
 * @version 1.0.0
 */

public class List implements CommandExecutor {

	private SimpleList plugin;
	
	public List(SimpleList plugin) {
		this.plugin = plugin;
	}	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			Player[] players = Bukkit.getOnlinePlayers();
			int playerCount = players.length;
			int listedPlayers = 0;
			String list = "";
			while(listedPlayers < (playerCount)) {
				list = list + players[listedPlayers].getDisplayName() + "§f, ";
				listedPlayers++;
			}
			if(sender instanceof Player) {
				sender.sendMessage("§eOnline Players (" + playerCount + "): §f" + list.substring(0, list.length() - 2));
				return true;
			} else if(playerCount == 0) {
				sender.sendMessage("There are no players online!");
				return true;
			} else {
				sender.sendMessage("Online Players (" + playerCount + "): " + ChatColor.stripColor(list.substring(0, list.length() - 2)));
				return true;
			}
		} else {
			sender.sendMessage("Too many arguments!");
			return false;
		}
	}
}