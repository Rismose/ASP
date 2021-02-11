
package me.rismsoe.astaffplugin;

import me.rismsoe.astaffplugin.Base.*;
import me.rismsoe.astaffplugin.Files.CustomConfig;
import me.rismsoe.astaffplugin.events.ClickEvent;
import me.rismsoe.astaffplugin.events.ClickEvent2;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class AStaffPlugin extends JavaPlugin implements Listener {

    public HashMap<Player, Location> frozenPlayers = new HashMap<>();

    public ArrayList<Player> invisible_list = new ArrayList<>();


    Set<Player> mutedPlayers;
    Set<String> spam;
    public String Prefix;
    public String Permission;
    public String GlobalMuteMessage;
    public String GlobalMuteEnabled;
    public String GlobalMuteDisabled;
    private boolean globalChat;


    public AStaffPlugin() {

        this.mutedPlayers = new HashSet<Player>();
        this.spam = new HashSet<String>();
        this.Prefix = this.getConfig().getString("Prefix");
        this.Permission = this.getConfig().getString("Permission");

        this.GlobalMuteMessage = this.getConfig().getString("GlobalMuteMessage");
        this.GlobalMuteEnabled = this.getConfig().getString("GlobalMuteEnabled");
        this.GlobalMuteDisabled = this.getConfig().getString("GlobalMuteDisabled");
        this.globalChat = true;
    }


    public void onEnable() {
        this.saveDefaultConfig();
        this.reloadConfig();
        Bukkit.getConsoleSender().sendMessage("§7[§dASP§7] §bYou are running version §e" + this.getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage("§7[§dASP§7] §bBy §e Rismose");
        Bukkit.getConsoleSender().sendMessage("§7[§dASP§7] §bFully Loaded");
        final PluginManager pm = this.getServer().getPluginManager();


        getCommand("asp").setExecutor(new GUIMenu());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("gamemodemenu").setExecutor(new GamemodeGUI());
        getCommand("clearchat").setExecutor(new ClearChatCommand());
        getCommand("freeze").setExecutor(new FreezeCommand(this));
        getCommand("vanish").setExecutor(new VanishCommand(this));


        getConfig().options().copyDefaults();
        saveDefaultConfig();

        CustomConfig.setup();
        CustomConfig.get().addDefault("FlyToggleOFF", "You can no longer fly");
        CustomConfig.get().addDefault("FlyToggleON", "You can now fly");
        CustomConfig.get().addDefault("ClearChatMessage", "The chat has been cleared by an administrator.");
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.save();

        getServer().getPluginManager().registerEvents(new ClickEvent(), this);
        getServer().getPluginManager().registerEvents(new ClickEvent2(), this);
        getServer().getPluginManager().registerEvents((Listener) this, this);
    }


    @EventHandler
    public void onPlayerMoveBlock(PlayerMoveEvent e) {
        if (!frozenPlayers.containsKey(e.getPlayer())) {
            return;
        }
        if (e.getFrom().getBlockX() != e.getTo().getBlockX() || e.getFrom().getBlockZ() != e.getTo().getBlockZ()) {
            e.getPlayer().teleport(frozenPlayers.get(e.getPlayer()));
        }
    }

    @EventHandler
    public void GlobalMute(final AsyncPlayerChatEvent gm) {
        if (this.globalChat) {
            return;
        }
        if (gm.getPlayer().hasPermission("mutechat.bypass")) {
            return;
        }
        gm.setCancelled(true);
        gm.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', this.Prefix + this.GlobalMuteMessage));
    }

    @EventHandler
    public void onPlayerChat(final AsyncPlayerChatEvent e) {
        e.getRecipients().removeAll(this.mutedPlayers);
    }


    public void onDisable() {
        System.out.println("ASP has been disabled");
    }

    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player player = (Player) sender;
        final List<String> banList = new ArrayList<>();
        int banNum = 0;
        for (final OfflinePlayer p3 : Bukkit.getBannedPlayers()) {
            banList.add(p3.getName());
            ++banNum;
        }
        final String banNumS = Integer.toString(banNum);
        if (player.hasPermission("asp.Banlist")) {
            if (cmd.getName().equalsIgnoreCase("Bans")) {
                if (this.getConfig().getBoolean("BansList enable")) {
                    final String banL = this.getConfig().getString("BansList Prefix").replace("%bt%", banNumS);
                    final String banLColor = ChatColor.translateAlternateColorCodes('&', banL);
                    player.sendMessage(banLColor + banList);
                    return true;
                }
                player.sendMessage(ChatColor.DARK_RED + "This command has been disabled.");
                return true;
            }
        } else if (!player.hasPermission("asp.Banlist")) {
            player.sendMessage(ChatColor.RED + "You do not have permission to execute this command");
            return true;
        }
        if (player.hasPermission("asp.staff") && cmd.getName().equalsIgnoreCase("UUID")) {
            final int length = args.length;
            if (length == 1) {
                boolean playerFound = false;
                OfflinePlayer[] offlinePlayers;
                for (int length2 = (offlinePlayers = Bukkit.getServer().getOfflinePlayers()).length, k = 0; k < length2; ++k) {
                    final OfflinePlayer uuidPlayer = offlinePlayers[k];
                    if (uuidPlayer.getName().equalsIgnoreCase(args[0])) {
                        player.sendMessage(ChatColor.RED + uuidPlayer.getName() + ": " + ChatColor.AQUA + uuidPlayer.getUniqueId());
                        playerFound = true;
                        break;
                    }
                }
                if (!playerFound) {
                    player.sendMessage(ChatColor.DARK_RED + args[0] + " is not a player!");
                }
            } else if (!player.hasPermission("asp.staff")) {
                player.sendMessage(ChatColor.RED + "You do not have permission to execute this command");
                return true;
            }
            return true;
        }
        if (player.hasPermission("asp.Reload")) {
            if (cmd.getName().equalsIgnoreCase("aspreload")) {
                CustomConfig.reload();
                this.reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "ASP has been reloaded.");
                return true;
            }
        } else {
            player.sendMessage(ChatColor.RED + "You do not have permission to execute this command");
        }
        if (cmd.getName().equalsIgnoreCase("aspver")) {
            this.reloadConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.Prefix + ChatColor.AQUA + "You are running ASP " + ChatColor.GREEN + this.getDescription().getVersion()));
            return true;
        } else if (label.equalsIgnoreCase("mutechat")) {
            if (!sender.hasPermission("asp.mutechat")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.Prefix + this.Permission));
                return true;
            }
            this.globalChat = !this.globalChat;
            if (this.globalChat) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.Prefix + "" + this.GlobalMuteEnabled));
                return true;
            }
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', this.Prefix + this.GlobalMuteDisabled));
        }    return true;
    }
}
