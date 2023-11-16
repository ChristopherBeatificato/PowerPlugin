package com.power.plugin.powerplugin1.Events.Commands;

import com.github.spark.lib.commands.Command;
import com.github.spark.lib.commands.annotations.CommandHandler;
import com.github.spark.lib.commands.dto.CommandContext;
import com.github.spark.lib.services.annotations.Service;
import com.google.inject.Inject;
import com.power.plugin.powerplugin1.DataStores.PlayerState;
import org.bukkit.entity.Player;

@Service
@CommandHandler(root = true, name = "Class")
public class ClassSelect implements Command {
    @Inject PlayerState playerState;
    @Override
    public boolean onCommand(CommandContext commandContext) {
        Player player = commandContext.player();
        if (commandContext.hasMoreParams()) {
            String classType = commandContext.nextParam();
            if (classType.equalsIgnoreCase("Earth")) {
                playerState.classLevel = "Earth";
            }
            else if (classType.equalsIgnoreCase("Fire")) {
                playerState.classLevel = "Fire";
            }
            else if (classType.equalsIgnoreCase("Ice")) {
                playerState.classLevel = "Ice";
            }
            else if (classType.equalsIgnoreCase("Lightning")) {
                playerState.classLevel = "Lightning";
            }
            else if (classType.equalsIgnoreCase("Nature")) {
                playerState.classLevel = "Nature";
            }
            else if (classType.equalsIgnoreCase("Wind")) {
                playerState.classLevel = "Wind";
            }
        }
        return true;
    }
}
