package com.vallionblocker;


// Importam clasele din mavel de la bungecoord si cele ale pluginului
import com.vallionblocker.events.ChatListener;
import com.vallionblocker.commands.MainCommands;
import com.vallionblocker.utils.MainUtils;
import com.vallionblocker.utils.ConfigManager;


import net.kyori.adventure.platform.bungeecord.BungeeAudiences;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.ChatColor;

import java.io.IOException;

// Clasa principala a pluginului
public final class Main extends Plugin {

    private static BungeeAudiences audiences;
    private static Main plugin;
    private static MainUtils Utils;
    //private static ConfigCache configCache;

    @Override
    public void onEnable() {
        plugin = this;
        System.out.println(ChatColor.GRAY + "[" + ChatColor.RED+"VallionBlocker" + ChatColor.GRAY+"]:" + ChatColor.WHITE + " Turning on...");

        new ConfigManager().createFolder();
        try {
            new ConfigManager().reloadConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.getProxy().getPluginManager().registerListener(plugin, new ChatListener());

    }


    // Functii utile //

    public static Plugin getPlugin() {
        return plugin;
    }

    public static BungeeAudiences getAudiences() {
        return audiences;
    }



    @Override
    public void onDisable() {
        System.out.println(ChatColor.GRAY + "[" + ChatColor.RED+"VallionBlocker" + ChatColor.GRAY+"]:" + ChatColor.WHITE + " Turning off...");
    }
}
