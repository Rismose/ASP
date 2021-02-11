package me.rismsoe.astaffplugin.events;

import me.rismsoe.astaffplugin.AStaffPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    AStaffPlugin plugin;

    public JoinEvent(AStaffPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        for (int i = 0; i < plugin.invisible_list.size(); i++){
            player.hidePlayer(plugin, plugin.invisible_list.get(i));
        }
    }
}
