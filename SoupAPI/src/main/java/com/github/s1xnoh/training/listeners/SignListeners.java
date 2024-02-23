//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.github.s1xnoh.training.listeners;

import com.github.s1xnoh.training.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class SignListeners implements Listener {

    public static Main pl;
    public SignListeners() {
    }

    @EventHandler
    public void onSignChange(SignChangeEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("soupapi.sign")) {
            if (event.getLine(0).equalsIgnoreCase("sopa")) {
                event.setLine(0, "§c-§6-§e-§a-§b-");
                event.setLine(1, Main.TextoPlaca);
                event.setLine(2, "§lSOPA");
                event.setLine(3, "§c-§6-§e-§a-§b-");
            } else if (event.getLine(0).equalsIgnoreCase("recraft")) {
                event.setLine(0, "§c-§6-§e-§a-§b-");
                event.setLine(1, Main.TextoPlaca);
                event.setLine(2, "§lRECRAFT");
                event.setLine(3, "§c-§6-§e-§a-§b-");
            } else if (event.getLine(0).equalsIgnoreCase("cocoa")) {
                event.setLine(0, "§c-§6-§e-§a-§b-");
                event.setLine(1, Main.TextoPlaca);
                event.setLine(2, "§lCOCOA");
                event.setLine(3, "§c-§6-§e-§a-§b-");
            } else if (event.getLine(0).equalsIgnoreCase("cactus")) {
                event.setLine(0, "§c-§6-§e-§a-§b-");
                event.setLine(1, Main.TextoPlaca);
                event.setLine(2, "§lCACTUS");
                event.setLine(3, "§c-§6-§e-§a-§b-");
            }
        } else {
            player.sendMessage("§cNo permission!");
        }

    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock() != null && event.getClickedBlock().getState() instanceof Sign) {
            if (event.getPlayer().getGameMode() == GameMode.CREATIVE && event.getAction() == Action.LEFT_CLICK_BLOCK) {
                return;
            }

            Sign sign = (Sign)event.getClickedBlock().getState();
            boolean soup = sign.getLine(2).equals("§lSOPA");
            if (soup) {
                Inventory inventory = Bukkit.createInventory((InventoryHolder)null, 54, "Sopas");

                for(int i = 0; i < inventory.getSize(); ++i) {
                    inventory.setItem(i, new ItemStack(Material.MUSHROOM_SOUP));
                }

                event.getPlayer().openInventory(inventory);
                return;
            }

            boolean recraft = sign.getLine(2).equals("§lRECRAFT");
            if (recraft) {
                Inventory inventory = Bukkit.createInventory((InventoryHolder)null, 27, "Recraft");
                int i = 0;

                int ii;
                for(ii = 0; ii < 27; ++ii) {
                    if (i == 3) {
                        i = 0;
                    }

                    if (i == 0) {
                        inventory.addItem(new ItemStack[]{new ItemStack(Material.BOWL, 64)});
                    } else if (i == 1) {
                        inventory.addItem(new ItemStack[]{new ItemStack(Material.RED_MUSHROOM, 64)});
                    } else if (i == 2) {
                        inventory.addItem(new ItemStack[]{new ItemStack(Material.BROWN_MUSHROOM, 64)});
                    }

                    ++i;
                }
                event.getPlayer().openInventory(inventory);
            }
            boolean cocoa = sign.getLine(2).equals("§lCOCOA");
            if (cocoa) {
                Inventory inventory = Bukkit.createInventory((InventoryHolder)null, 27, "Cocoabean");
                int i = 0;

                int ii;
                for(ii = 0; ii < 27; ++ii) {
                    if (i == 3) {
                        i = 0;
                    }

                    if (i == 0) {
                        inventory.addItem(new ItemStack[]{new ItemStack(Material.BOWL, 64)});
                    } else if (i == 1) {
                        inventory.addItem(new ItemStack[]{new ItemStack(Material.getMaterial(351), 64, (short)3)});
                    } else if (i == 2) {
                        inventory.addItem(new ItemStack[]{new ItemStack(Material.getMaterial(351), 64, (short)3)});
                    }

                    ++i;
                }
                event.getPlayer().openInventory(inventory);
            }
            boolean cactus = sign.getLine(2).equals("§lCACTUS");
            if (cactus) {
                Inventory inventory = Bukkit.createInventory((InventoryHolder)null, 27, "Cactus");
                int i = 0;

                int ii;
                for(ii = 0; ii < 27; ++ii) {
                    if (i == 3) {
                        i = 0;
                    }

                    if (i == 0) {
                        inventory.addItem(new ItemStack[]{new ItemStack(Material.BOWL, 64)});
                    } else if (i == 1) {
                        inventory.addItem(new ItemStack[]{new ItemStack(Material.getMaterial(81), 64)});
                    } else if (i == 2) {
                        inventory.addItem(new ItemStack[]{new ItemStack(Material.getMaterial(81), 64)});
                    }

                    ++i;
                }
                event.getPlayer().openInventory(inventory);
            }
        }

    }
}
