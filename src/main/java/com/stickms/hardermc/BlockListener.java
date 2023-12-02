package com.stickms.hardermc;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.Random;

public class BlockListener implements Listener {
    private final ItemStack POO;
    public BlockListener(){
        POO = new ItemStack(Material.COCOA_BEANS);
        ItemMeta pooMeta = POO.getItemMeta();
        pooMeta.setDisplayName(ChatColor.of("#7B3F00") + "Poo");
        pooMeta.setLore(Collections.singletonList("Smells funny"));
        POO.setItemMeta(pooMeta);
    }

    @EventHandler
    public void onDrop(BlockDropItemEvent e){
        Player player = e.getPlayer();
        int random = new Random().nextInt(100);
        if (random <5){
            e.setCancelled(true);
            player.getWorld().dropItemNaturally(player.getLocation(), POO);
        } else if (random<20) {
            player.getWorld().dropItemNaturally(player.getLocation(), POO);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        int random = new Random().nextInt(100);
        if (random == 1) {
            e.setCancelled(true);
            e.getBlockPlaced().setType(Material.DIRT);
        } else if (random == 2) {
            e.setCancelled(true);
            e.getBlockPlaced().setType(Material.SAND);
        }
    }

    @EventHandler
    public void onUseBed(PlayerBedEnterEvent e){
        Player player = e.getPlayer();
        int random = new Random().nextInt(50);
        if (random == 1) player.getWorld().createExplosion(player.getLocation(), 4F, true);
    }
}
