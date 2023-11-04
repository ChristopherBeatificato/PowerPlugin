package com.power.plugin.powerplugin1.Events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
public class PlayerInteractListener implements Listener{


    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event){
        if (event.getEntity() instanceof Fireball fireball) {
            fireball.getWorld().createExplosion(fireball.getLocation(), 100);
        }
    }
}
