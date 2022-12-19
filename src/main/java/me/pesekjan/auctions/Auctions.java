package me.pesekjan.auctions;

import org.bukkit.plugin.java.JavaPlugin;

public class Auctions extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("am").setExecutor(new Command());
    }

    public void onDisable() {

    }
}
