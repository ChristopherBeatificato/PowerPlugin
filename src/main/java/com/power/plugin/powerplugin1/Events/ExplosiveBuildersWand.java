package com.power.plugin.powerplugin1.Events;

import com.github.spark.lib.events.RegisterEvents;
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
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        ItemStack stack = event.getItem();
        if (stack == null) {
            return;
        }
        if (stack.getType() == Material.SPYGLASS) {
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
