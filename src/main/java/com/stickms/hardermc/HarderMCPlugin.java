package com.stickms.hardermc;

import org.bukkit.plugin.java.JavaPlugin;

public final class HarderMCPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BlockListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
