package me.rismsoe.astaffplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickEvent2 implements Listener {

    @EventHandler
    public void clickEvent2(InventoryClickEvent e){

        //Check to see if its the GUI menu
        if(e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.RED + "Gamemode GUI")){
            Player player = (Player) e.getWhoClicked();
            //Determine what they selected and what to do
            switch(e.getCurrentItem().getType()){
                case QUARTZ:
                    player.closeInventory();
                    player.performCommand("gamemode creative");
                    break;
                case HAY_BLOCK:
                    player.closeInventory();
                    player.performCommand("gamemode survival");
                    break;
                case ENDER_PEARL:
                    player.closeInventory();
                    player.performCommand("gamemode spectator");
                    break;
                case RED_ROSE:
                    player.closeInventory();
                    player.performCommand("gamemode adventure");
                    break;
            }


            e.setCancelled(true); //So they cant take the items
        }

    }

}
