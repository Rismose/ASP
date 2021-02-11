
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

public class GUIMenu implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("asp.gui")) {

                Inventory Staff = Bukkit.createInventory(player, 27, ChatColor.RED + "Staff GUI");

                ItemStack none5 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack clearchat = new ItemStack(Material.BOOK_AND_QUILL);

                ItemStack none1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack fly = new ItemStack(Material.FEATHER);

                ItemStack none2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack gamemodes = new ItemStack(Material.ENCHANTMENT_TABLE);

                ItemStack mutechat = new ItemStack(Material.BARRIER, 1, (short) 14);

                ItemStack ssreload = new ItemStack(Material.REDSTONE);

                ItemStack none4 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack bans = new ItemStack(Material.IRON_DOOR);

                ItemStack none6 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack vanish = new ItemStack(Material.REDSTONE_TORCH_ON);

                ItemStack none7 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack none8 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack none9 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack none10 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack none11 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack none12 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack none13 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack none14 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack none15 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack none16 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack none17 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack none18 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack none19 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack none20 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemStack none21 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);

                ItemMeta fly_meta = fly.getItemMeta();
                fly_meta.setDisplayName(ChatColor.GREEN + "Fly");
                ArrayList<String> fly_lore = new ArrayList<>();
                fly_lore.add(ChatColor.AQUA + "Makes you able to fly");
                fly_meta.setLore(fly_lore);
                fly.setItemMeta(fly_meta);

                ItemMeta gamemodes_meta = gamemodes.getItemMeta();
                gamemodes_meta.setDisplayName(ChatColor.GREEN + "Gamemodes");
                ArrayList<String> gamemodes_lore = new ArrayList<>();
                gamemodes_lore.add(ChatColor.AQUA + "Switch Gamemode");
                gamemodes_meta.setLore(gamemodes_lore);
                gamemodes.setItemMeta(gamemodes_meta);

                ItemMeta clearchat_meta = clearchat.getItemMeta();
                clearchat_meta.setDisplayName(ChatColor.GREEN + "Clear chat");
                ArrayList<String> clearchat_lore = new ArrayList<>();
                clearchat_lore.add(ChatColor.AQUA + "Clears the chat");
                clearchat_meta.setLore(clearchat_lore);
                clearchat.setItemMeta(clearchat_meta);

                ItemMeta ssreload_meta = ssreload.getItemMeta();
                ssreload_meta.setDisplayName(ChatColor.GREEN + "Reload");
                ArrayList<String> ssreload_lore = new ArrayList<>();
                ssreload_lore.add(ChatColor.AQUA + "Reloads the plugin");
                ssreload_meta.setLore(ssreload_lore);
                ssreload.setItemMeta(ssreload_meta);

                ItemMeta bans_meta = bans.getItemMeta();
                bans_meta.setDisplayName(ChatColor.GREEN + "Bans");
                ArrayList<String> bans_lore = new ArrayList<>();
                bans_lore.add(ChatColor.AQUA + "Banlist");
                bans_meta.setLore(bans_lore);
                bans.setItemMeta(bans_meta);

                ItemMeta vanish_meta = vanish.getItemMeta();
                vanish_meta.setDisplayName(ChatColor.GREEN + "Vanish");
                ArrayList<String> vanish_lore = new ArrayList<>();
                vanish_lore.add(ChatColor.AQUA + "Become invisible");
                vanish_meta.setLore(vanish_lore);
                vanish.setItemMeta(vanish_meta);

                ItemMeta mutechat_meta = mutechat.getItemMeta();
                mutechat_meta.setDisplayName(ChatColor.GREEN + "Mute Chat");
                ArrayList<String> mutechat_lore = new ArrayList<>();
                mutechat_lore.add(ChatColor.AQUA + "Toggles Chat");
                mutechat_meta.setLore(mutechat_lore);
                mutechat.setItemMeta(mutechat_meta);


                ItemStack[] menu_items = {none2, none8, none6, ssreload, none1, mutechat, none4, none11, none10, none5, none9, clearchat, none7, fly, none17, bans, none12, none13, none14, none15, none16, gamemodes, none18, vanish, none19, none20, none21};
                Staff.setContents(menu_items);
                player.openInventory(Staff);
            } else player.sendMessage(ChatColor.RED + "You do not have permission to execute this command");



        } return true;
    }
}