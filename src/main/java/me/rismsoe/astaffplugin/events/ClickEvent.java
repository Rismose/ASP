package me.rismsoe.astaffplugin.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickEvent implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e){


        if(e.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.RED + "Staff GUI")){
            Player player = (Player) e.getWhoClicked();

            switch(e.getCurrentItem().getType()){
                case FEATHER:
                    player.closeInventory();
                    player.performCommand("Fly");
                    break;
                case ENCHANTMENT_TABLE:
                    player.closeInventory();
                    player.performCommand("gamemodemenu");
                    break;
                case REDSTONE:
                    player.closeInventory();
                    player.performCommand("aspreload");
                    break;
                case IRON_DOOR:
                    player.closeInventory();
                    player.performCommand("bans");
                    break;
                case BOOK_AND_QUILL:
                    player.closeInventory();
                    player.performCommand("clearchat");
                    break;
                case REDSTONE_TORCH_ON:
                    player.closeInventory();
                    player.performCommand("vanish");
                    break;
                case BARRIER:
                    player.closeInventory();
                    player.performCommand("mutechat");
                    break;
            }


            e.setCancelled(true);
        }

    }

}
