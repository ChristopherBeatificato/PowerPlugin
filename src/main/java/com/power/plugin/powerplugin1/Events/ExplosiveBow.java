package com.power.plugin.powerplugin1.Events;

import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ExplosiveBow implements Listener {
    @EventHandler
    public void onBowHit(ProjectileHitEvent event){
        if (event.getEntity() instanceof Arrow arrow){
            arrow.getWorld().createExplosion(arrow.getLocation(), 20F);
        }
    }
}
