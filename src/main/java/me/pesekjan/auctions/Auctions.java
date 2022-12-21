package me.pesekjan.auctions;

import org.bukkit.plugin.java.JavaPlugin;

public class Auctions extends JavaPlugin {

    private static Auctions plugin;
    public static Auctions getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        getCommand("am").setExecutor(new Command());
        getServer().getPluginManager().registerEvents(new ClickListeners(), this);
        saveDefaultConfig();
        Config.load();
    }

    public void onDisable() {
        Config.save();
    }
}
