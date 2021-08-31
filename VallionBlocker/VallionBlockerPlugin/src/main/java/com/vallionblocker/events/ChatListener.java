package com.vallionblocker.events;

import com.vallionblocker.Main;
import com.vallionblocker.utils.ConfigManager;
// Importam clase utile pentru listener

import com.vallionblocker.utils.MainUtils;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

import net.kyori.adventure.platform.bungeecord.BungeeAudiences;

import java.io.IOException;

public class ChatListener implements Listener {

    // Event pentru cand user-ul scrie ceva in chat
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChatEvent(net.md_5.bungee.api.event.ChatEvent event) throws IOException {
        // Daca Eventul este anulat, oprim tot
        if (event.isCancelled()) return;
        // Daca cel care trimite event ul nu este un user, oprim tot
        if (!(event.getSender() instanceof ProxiedPlayer)) return;

        // Definim o variabila player ce retine user-ul care trimite mesaje in chat
        ProxiedPlayer player = (ProxiedPlayer) event.getSender();


        // Definim o variabila command ce retine ce a scris user-ul in chat fara majuscule
        String command = event.getMessage().toLowerCase();

        // Daca textul scris de user contine un slash, atunci inseamna ca useru intentioneaza
        // sa foloseasca o comanda, si taiem slash ul sa ramana doar comanda
        if (command.startsWith("/")) {
            command = command.substring(1);
        }

        BungeeAudiences audiences = Main.getAudiences();
        // Daca variabila active este true, inseamna ca user-ul poate primi kick daca foloseste comenzile din lista
        if (new ConfigManager().getConfig("Config").getBoolean("active")) {
            // Daca lista cu comenzi contine comanda respectiva
            if (new ConfigManager().getConfig("Config").getStringList("commands").contains(command)) {
                // Anuleaza eventul si trimite in consola dar si in chat mesaje corespunzatoare
                event.setCancelled(true);

                TextComponent text = new TextComponent(ChatColor.GRAY + "[" + ChatColor.RED + "VallionBlocker" + ChatColor.GRAY + "]"+ "\n" + ChatColor.WHITE + new ConfigManager().getConfig("Config").get("message_kick").toString().replace("\n", System.getProperty("line.separator")));
                System.out.println(ChatColor.GRAY + "[" + ChatColor.RED + "VallionBlocker" + ChatColor.GRAY + "]: " + ChatColor.WHITE + new ConfigManager().getConfig("Config").get("message_kick_console").toString().replace("{{player}}", ChatColor.RED + player.getName() + ChatColor.WHITE).replace("{{command}}", ChatColor.RED + command + ChatColor.WHITE));
                player.disconnect(text);


            }
        }

    }

}
