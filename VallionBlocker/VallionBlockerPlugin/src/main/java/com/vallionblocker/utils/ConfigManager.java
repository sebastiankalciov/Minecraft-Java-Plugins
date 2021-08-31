package com.vallionblocker.utils;

import com.vallionblocker.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ConfigManager {

    private final Plugin plugin = Main.getPlugin();
    private Configuration Config;



    public void createFolder() {

        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }

        File ConfigFile = new File(plugin.getDataFolder(), "config.yml");
        if (!ConfigFile.exists()) {
            try {
                ConfigFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        loaderConfiguration();

    }

    private void loaderConfiguration() {
        try {

            Config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(plugin.getDataFolder(), "config.yml"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Configuration getConfig(String file) {

        if (file.equalsIgnoreCase("Config")) {
            if (Config == null) {
                try {
                    reloadConfig();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return Config;
        }

        //().warning(color("&4Error &7>>> &cthe configuration files have failed"));
        return null;
    }

    public void saveConfig() {
        if ((Config != null)) {
            try {
                ConfigurationProvider.getProvider(YamlConfiguration.class).save(Config, new File(plugin.getDataFolder(), "config.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public void reloadConfig() throws IOException {


        Config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(plugin.getDataFolder(), "config.yml"));

        if (!Config.contains("message_kick_console")) {
            Config.set("message_kick_console", "{{player}} a incercat sa foloseasca {{command}}");
        }
        if (!Config.contains("message_kick")) {
            Config.set("message_kick", "morti tei te crezi batman aicia?");
        }

        if (!Config.contains("active")) {
            Config.set("active", true);
        }

        if (!Config.contains("commands")) {

            List<String> stringList = new ArrayList<>();

            stringList.add("defaultCommand1");
            stringList.add("defaultCommand2");

            Config.set("commands", stringList);
            Config.getStringList("commands").add("defaultCommand");

        }

        saveConfig();


    }


    public String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
