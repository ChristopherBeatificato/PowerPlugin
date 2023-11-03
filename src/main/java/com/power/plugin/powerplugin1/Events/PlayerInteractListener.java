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

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        ItemStack stack = event.getItem();
        if (stack == null) {
            return;
        }
        if (stack.getType() == Material.STICK) {
            RayTraceResult ray = event.getPlayer().rayTraceBlocks(120);
            if (ray == null || ray.getHitBlock() == null) {
                return;
            }
            Block hitBlock = ray.getHitBlock();
            World world = hitBlock.getWorld();
            world.strikeLightning(new Location(world, hitBlock.getX(), hitBlock.getY() + 1, hitBlock.getZ()));
            world.createExplosion(new Location(world, hitBlock.getX(), hitBlock.getY() + 1, hitBlock.getZ()), 50F);
        }

    }

    @EventHandler
    public void onLeftClick(PlayerInteractEvent event) {
        if (event.getAction().isLeftClick()) {
            Player player = event.getPlayer();
            boolean hasCopper = false;
            ItemStack stack = event.getItem();
            if (stack == null) {
                return;
            }
            if (stack.getType() == Material.COPPER_INGOT) {
                hasCopper = true;
                return;

            }
            if (hasCopper) {
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 8, 10));
            }
        }
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (event.getAction().isLeftClick()) {
            Player player = event.getPlayer();

            ItemStack stack = event.getItem();
            if (stack == null) {
                return;
            }
            if (stack.getType() == Material.LIGHTNING_ROD) {
                int distanceToSpawn = 2;
                double fireballVelocity = 0.01;

                Location eyeLocation = player.getEyeLocation();
                Vector direction = eyeLocation.getDirection();

                Location fireballSpawnPoint = eyeLocation.add(direction.clone().multiply(distanceToSpawn));
                Cow cow = player.getWorld().spawn(fireballSpawnPoint, Cow.class);
                Fireball fireball = player.getWorld().spawn(fireballSpawnPoint, Fireball.class);
                fireball.setDirection(direction);
                fireball.setVelocity(direction.normalize().multiply(fireballVelocity));
                fireball.addPassenger(cow);
                System.out.println(direction.normalize().multiply(fireballVelocity));
            }
        }
    }
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event){
        if (event.getEntity() instanceof Fireball fireball) {
            fireball.getWorld().createExplosion(fireball.getLocation(), 100);
        }
    }
}
