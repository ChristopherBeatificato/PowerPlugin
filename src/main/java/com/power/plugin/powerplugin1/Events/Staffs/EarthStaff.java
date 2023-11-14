package com.power.plugin.powerplugin1.Events.Staffs;

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
public class EarthStaff implements Listener {
    @EventHandler
    public void onPlayerInteraction(PlayerInteractEvent event){
        if (event.getAction().isRightClick()){
            ItemStack stack = event.getItem();
            if (stack == null) {
                return;
            }
            if (stack.getType() == Material.SCUTE) {
                RayTraceResult ray = event.getPlayer().rayTraceBlocks(120);
                if (ray == null || ray.getHitBlock() == null) {
                    return;
                }
                Block hitBlock = ray.getHitBlock();
                World world = hitBlock.getWorld();
<<<<<<< Updated upstream
=======
                if (1 == 1){
                    hitBlock.getWorld().setType(new Location(world, hitBlock.getX(), hitBlock.getY() + 1, hitBlock.getZ()), Material.STONE);
                    hitBlock.getWorld().setType(new Location(world, hitBlock.getX(), hitBlock.getY() + 2, hitBlock.getZ()), Material.STONE);
                    hitBlock.getWorld().setType(new Location(world, hitBlock.getX(), hitBlock.getY() + 3, hitBlock.getZ()), Material.STONE);
                }
>>>>>>> Stashed changes
            }
        }
    }
}
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
