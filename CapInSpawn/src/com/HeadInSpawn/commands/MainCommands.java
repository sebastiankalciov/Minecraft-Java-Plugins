package com.HeadInSpawn.commands;

import com.HeadInSpawn.CapInSpawn;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class MainCommands {

    private final Plugin plugin = CapInSpawn.getPlugin(CapInSpawn.class);

    public void addHead(String name, String message, CommandSender player) { // Comanda care adauga un cap in lista

        Player jucator = (Player) player;
        // Initializam o variabila jucator ce contine object ul player
        // Adaugam capul in config file.
        plugin.getConfig().set("Heads." + name + ".Message", String.format("%s", message));
        // Salvam fisierul
        plugin.saveConfig();

        //.sendMessage(String.format("%s", plugin.getConfig().getString("Heads.ionel.Message").replaceAll("(&([a-f0-9]))", "\u00A7$2")));;
        jucator.sendMessage(ChatColor.GRAY + "[CapInSpawn] " + ChatColor.RED+ String.format("Cap " + ChatColor.WHITE + "<%s>" + ChatColor.RED + " adaugat cu succes!", name));
        // Trimitem un mesaj in chat sa anunte user-ul ca a fost adaugat capul in lista.
    }
    public void getMessage(String name, CommandSender player) { // Comanda care afiseaza in chat mesajul unui cap

        String message = plugin.getConfig().getString(String.format("Heads.%s.Message", name));
        // Initializam o variabila message ce contine mesajul nemodificat al capului
        String messageColored = message != null ? message.replaceAll("(&([a-f0-9]))", "\u00A7$2") : null;
        // Initializam o variabila messageColored ce contine mesajul modificat daca acesta nu este null, in caz contrar, se seteaza valorea null

        if (messageColored != null) {
            // Daca mesajul nu este null, asta insemnand ca exista un cap cu numele <name>
            // Trimite mesajul in chat
            player.sendMessage(String.format(ChatColor.GRAY + "[%s] -> %s", name, messageColored));
        } else {
            // In caz contrar, se afiseaza in chat un mesaj corespunzator situatiei
            player.sendMessage(ChatColor.GRAY + "[CapInSpawn] " + ChatColor.RED + "Capul specificat nu exista!");
        }

    }
}
