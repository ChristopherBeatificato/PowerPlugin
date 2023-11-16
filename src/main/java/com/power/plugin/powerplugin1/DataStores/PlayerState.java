package com.power.plugin.powerplugin1.DataStores;

import com.github.spark.lib.datastores.DataStoreItem;
import com.github.spark.lib.datastores.annotations.ItemKey;
import org.bukkit.entity.Player;

public class PlayerState extends DataStoreItem {
    @ItemKey
    public String playerId;
    public String selectedClass;
    public String classLevel;
    public int mana;

    public static PlayerState createDefault(Player player){
        PlayerState newState = new PlayerState();
        newState.selectedClass = "";
        newState.classLevel = "";
        newState.mana = 100;
        newState.playerId = player.getUniqueId().toString();
        return newState;
    }
}
