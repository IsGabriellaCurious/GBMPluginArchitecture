package moe.gabriella.gbmpa.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

/**
 * Logging utility for GBMPA plugins. Allows info, warn, error and debug messages to be sent with different colours!
 */
public class PALogger {

    /**
     * Sends an info line to the console.
     *
     * @param message Info message displayed in console.
     */
    public static void info(String message) { Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.WHITE + "[" + PAConsts.pluginName + "] " + message); }

    /**
     * Sends a warn line to the console.
     *
     * @param message Warn message displayed in console.
     */
    public static void warn(String message) { Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + "[" + PAConsts.pluginName + ": WARN] " + message); }

    /**
     * Sends an error line to the console.
     *
     * @param message Error message displayed in console.
     */
    public static void error(String message) { Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "[" + PAConsts.pluginName + ": ERROR] " + message); }

    /**
     * Sends a debug line to the console.
     *
     * @param message Debug message displayed in console.
     */
    public static void debug(String message) { Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "[" + PAConsts.pluginName + ": DEBUG] " + message); }

}
