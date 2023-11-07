package com.power.plugin.powerplugin1.Events.Staffs;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class WindStaff implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if (event.getAction().isLeftClick()) {
            Player player = event.getPlayer();
            ItemStack stack = event.getItem();

            if (stack == null) {
                return;
            }
            if (stack.getType() == Material.DIAMOND_HOE) {
<<<<<<< Updated upstream
                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20 * 8, 5));

=======
                    hasHoe = true;
                    return;
            }
            if (hasHoe) {
                onEntityTarget();
                player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20 * 8, 1));
>>>>>>> Stashed changes
            }
        }
    }
    public void onEntityTarget(EntityTargetEvent event){
        Mob mob = (Mob) event.getEntity().getNearbyEntities(5, 5, 5);
        mob.setTarget(null);
    }
}
