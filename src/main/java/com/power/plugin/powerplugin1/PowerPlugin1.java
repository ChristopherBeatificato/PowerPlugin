package com.power.plugin.powerplugin1;

import com.github.spark.lib.SparkContext;
import com.github.spark.lib.SparkPlugin;
import com.power.plugin.powerplugin1.Events.*;
import com.power.plugin.powerplugin1.Events.Staffs.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class PowerPlugin1 extends SparkPlugin {
    @Override
    public void onBeforeFrameworkInitialize() {
        SparkContext.setBasePackage("com.power.plugin.powerplugin1");
    }

    @Override
    public void onFrameworkEnable() {
        System.out.println("Hello World!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerListeners() {
        this.getServer().getPluginManager().registerEvents(new FireStaff(), this);
        this.getServer().getPluginManager().registerEvents(new LightningStaff(), this);
        this.getServer().getPluginManager().registerEvents(new ExplosiveBuildersWand(), this);
        this.getServer().getPluginManager().registerEvents(new IceStaff(), this);
        this.getServer().getPluginManager().registerEvents(new WindStaff(), this);
        this.getServer().getPluginManager().registerEvents(new EarthStaff(), this);
        this.getServer().getPluginManager().registerEvents(new NatureStaff(), this);
    }
}
