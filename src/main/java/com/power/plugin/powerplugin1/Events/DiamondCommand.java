package com.power.plugin.powerplugin1.Events;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class DiamondCommand implements Listener {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("diamond") && sender instanceof Player player) {
            player.getInventory().addItem(new ItemStack(Material.DIAMOND, 3));
            player.sendMessage("Here are your 3 diamonds juica");
            return true;
        }
        return false;
    }
}
