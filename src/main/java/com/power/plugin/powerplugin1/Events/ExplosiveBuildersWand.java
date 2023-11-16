package com.power.plugin.powerplugin1.Events;

import com.github.spark.lib.events.annotations.RegisterEvents;
import com.github.spark.lib.services.custom.MetadataService;
import com.google.inject.Inject;
import com.power.plugin.powerplugin1.Constants.Constants;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.RayTraceResult;
@RegisterEvents
public class ExplosiveBuildersWand implements Listener {
    @Inject
    MetadataService metaService;
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (event.getAction().isRightClick()) {
            ItemStack stack = event.getItem();
            if (stack == null) {
                return;
            }
            if (stack.getType() == Material.STICK) {
                if (metaService.getMetaBoolean(stack, Constants.WANDEXPLOSIVE_KEY) == Boolean.TRUE) {
                    RayTraceResult ray = event.getPlayer().rayTraceBlocks(120);
                    if (ray == null || ray.getHitBlock() == null) {
                        return;
                    }
                    Block hitBlock = ray.getHitBlock();
                    World world = hitBlock.getWorld();
                    world.createExplosion(new Location(world, hitBlock.getX(), hitBlock.getY() + 1, hitBlock.getZ()), 50F);
                }
            }
        }
    }
}
