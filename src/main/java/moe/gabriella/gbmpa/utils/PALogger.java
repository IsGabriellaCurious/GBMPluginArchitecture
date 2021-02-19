package moe.gabriella.gbmpa.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class PALogger {

    public static void info(String message) { Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.WHITE + "[" + PAConsts.pluginName + "] " + message); }
    public static void warn(String message) { Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[" + PAConsts.pluginName + ": WARN] " + message); }
    public static void error(String message) { Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "[" + PAConsts.pluginName + ": ERROR] " + message); }
    public static void debug(String message) { Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "[" + PAConsts.pluginName + ": DEBUG] " + message); }

}
