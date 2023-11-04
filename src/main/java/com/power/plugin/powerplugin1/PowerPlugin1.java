package com.power.plugin.powerplugin1;

import com.power.plugin.powerplugin1.Events.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class PowerPlugin1 extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Hello World!");
        registerListeners();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new FireStaff(), this);
        this.getServer().getPluginManager().registerEvents(new LightningStaff(), this);
        this.getServer().getPluginManager().registerEvents(new ExplosiveBow(), this);
        this.getServer().getPluginManager().registerEvents(new IceStaff(), this);
    }
}
