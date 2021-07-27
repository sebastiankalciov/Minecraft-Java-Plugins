package com.duckdev.events;

// Importing required libraries and classes
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.Listener;

public class mainEvents implements Listener { // Main class which contains the events.

    // Event in case player drops an item
    @EventHandler(priority = EventPriority.HIGH)
    public static void PlayerDropItemEvent(PlayerDropItemEvent event) {

        String dropName; // Declarating 2 variables, one which stores the name of the dropped item
        Location locatie; // And another the location of player
        dropName = event.getItemDrop().getName(); // Assigning the data to variables
        locatie = event.getPlayer().getLocation();
        // Play a sound when player drops something
        event.getPlayer().playSound(locatie, Sound.BLOCK_WET_GRASS_FALL, 0.7F, 0.7F);
        // Sends a message after that.
        event.getPlayer().sendMessage(String.format(ChatColor.RED+ "Am aruncat pe jos %s", dropName));



    }

}