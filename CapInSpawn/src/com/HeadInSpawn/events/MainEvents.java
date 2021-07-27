package com.HeadInSpawn.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;


public class MainEvents implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock() != null) {

            if (event.getClickedBlock().getState() instanceof Skull) {
                Block block = event.getClickedBlock();
                BlockState blockstate = block.getState();
                Skull skull = (Skull) blockstate;

                //SkullMeta cap2 = (SkullMeta) skull;
                System.out.println(skull.getBlock().getType().getData().getTypeName());



                /*
                 *
                 *                 Block block = event.getClickedBlock();
                 *                 BlockState blockstate = block.getState();
                 *                 Skull skull = (Skull) blockstate;
                 *                 //Skull cap = (Skull) event.getClickedBlock().getState(); --- functioneaza
                 *                 //SkullMeta cap2 = (SkullMeta) skull;
                 *                 System.out.println(skull.getPersistentDataContainer());
                 */
            }
        }

    }
}
