package com.HeadInSpawn;

import org.bukkit.Color;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.HeadInSpawn.commands.MainCommands;
import com.HeadInSpawn.events.MainEvents;
import javax.annotation.Nonnull;
import java.util.Arrays;

public class CapInSpawn extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("\n[CapInSpawn] turning on...");
        getServer().getPluginManager().registerEvents(new MainEvents(), this);
        loadConfig();

    }
    @Override
    public boolean onCommand(@Nonnull CommandSender player, Command command, @Nonnull String label, @Nonnull String[] args) {

        if (command.getName().equals("addHead")) {
            
            // If there are no given arguments it stops the execution
            if (args.length == 0 || args.length == 1) {
             
                return false;
            } else {
         

                StringBuilder rawInput = new StringBuilder();

                for (int i = 1; i < args.length; i++)
                {
                    rawInput.append(args[i]).append(" ");
                }
                
                // args[0] is the name of the head
                String message = rawInput.toString().trim();
                new MainCommands().addHead(args[0], message, player);

            }

        } else if (command.getName().equals("getMessage")) {
            
            if (args.length == 0) {
    
                return false;
            } else {
                new MainCommands().getMessage(args[0], player);
            }
        }
        return true;
    }

    @Override
    public void onDisable() {
        System.out.println("\n[CapInSpawn] shutting down...");
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true).header("""
                                    --- Config File CapInSpawn ---
                 
                 - Commands -
                 
                 /addHead <nume_cap> <mesaj> - Adauga un cap in lista cu capete. <--- Adaugat
                 /getMessage <nume_cap> - Vezi ce mesaj trimite un anumit cap. <--- Adaugat
                 /removeHead <nume_cap> - Sterge un cap. <--- In lucru
                 /heads - Vezi toate capetele disponibile. <--- In lucru
                 
                 """);

        saveConfig();
    }
}
