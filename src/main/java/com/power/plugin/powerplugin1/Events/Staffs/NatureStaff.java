package com.power.plugin.powerplugin1.Events.Staffs;

import com.github.spark.lib.events.RegisterEvents;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.Nullable;
@RegisterEvents
public class NatureStaff implements Listener {
    private Entity ExperienceOrb;
@EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if (event.getAction().isRightClick()){
            Player player = event.getPlayer();
            ItemStack stack = event.getItem();
            if (stack == null) {
                return;
            }
            if (stack.getType() == Material.VINE) {
                player.damage(7, ExperienceOrb);
                for (Player other: Bukkit.getOnlinePlayers()) {
                    if (other.getLocation().distance(player.getLocation()) <= 5){
                        other.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20 * 4, 1));
                        player.removePotionEffect(PotionEffectType.REGENERATION);
                    }
                }
            }

        }
    }
}
