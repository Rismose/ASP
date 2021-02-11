package me.rismsoe.astaffplugin.Base;

import me.rismsoe.astaffplugin.Files.CustomConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("asp.clearchat")) {
                if (command.getName().equalsIgnoreCase("clearchat")) {

                    for(int i=0; i<100; i++)
                    {
                        Bukkit.broadcastMessage("");
                    }

                    Bukkit.broadcastMessage(ChatColor.RED + CustomConfig.get().getString("ClearChatMessage"));

                }else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to execute this command");
                }
            }
            return true;
        }
        return false;
    }
}
