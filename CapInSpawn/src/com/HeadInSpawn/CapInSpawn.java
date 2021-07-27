package com.HeadInSpawn;

// Importam clase, functii, obiecte necesare
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
        // Eventul onCommand verifica daca o comanda utilizata de user este una dintre ale plugin-ului
        // Astfel adaugam conditii pentru a verifica acest lucru
        if (command.getName().equals("addHead")) {
            // Daca numele comenzii este addHead si utilizatorul nu a specificat niste argumente
            if (args.length == 0 || args.length == 1) {
                // Se returneaza valoarea false si mai apoi se trimite in chat utilizarea corecta a comenzii
                return false;
            } else {
                // In caz contrar, se apeleaza o functie din clasa cu comenzi

                StringBuilder sb = new StringBuilder();
                // Initializam o variabila de tip builder
                // pentru a adauga fiecare argument din lista cu argumente intr un singur string
                for (int i = 1; i < args.length; i++)
                {
                    sb.append(args[i]).append(" ");
                }
                // Ca apoi sa initializam o variabila message ce contine toata argumentele, exceptand primul,
                // acesta fiind considerat numele capului
                String message = sb.toString().trim();
                new MainCommands().addHead(args[0], message, player);

            }

        } else if (command.getName().equals("getMessage")) {
            // Daca numele comenzii este addHead si utilizatorul nu a specificat numele capului
            if (args.length == 0) {
                // Se efectueaza aceeasi operatie ca la comanda anterioara
                return false;
            } else {
                // In caz contrar, se efectueaza ca la comanda anterioara, doar utilizand alta functie
                new MainCommands().getMessage(args[0], player);

            }
        }
        return true;
        // Se returneaza valorea true asta inseamna ca, comanda a fost utilizata cu succes
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
