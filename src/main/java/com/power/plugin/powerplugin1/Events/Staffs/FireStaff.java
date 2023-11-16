package com.power.plugin.powerplugin1.Events.Staffs;

import com.github.spark.lib.events.annotations.RegisterEvents;
import com.github.spark.lib.services.custom.MetadataService;
import com.google.inject.Inject;
import com.power.plugin.powerplugin1.Constants.Constants;
import com.power.plugin.powerplugin1.DataStores.PlayerState;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

@RegisterEvents
public class FireStaff implements Listener {
    @Inject MetadataService metaService;
    @Inject PlayerState playerState;
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (event.getAction().isRightClick()) {
            Player player = event.getPlayer();

            ItemStack stack = event.getItem();
            if (stack == null) {
                return;
            }
            if (stack.getType() == Material.STICK) {
                if (metaService.getMetaBoolean(stack, Constants.WANDFIRE_KEY) == Boolean.TRUE) {
                    if (playerState.selectedClass.equalsIgnoreCase("Earth")) {
                        int distanceToSpawn = 2;
                        double fireballVelocity = 0.8;

                        Location eyeLocation = player.getEyeLocation();
                        Vector direction = eyeLocation.getDirection();

                        Location fireballSpawnPoint = eyeLocation.add(direction.clone().multiply(distanceToSpawn));
                        //Cow cow = player.getWorld().spawn(fireballSpawnPoint, Cow.class);
                        Fireball fireball = player.getWorld().spawn(fireballSpawnPoint, Fireball.class);
                        fireball.setYield(0);
                        fireball.setDirection(direction);
                        fireball.setYield(0);
                        fireball.setVelocity(direction.normalize().multiply(fireballVelocity));
                        //fireball.addPassenger(cow);
                    }
                }
            }
        }
    }
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event){
        if (event.getEntity() instanceof Fireball fireball) {
            fireball.getWorld().createExplosion(fireball.getLocation(), 2, true, false);
        }
    }
    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Mob) {
            if (event.getDamager() instanceof Player player) {
                boolean hasAmethyst = false;
                for (ItemStack stack : player.getInventory().getContents()) {
                    if (stack != null && stack.getType() == Material.STICK) {
                        if (metaService.getMetaBoolean(stack, Constants.WANDFIRE_KEY) == Boolean.TRUE) {
                            if (playerState.selectedClass.equalsIgnoreCase("Earth")) {
                                hasAmethyst = true;
                                break;
                            }
                        }
                    }
                }
                if (hasAmethyst) {
                    event.getEntity().setFireTicks(20 * 8);
                }
            }
        }
    }
}
