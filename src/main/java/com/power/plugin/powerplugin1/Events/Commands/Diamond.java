package com.power.plugin.powerplugin1.Events.Commands;

import com.github.spark.lib.commands.Command;
import com.github.spark.lib.commands.annotations.CommandHandler;
import com.github.spark.lib.commands.dto.CommandContext;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandHandler(root = true, name = "diamond")
public class Diamond implements Command {
    @Override
    public boolean onCommand(CommandContext commandContext) {
        Player player = commandContext.player();

        if (commandContext.hasMoreParams()) {
            int amount = Integer.parseInt(commandContext.nextParam());
            player.getInventory().addItem(new ItemStack(Material.DIAMOND, amount));
        }
        else {
            player.getInventory().addItem(new ItemStack(Material.DIAMOND, 1));
        }
        return true;
    }
    @CommandHandler(name = "juica")
    public boolean onJuica(CommandContext commandContext) {
        return false;
    }
}
