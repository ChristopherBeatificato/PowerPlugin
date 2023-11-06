package com.power.plugin.powerplugin1.Events.Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class DiamondCommand implements Listener {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("diamond") && sender instanceof Player player) {
            ItemStack stack = new ItemStack(Material.STICK, 1);
            player.getInventory().addItem(new ItemStack(Material.DIAMOND, 3));
            player.sendMessage("Here are your 3 diamonds juica");
            player.getInventory().addItem(stack);
            return true;
        }
        return false;
    }
    public void onCommand(Player)
}
