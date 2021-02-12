package me.rismsoe.astaffplugin.Base;

import me.rismsoe.astaffplugin.AStaffPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {

    AStaffPlugin plugin;

    public VanishCommand(AStaffPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("asp.vanish")) {
                if (plugin.invisible_list.contains(player)) {
                    for (Player people : Bukkit.getOnlinePlayers()) {
                        people.showPlayer(plugin, player);
                    }

                    plugin.invisible_list.remove(player);
                    player.sendMessage(ChatColor.GREEN + "You are now visible to other players on the server.");
                } else if (!plugin.invisible_list.contains(player)) {
                    for (Player people : Bukkit.getOnlinePlayers()) {
                        people.hidePlayer(plugin, player);
                    }
                    plugin.invisible_list.add(player);
                    player.sendMessage(ChatColor.GREEN + "You are invisible to other players on the server.");
                }
            }else{
                player.sendMessage(ChatColor.RED + "You do not have permission to execute this command");
            }

            return true;
        }
        return false;
    }
}
