package com.power.plugin.powerplugin1.Events.Commands;

import com.github.spark.lib.commands.Command;
import com.github.spark.lib.commands.CommandHandler;
import com.github.spark.lib.commands.dto.CommandContext;
import com.github.spark.lib.services.custom.MetadataService;
import com.google.inject.Inject;
import com.power.plugin.powerplugin1.Constants.Constants;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandHandler(root = true, name = "wand")
public class GiveWand implements Command {
    @Inject
    MetadataService metaService;
    @Override
    public boolean onCommand(CommandContext commandContext) {
        Player player = commandContext.player();

        if (commandContext.hasMoreParams()) {
            String wandType = commandContext.nextParam();
            if (wandType.equalsIgnoreCase("Ice")) {
                player.getInventory().addItem(new ItemStack(Material.STICK));
                metaService.setMeta(stack, Constants.WANDICE_KEY, true);
                return true;
            }
            else if (wandType.equalsIgnoreCase("Fire")) {
                player.getInventory().addItem(new ItemStack(Material.STICK));
                metaService.setMeta(stack, Constants.WANDFIRE_KEY, true);
                return true;
            }
            else if (wandType.equalsIgnoreCase("Wind")) {
                player.getInventory().addItem(new ItemStack(Material.STICK));
                metaService.setMeta(stack, Constants.WANDWIND_KEY, true);
                return true;
            }
            else if (wandType.equalsIgnoreCase("Lightning")) {
                player.getInventory().addItem(new ItemStack(Material.STICK));
                metaService.setMeta(stack, Constants.WANDNATURE_KEY, true);
                return true;
            }
            else if (wandType.equalsIgnoreCase("Earth")) {
                player.getInventory().addItem(new ItemStack(Material.STICK));
                metaService.setMeta(stack, Constants.WANDLIGHTNING_KEY, true);
                return true;
            }
            else if (wandType.equalsIgnoreCase("Nature")) {
                player.getInventory().addItem(new ItemStack(Material.STICK));
                metaService.setMeta(stack, Constants.WANDEARTH_KEY, true);
                return true;
            }
        }
        else {
            return true;
        }
    }
        /*Player player = commandContext.player();
        ItemStack stack = new ItemStack (Material.STICK, 1);
        player.getInventory().addItem(stack);
        metaService.setMeta(stack, Constants.WAND_KEY, true);
        return true;*/
}