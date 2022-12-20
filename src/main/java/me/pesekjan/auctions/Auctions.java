package me.pesekjan.auctions;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Auctions extends JavaPlugin {

        public static RegisteredServiceProvider<Economy> rsp;

    @Override
    public void onEnable() {
        getCommand("am").setExecutor(new Command());
        getServer().getServicesManager().getRegistration(Economy.class);
    }

    public void onDisable() {

    }
}
