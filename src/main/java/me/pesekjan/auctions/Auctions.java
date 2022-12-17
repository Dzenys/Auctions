package me.pesekjan.auctions;

import org.bukkit.plugin.java.JavaPlugin;

public class Auctions extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("cw").setExecutor(new Command());
    }

    public void onDisable() {

    }
}
