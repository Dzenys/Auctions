package me.pesekjan.auctions;

import me.pesekjan.auctions.guis.AuctionGui;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class ClickListeners implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent ce) {

        if (!ce.getView().getTitle().startsWith(AuctionGui.AUCTIONGUI))
            return;
            ce.setCancelled(true);
            if (ce.getCurrentItem() == null) return;
        Player player = (Player) ce.getWhoClicked();
        int page = Command.PAGE.get(player);
        Inventory inventory = ce.getClickedInventory();
        if (inventory == null) return;

        switch (ce.getSlot()) {
            case 52 -> {
                player.openInventory(AuctionGui.gui(++page));
                Command.PAGE.put(player, page);
            }
            case 48 -> {

                player.openInventory(AuctionGui.gui(--page));
                Command.PAGE.put(player, page);

            }

            case 11,12,13,14,15,16,17,20,21,22,23,24,25,26,29,30,31,32,33,34,35,38,39,40,41,42,43,44 -> {
                int index = 0;
                for (int i = 0; i < AuctionGui.auctionItemLocations.length; i++) {
                    if(AuctionGui.auctionItemLocations[i] != ce.getSlot()) continue;
                    index = i;
                    break;
                }
                index = AuctionGui.auctionItemLocations.length * (page-1) + index;
                AuctionEntry entry = AuctionEntry.AUCTION_ENTRIES.get(index);
                int price = entry.price;

                double balance = Auctions.rsp.getProvider().getBalance(player);
                if (balance < price) {
                    player.sendMessage(ChatColor.RED + "Nemas dostatek penez", ChatColor.RED + "Ke koupi ti chybi " + ChatColor.YELLOW + (price-balance));
                    return;
                }

                HashMap<Integer, ItemStack> result = inventory.addItem(entry.itemStack);
                if(result.values().size() > 0) {
                    player.sendMessage(ChatColor.RED + "Mas plny inventar");
                    return;
                }
                AuctionEntry.AUCTION_ENTRIES.remove(index);
                Auctions.rsp.getProvider().withdrawPlayer(player, price);
                Auctions.rsp.getProvider().depositPlayer(Bukkit.getOfflinePlayer(entry.uuid), price);
                for(Player onlinePlayer: Bukkit.getOnlinePlayers()) {
                    if (onlinePlayer.getOpenInventory().getTitle().startsWith(AuctionGui.AUCTIONGUI))
                        onlinePlayer.openInventory(AuctionGui.gui(page));
                }


            }


}
}
}


