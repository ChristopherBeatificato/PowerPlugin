package com.power.plugin.powerplugin1.Events.Levels;

import com.google.inject.Inject;
import com.power.plugin.powerplugin1.DataStores.PlayerState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;
import com.power.plugin.powerplugin1.Events.Commands.ClassSelect;
public class EventsClass implements Listener {
    @Inject
    PlayerState playerState;
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        ScoreboardManager m = Bukkit.getScoreboardManager();
        Scoreboard b = m.getNewScoreboard();
        Objective o = b.registerNewObjective("Class Level", "");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(ChatColor.DARK_AQUA + "Navarta");
        Score classLevel = o.getScore(ChatColor.WHITE + "Class Level: " + ChatColor.GOLD + playerState.classLevel);
        classLevel.setScore(1);
        player.setScoreboard(b);
        Score selectedClass = o.getScore(ChatColor.WHITE + "Class Selected: " + ChatColor.GOLD + playerState.selectedClass);
        selectedClass.setScore(3);
        player.setScoreboard(b);
        Score mana = o.getScore(ChatColor.WHITE + "Mana: " + ChatColor.GOLD + playerState.mana);
        mana.setScore(3);
        player.setScoreboard(b);
    }
}
