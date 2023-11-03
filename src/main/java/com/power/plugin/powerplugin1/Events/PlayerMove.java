package com.power.plugin.powerplugin1.Events;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import javax.swing.*;

public class PlayerMove implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        String playerMove = "Player Moved " + event.getPlayer().getName();
    }
}

/*
        Bukkit.broadcast(Component.text("juica"));
*/
