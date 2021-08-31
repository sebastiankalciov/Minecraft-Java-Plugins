package com.vallionblocker.utils;

import com.vallionblocker.Main;
import com.vallionblocker.events.ChatListener;
import com.vallionblocker.Main;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;


import java.io.File;
import java.io.IOException;
import java.util.*;

public class MainUtils {


    private final Plugin plugin = Main.getPlugin();
    private Configuration Config;




    public void reloadPlugin() {

        if (this.plugin != null) {
            this.plugin.getProxy().getPluginManager().unregisterListeners(this.plugin);
            this.plugin.getProxy().getPluginManager().registerListener(this.plugin, new ChatListener());

        }
    }



}
