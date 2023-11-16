package com.power.plugin.powerplugin1.Events.Staffs;

import com.github.spark.lib.events.annotations.RegisterEvents;
import com.github.spark.lib.services.custom.MetadataService;
import com.google.inject.Inject;
import com.power.plugin.powerplugin1.Constants.Constants;
import com.power.plugin.powerplugin1.DataStores.PlayerState;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
@RegisterEvents
public class NatureStaff implements Listener {
    @Inject
    MetadataService metaService;
    @Inject
    PlayerState playerState;
    private Entity ExperienceOrb;
@EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if (event.getAction().isRightClick()){
            Player player = event.getPlayer();
            ItemStack stack = event.getItem();
            if (stack == null) {
                return;
            }
            if (stack.getType() == Material.STICK) {
                if (metaService.getMetaBoolean(stack, Constants.WANDNATURE_KEY)) {
                    if (playerState.selectedClass.equalsIgnoreCase("Earth")) {
                        player.damage(7, ExperienceOrb);
                        for (Player other : Bukkit.getOnlinePlayers()) {
                            if (other.getLocation().distance(player.getLocation()) <= 5) {
                                other.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20 * 4, 1));
                                player.removePotionEffect(PotionEffectType.REGENERATION);
                            }
                        }
                    }
                }
            }
        }
    }
}
