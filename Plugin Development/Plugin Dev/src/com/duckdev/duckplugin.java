package com.duckdev;

// Importing necessities
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import com.duckdev.events.mainEvents;
import javax.annotation.Nonnull;

import com.duckdev.commands.mainCommands;

public class duckplugin extends JavaPlugin { // Main class of plugin

    // First function that is called when the plugin turns on
    @Override
    public void onEnable() {
        // Registering the events
        getServer().getPluginManager().registerEvents(new mainEvents(), this);
        // Printing a statement that announces that plugin is turning on
        System.out.print("\nDuck Plugin turning on...\n");

    }
    // Function that is called when a command is occured.
    @Override
    public boolean onCommand(@Nonnull CommandSender player, Command command, @Nonnull String label, @Nonnull String[] args) {
        // If the command in case is <salut> execute some stuff
        if (command.getName().equals("salut"))
        {
            new mainCommands().salut(player);
        } else if (command.getName().equals("devchest"))
        {

        }
        // After that, it returns false because function's type is boolean and requires a value on return.
        return false;
    }
    // Last function that is called, when the plugin is turning off
    @Override
    public void onDisable() {
        // Prints a statement that announces the event.
        System.out.print("\nDuck Plugin turning off...\n");
    }
}
