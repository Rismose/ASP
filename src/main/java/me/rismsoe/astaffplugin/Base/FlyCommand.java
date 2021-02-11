package me.rismsoe.astaffplugin.Base;

import me.rismsoe.astaffplugin.Files.CustomConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {

    private final ArrayList<Player> list_of_flying_players = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("asp.Fly")) {
                if (list_of_flying_players.contains(player)) {
                    list_of_flying_players.remove(player);
                    player.setAllowFlight(false);
                    player.sendMessage(ChatColor.GREEN + CustomConfig.get().getString("FlyToggleOFF"));
                } else if (!list_of_flying_players.contains(player)) {
                list_of_flying_players.add(player);
                    player.setAllowFlight(true);
                    player.sendMessage(ChatColor.GREEN + CustomConfig.get().getString("FlyToggleON"));
                }

            }else{
                player.sendMessage(ChatColor.RED + "You do not have permission to execute this command");
            }

            return true;
        }
        return false;
    }
}

