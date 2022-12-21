package me.pesekjan.auctions;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Auctions extends JavaPlugin {

    private static Auctions plugin;
    public static Auctions getPlugin() {
        return plugin;
    }

    public static RegisteredServiceProvider<Economy> rsp;

    @Override
    public void onEnable() {
        plugin = this;
        getCommand("am").setExecutor(new Command());
        getServer().getPluginManager().registerEvents(new ClickListeners(), this);
        getServer().getServicesManager().getRegistration(Economy.class);
        saveDefaultConfig();
        Config.load();
    }

    public void onDisable() {
        Config.save();

    }
}
