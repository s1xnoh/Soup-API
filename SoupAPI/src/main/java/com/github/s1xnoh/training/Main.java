package com.github.s1xnoh.training;

import com.github.s1xnoh.training.events.Events;
import com.github.s1xnoh.training.events.Soup;
import com.github.s1xnoh.training.listeners.SignListeners;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.Bukkit;
import org.sqlite.SQLite;
import org.bukkit.Material;

import java.util.logging.Logger;

public final class Main extends JavaPlugin implements Listener {
    public static Main instance;

    public static int Regenerar;
    public static String TextoPlaca;
    public static int Fome;

    private static final Logger LOGGER = Logger.getLogger("Minecraft");

    @Override
    public void onLoad() {
        this.getLogger().info("§aPlugin incializando...");
        saveDefaultConfig();
    }


    public static Main getInstance() {
        return instance;
    }



    public void onEnable() {
        this.reloadConfig();
        Regenerar = this.getConfig().getInt("Regenerar");
        Fome = this.getConfig().getInt("Fome");
        TextoPlaca = this.getConfig().getString("TextoPlaca").replace("&", "§");
        this.getLogger().info("§aPlugin ligado com sucesso!");
        Bukkit.getPluginManager().registerEvents(new Events(), this);
        Bukkit.getPluginManager().registerEvents(new SignListeners(), this);
        Bukkit.getPluginManager().registerEvents(new Soup(), this);
        this.getServer().getPluginManager().registerEvents(this, this);
        this.hrecipe();
        this.onMsgsInfos();
    }

    public void onDisable() {

        this.offMsgsInfos();
        saveConfig();

    }

    public void onMsgsInfos(){
        logColorMessage("§7");
        logColorMessage("§7");
        logColorMessage("§7");
        logColorMessage("§a[SoupAPI] §fVersion: §aSoupAPI-1.0-SNAPSHOT");
        logColorMessage("§a[SoupAPI] §fAuthor: §as1xnoh");
        logColorMessage("§a[SoupAPI] §fPlugin ligado com sucesso!");
        logColorMessage("§7");
        logColorMessage("§7");
        logColorMessage("§7");
    }

    public void offMsgsInfos(){
        logColorMessage("§7");
        logColorMessage("§7");
        logColorMessage("§7");
        logColorMessage("§a[SoupAPI] §fVersion: §aSoupAPI-1.0-SNAPSHOT");
        logColorMessage("§a[SoupAPI] §fAuthor: §as1xnoh");
        logColorMessage("§a[SoupAPI] §cPlugin desligado com sucesso!");
        logColorMessage("§7");
        logColorMessage("§7");
        logColorMessage("§7");
    }





    // Msg colorida no console

    private void logColorMessage(String message) {
        // Adiciona código de formatação de cores ao logger
        Bukkit.getConsoleSender().sendMessage(colorize(message));
    }

    private String colorize(String message) {
        // Permite a formatação de cores usando códigos de cores do Minecraft
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public void hrecipe() {
        ItemStack result10;
        ItemMeta cacti10;
        ShapelessRecipe abobora10;
        if (this.getConfig().getBoolean("Cocoabean")) {
            result10 = new ItemStack(Material.MUSHROOM_SOUP, 1);
            cacti10 = result10.getItemMeta();
            result10.setItemMeta(cacti10);
            abobora10 = new ShapelessRecipe(result10);
            abobora10.addIngredient(1, Material.INK_SACK, 3);
            abobora10.addIngredient(1, Material.BOWL);
            this.getServer().addRecipe(abobora10);
        }

        if (this.getConfig().getBoolean("Cacto")) {
            result10 = new ItemStack(Material.MUSHROOM_SOUP, 1);
            cacti10 = result10.getItemMeta();
            result10.setItemMeta(cacti10);
            abobora10 = new ShapelessRecipe(result10);
            abobora10.addIngredient(1, Material.CACTUS);
            abobora10.addIngredient(1, Material.BOWL);
            this.getServer().addRecipe(abobora10);
        }

        if (this.getConfig().getBoolean("Fungo")) {
            result10 = new ItemStack(Material.MUSHROOM_SOUP, 1);
            cacti10 = result10.getItemMeta();
            result10.setItemMeta(cacti10);
            abobora10 = new ShapelessRecipe(result10);
            abobora10.addIngredient(1, Material.NETHER_STALK);
            abobora10.addIngredient(1, Material.BOWL);
            this.getServer().addRecipe(abobora10);
        }

        if (this.getConfig().getBoolean("Abobora")) {
            result10 = new ItemStack(Material.MUSHROOM_SOUP, 1);
            cacti10 = result10.getItemMeta();
            result10.setItemMeta(cacti10);
            abobora10 = new ShapelessRecipe(result10);
            abobora10.addIngredient(1, Material.PUMPKIN_SEEDS);
            abobora10.addIngredient(1, Material.BOWL);
            this.getServer().addRecipe(abobora10);
        }

        if (this.getConfig().getBoolean("Melao")) {
            result10 = new ItemStack(Material.MUSHROOM_SOUP, 1);
            cacti10 = result10.getItemMeta();
            result10.setItemMeta(cacti10);
            abobora10 = new ShapelessRecipe(result10);
            abobora10.addIngredient(1, Material.MELON_SEEDS);
            abobora10.addIngredient(1, Material.BOWL);
            this.getServer().addRecipe(abobora10);
        }

    }

    @EventHandler
    public void EventoResope(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        int vida = this.getConfig().getInt("Regenerar");
        int fome = this.getConfig().getInt("Fome");
        if (event.getItem() != null) {
            if ((event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && player.getInventory().getItemInHand().getType().equals(Material.MUSHROOM_SOUP) && (player.getGameMode() == GameMode.SURVIVAL || player.getGameMode() == GameMode.ADVENTURE)) {
                ItemStack Pote = new ItemStack(Material.BOWL, 1);
                ItemMeta pote3;
                if (player.getHealth() < 20.0) {
                    player.setHealth(player.getHealth() + (double)vida >= 20.0 ? 20.0 : player.getHealth() + (double)vida);
                    pote3 = Pote.getItemMeta();
                    event.getItem().setType(Material.BOWL);
                    player.getInventory().setItemInHand(Pote);
                    return;
                }

                if (player.getFoodLevel() <= 19) {
                    player.setFoodLevel(player.getFoodLevel() + fome >= 20 ? 20 : player.getFoodLevel() + fome);
                    event.getItem().setType(Material.BOWL);
                    pote3 = Pote.getItemMeta();
                }
            }

        }
    }


























}

