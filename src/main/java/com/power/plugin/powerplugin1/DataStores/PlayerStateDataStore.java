package com.power.plugin.powerplugin1.DataStores;

import com.github.spark.lib.datastores.DataStore;
import com.github.spark.lib.datastores.annotations.RegisterDataStore;
import org.bukkit.entity.Player;

import java.util.function.Supplier;

@RegisterDataStore
public class PlayerStateDataStore extends DataStore<PlayerState> {
    public PlayerState getByPlayer(Player player) {

        return findById(player.getUniqueId().toString());
    }
    public PlayerState getOrDefaultCreate(Player player) {
        return super.getOrDefaultCreate(
                player.getUniqueId().toString(),
                () -> PlayerState.createDefault(player)
        );
    }

    public PlayerState getOrDefaultCreate(Player player, Supplier<PlayerState> defaultCreator) {
        return super.getOrDefaultCreate(player.getUniqueId().toString(), defaultCreator);
    }
}
