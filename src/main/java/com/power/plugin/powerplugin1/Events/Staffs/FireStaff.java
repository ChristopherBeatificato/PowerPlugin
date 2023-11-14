package com.power.plugin.powerplugin1.Events.Staffs;

import com.destroystokyo.paper.event.block.BlockDestroyEvent;
import com.github.spark.lib.events.RegisterEvents;
import io.papermc.paper.event.block.BlockBreakBlockEvent;
import it.unimi.dsi.fastutil.ints.IntLists;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.type.Grindstone;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.eclipse.aether.metadata.Metadata;

import java.util.ArrayList;
import java.util.List;
@RegisterEvents
public class FireStaff implements Listener {
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (event.getAction().isRightClick()) {
            Player player = event.getPlayer();

            ItemStack stack = event.getItem();
            if (stack == null) {
                return;
            }
            if (stack.getType() == Material.END_ROD) {
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
                for (ItemStack stack :
                        player.getInventory().getContents()) {
                    if (stack != null && stack.getType() == Material.AMETHYST_SHARD) {
                        hasAmethyst = true;
                        break;
                    }
                }
                System.out.println(hasAmethyst);
                if (hasAmethyst) {
                    event.getEntity().setFireTicks(20 * 8);
                }
            }
        }
    }
}
