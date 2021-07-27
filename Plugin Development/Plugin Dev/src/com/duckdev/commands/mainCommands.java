package com.duckdev.commands;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class mainCommands {

    public void salut (CommandSender player) {

        Player jucator = (Player) player;
        Location locatie = jucator.getLocation();
        jucator.playSound(locatie, Sound.ENTITY_TURTLE_EGG_CRACK, 0.7F, 0.7F);
        jucator.giveExp(5);

    }

}
