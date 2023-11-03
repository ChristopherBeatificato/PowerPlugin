package com.power.plugin.powerplugin1.Events;

import org.bukkit.entity.Cow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.Material;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class EntityListener implements Listener {
    @EventHandler
    public void onEntityRightClick(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof Cow cow) {

            cow.getWorld().createExplosion(cow.getLocation(), 4F);
        }
    }


    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Mob) {
            if (event.getDamager() instanceof Player player) {
                System.out.println("here1");
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



