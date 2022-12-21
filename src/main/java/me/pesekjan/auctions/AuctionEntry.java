package me.pesekjan.auctions;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import java.util.*;

public class AuctionEntry {

    public ItemStack itemStack;
    public int price;
    public UUID uuid;
    public long timestamp;

    public static final Map<Player, List<AuctionEntry>> PLAYER_ENTRIES_MAP = new HashMap<>();
    public static final List<AuctionEntry> AUCTION_ENTRIES = new ArrayList<>();

    public AuctionEntry(ItemStack itemStack, int price, UUID uuid, long timestamp){
            this.itemStack = itemStack;
            this.price = price;
            this.uuid = uuid;
            this.timestamp = timestamp;
    }


}
