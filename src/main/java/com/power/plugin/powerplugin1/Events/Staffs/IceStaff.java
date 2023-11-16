package com.power.plugin.powerplugin1.Events.Staffs;

import com.github.spark.lib.events.annotations.RegisterEvents;
import com.github.spark.lib.services.custom.MetadataService;
import com.google.inject.Inject;
import com.power.plugin.powerplugin1.Constants.Constants;
import com.power.plugin.powerplugin1.DataStores.PlayerState;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
@RegisterEvents
public class IceStaff implements Listener {
    @Inject
    MetadataService metaService;
    @Inject
    PlayerState playerState;
    @EventHandler
    public void onLeftClick(PlayerInteractEvent event) {
        if (event.getAction().isLeftClick()) {
            Player player = event.getPlayer();
            ItemStack stack = event.getItem();
            if (stack == null) {
                return;
            }
            if (stack.getType() == Material.STICK) {
                if (metaService.getMetaBoolean(stack, Constants.WANDICE_KEY)) {
                    if (playerState.selectedClass.equalsIgnoreCase("Earth")) {
                        if (playerState.mana > 10) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 8, 2));
                            playerState.mana -= -10;
                        }
                    }
                }
            }
        }
    }
}
