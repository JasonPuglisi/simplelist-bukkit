package me.ijason.SimpleList;

import org.bukkit.command.CommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

/**
 * @author Jason Puglisi
 * @version 1.1.0
 */

public class PexList implements CommandExecutor {

	private SimpleList plugin;
	
	public PexList(SimpleList plugin) {
		
		this.plugin = plugin;
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length == 0) { // If there are no arguments, build player list
			
			Player[] playerArray = Bukkit.getOnlinePlayers();
			
			int totalPlayers = playerArray.length;
			int listedPlayers = 0;
			
			String currentPlayer = "";
			String playerList = "";
			
			while(listedPlayers < (totalPlayers)) {
				
				currentPlayer = playerArray[listedPlayers].getDisplayName();
				
				PermissionUser user = PermissionsEx.getUser(playerArray[listedPlayers]);
				String prefix = ChatColor.translateAlternateColorCodes('&', user.getPrefix());
				String suffix = ChatColor.translateAlternateColorCodes('&', user.getSuffix());
				
				playerList = playerList + prefix + currentPlayer + suffix + "§f, ";
				listedPlayers++;
				
			}
			
			if(sender instanceof Player) { // If the user is a player, continue checks.
				
				if(totalPlayers != 1) { // If there is more than one player online, send player list.
					
					sender.sendMessage("§eOnline Players (" + totalPlayers + "): §f" + playerList.substring(0, playerList.length() - 2));
					
					return true;
					
				}
				
				else { // There is only one player online. Send notification.
				
					sender.sendMessage("§eYou are the only player online!");
					
					return true;
					
				}
				
			}
			
			else if(totalPlayers != 0) { // The user is a console. If there is a player online, send uncolored player list.
				
				sender.sendMessage("Online Players (" + totalPlayers + "): " + ChatColor.stripColor(playerList.substring(0, playerList.length() - 2)));
				
				return true;
				
			}
			
			else { // There are no players online. Send uncolored notification.
				
				sender.sendMessage("There are no players online!");
				
				return true;
				
			}
			
		}
		
		else { // There is at least one argument. Continue checks.
			
			if(sender instanceof Player) { // If the user is a player, send notification.
				
				sender.sendMessage("§eToo many arguments!");
				
				return true;
				
			}
			
			else { // The user is a console. Send uncolored notification.
				
				sender.sendMessage("Too many arguments!");
				
				return true;
				
			}
			
		}
		
	}
	
}

