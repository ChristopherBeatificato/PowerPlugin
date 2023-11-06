package com.power.plugin.powerplugin1.Events.Staffs;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class IceStaff implements Listener {

    @EventHandler
    public void onLeftClick(PlayerInteractEvent event) {
        if (event.getAction().isLeftClick()) {
            Player player = event.getPlayer();
            boolean hasCopper = false;
            ItemStack stack = event.getItem();
            if (stack == null) {
                return;
            }
            if (stack.getType() == Material.STICK) {
                hasCopper = true;
                return;

            }
            if (hasCopper) {
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 8, 10));
            }
        }
    }
}
