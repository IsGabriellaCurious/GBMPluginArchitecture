package moe.gabriella.gbmpa.utils;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

/**
 * Utility class to speed up certain actions that involve Players that are often a bit complicated to do and take up a lot of space.
 */
public class PAPlayerUtils {

    /**
     * Sends an action bar to a specific player.
     *
     * @param player Player who will receive the action bar
     * @param message The message that will show on the action bar.
     */
    public static void sendActionbar(Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
    }

    /**
     * Broadcasts an action bar to all online players (achieved by looping through Bukkit#getServer#getOnlinePlayers).
     *
     * @param message The message that will show on the action bar.
     */
    public static void broadcastActionbar(String message) {
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            sendActionbar(p, message);
        }
    }

    /**
     * Broadcasts a title to all online players.
     *
     * @param top Message on the top text of the title.
     * @param bottom Message on the bottom text of the title.
     * @param fadeIn Amount of time taken to fade in the title (in ticks).
     * @param stay Amount of time the title will stay on screen (after fade in and before fade out) (in ticks).
     * @param fadeOut Amoung of time taken to fade out the title (in ticks).
     */
    public static void broadcastTitle(String top, String bottom, int fadeIn, int stay, int fadeOut) {
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            p.sendTitle(top, bottom, fadeIn, stay, fadeOut);
        }
    }

    /**
     * Broadcast a sound to all online players (achieved by looping through Bukkit#getServer#getOnlinePlayers).
     *
     * @param sound The sound that will be heard.
     * @param vol The volume of the sound (on a 0.0 - 1 scale).
     * @param pitch The pitch of the sound (on a 0.0 - 1 scale).
     */
    public static void broadcastSound(Sound sound, float vol, float pitch) {
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            p.playSound(p.getLocation(), sound, vol, pitch);
        }
    }

    /**
     * Plays a sound at a specific location in a world.
     *
     * @param loc The location to play the sound at.
     * @param sound The sound that will be heard.
     * @param vol The volume of the sound (on a 0.0 - 1 scale).
     * @param pitch The pitch of the sound (on a 0.0 - 1 scale).
     */
    public static void playSoundAt(Location loc, Sound sound, float vol, float pitch) {
        if (loc.getWorld() == null) {
            PALogger.error("Location for 'playSoundAt' is null!");
            return;
        }

        loc.getWorld().playSound(loc, sound, vol, pitch);
    }

    /**
     * Searches for a player from an input.<br>
     * This is achieved by looping through every online player and checking if their
     * name starts with the input param. If it does, it will return the player object.
     * If all players are looped through and no match is found, null will be returned.
     *
     * @param input Input for searching for a player.
     * @return Player who matches the input (null if no such player is found).
     */
    public static Player search(String input) {
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            String name = p.getName().toLowerCase();

            if (!name.startsWith(input.toLowerCase()))
                continue;

            return p;
        }
        return null;
    }

    /**
     * Get the distance between two players using Location#distance.
     *
     * @param player1 First player.
     * @param player2 Second player.
     * @return Distance between the two players.
     */
    public static double getDistanceFromPlayer(Player player1, Player player2){
        return player1.getLocation().distance(player2.getLocation());
    }

    /**
     * Clear a player's inventory by using PlayerInventory#clear, then removes the armour of a player
     * by individually going through each slot and setting it to null.
     *
     * @param player Target of the clear.
     */
    public static void clearInventory(Player player) {
        player.getInventory().clear();
        player.getInventory().setHelmet(null);
        player.getInventory().setChestplate(null);
        player.getInventory().setLeggings(null);
        player.getInventory().setBoots(null);
    }

    /**
     * Clears a player's potion effects by looping through every potion effect on the player and removing it.
     *
     * @param player Target of the clear.
     */
    public static void clearEffects(Player player) {
        for (PotionEffect e : player.getActivePotionEffects()) {
            player.removePotionEffect(e.getType());
        }
    }

}
