package com.github.s1xnoh.training.events;

import com.github.s1xnoh.training.Main;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class Soup implements Listener {
    public Soup() {
    }


    @EventHandler
    public void onSoup(PlayerInteractEvent event) {
        Main main = null;
        if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && event.getMaterial() != null && event.getItem() != null && event.getMaterial() == Material.MUSHROOM_SOUP) {
            Player player = event.getPlayer();
            if (player.getHealth() != player.getMaxHealth()) {
                if (player.getHealth() > player.getMaxHealth() - (double)main.Regenerar) {
                    player.setHealth(player.getMaxHealth());
                } else {
                    player.setHealth(player.getHealth() + (double)main.Regenerar);
                }

                event.getItem().setType(Material.BOWL);
            }
        }

    }
}