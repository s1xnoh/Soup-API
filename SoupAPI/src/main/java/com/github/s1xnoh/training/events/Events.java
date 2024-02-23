package com.github.s1xnoh.training.events;

import com.github.s1xnoh.training.Main;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;


public class Events implements Listener {

    @EventHandler
    public void aoEntrar(PlayerJoinEvent event) {
        Player player = event.getPlayer();
    }

    @EventHandler
    public void aoSair(PlayerQuitEvent event) {
        Player player = event.getPlayer();



    }


}
