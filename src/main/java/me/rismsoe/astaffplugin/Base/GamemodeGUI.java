package me.rismsoe.astaffplugin.Base;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GamemodeGUI implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {
            Player player = (Player) sender;

                Inventory GamemodeMenu = Bukkit.createInventory(player, 9, ChatColor.RED + "Gamemode GUI");

                ItemStack none1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack creative = new ItemStack(Material.QUARTZ);

                ItemStack none2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack survival = new ItemStack(Material.HAY_BLOCK);

                ItemStack none3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack spectator = new ItemStack(Material.ENDER_PEARL);

                ItemStack none4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack adventure = new ItemStack(Material.RED_ROSE);

                ItemStack none5 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);


                ItemMeta creative_meta = creative.getItemMeta();
                creative_meta.setDisplayName(ChatColor.AQUA + "Creative");
                ArrayList<String> creative_lore = new ArrayList<>();
                creative_lore.add(ChatColor.GREEN + "Switch to creative mode");
                creative_meta.setLore(creative_lore);
                creative.setItemMeta(creative_meta);

                ItemMeta survival_meta = survival.getItemMeta();
                survival_meta.setDisplayName(ChatColor.AQUA + "Survival");
                ArrayList<String> survival_lore = new ArrayList<>();
                survival_lore.add(ChatColor.GREEN + "Switch to survival mode");
                survival_meta.setLore(survival_lore);
                survival.setItemMeta(survival_meta);

                ItemMeta spectator_meta = spectator.getItemMeta();
                spectator_meta.setDisplayName(ChatColor.AQUA + "Spectator");
                ArrayList<String> spectator_lore = new ArrayList<>();
                spectator_lore.add(ChatColor.GREEN + "Switch to spectator mode");
                spectator_meta.setLore(spectator_lore);
                spectator.setItemMeta(spectator_meta);

                ItemMeta adventure_meta = adventure.getItemMeta();
                adventure_meta.setDisplayName(ChatColor.AQUA + "Adventure");
                ArrayList<String> adventure_lore = new ArrayList<>();
                adventure_lore.add(ChatColor.GREEN + "Switch to adventure mode");
                adventure_meta.setLore(adventure_lore);
                adventure.setItemMeta(adventure_meta);


                ItemStack[] menu_items = {none2, creative,none1, survival,none3, spectator,none4, adventure, none5};
                GamemodeMenu.setContents(menu_items);
                player.openInventory(GamemodeMenu);
            }


            return true;
        }
    }

