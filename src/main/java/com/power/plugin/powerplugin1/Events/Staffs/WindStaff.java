package com.power.plugin.powerplugin1.Events.Staffs;

import com.github.spark.lib.events.annotations.RegisterEvents;
import com.github.spark.lib.services.custom.MetadataService;
import com.google.inject.Inject;
import com.power.plugin.powerplugin1.Constants.Constants;
import com.power.plugin.powerplugin1.DataStores.PlayerState;
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
@RegisterEvents
public class WindStaff implements Listener {
    @Inject
    MetadataService metaService;
    @Inject
    PlayerState playerState;
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().isLeftClick()) {
            Player player = event.getPlayer();
            ItemStack stack = event.getItem();

            if (stack == null) {
                return;
            }
            if (stack.getType() == Material.STICK) {
                if (metaService.getMetaBoolean(stack, Constants.WANDWIND_KEY)) {
                    if (playerState.selectedClass.equalsIgnoreCase("Earth")) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 20 * 8, 5));
                        return;
                    }
                }
            }
        }
    }
        @EventHandler
    public void onEntityTarget(EntityTargetEvent event){
        Mob mob = (Mob) event.getEntity().getNearbyEntities(5, 5, 5);
        mob.setTarget(null);
    }
}
