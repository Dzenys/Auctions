package me.pesekjan.auctions;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class Config {

    public static void save() {
        FileConfiguration config = Auctions.getPlugin().getConfig();
        for(AuctionEntry entry : AuctionEntry.AUCTION_ENTRIES){
            config.set(entry.timestamp + ".itemStack", entry.itemStack);
            config.set(entry.timestamp + ".uuid", entry.uuid);
            config.set(entry.timestamp + ".price", entry.price);
            config.set(entry.timestamp + ".timestamp", entry.timestamp);
        }
        Auctions.getPlugin().saveConfig();
    }

    public static void load() {
        FileConfiguration config = Auctions.getPlugin().getConfig();
        for (String key : config.getKeys(false)) {
            ItemStack stack = config.getItemStack(key + ".itemStack");
            int price = config.getInt(key + ".price");
            String owner = config.getString(key + ".uuid");
            if(owner == null) continue;
            UUID uuid = UUID.fromString(owner);
            long timestamp = config.getLong(key + ".timestamp");
            AuctionEntry entry = new AuctionEntry(stack, price, uuid, timestamp);
            AuctionEntry.AUCTION_ENTRIES.add(entry);
        }
    }

}
