package me.pesekjan.auctions.guis;

import me.pesekjan.auctions.AuctionEntry;
import me.pesekjan.auctions.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuctionGui {

    public static final String AUCTIONGUI = ChatColor.YELLOW + (ChatColor.BOLD + "Aukcni Mistnost");
    public static final int[] auctionItemLocations = {11,12,13,14,15,16,17,20,21,22,23,24,25,26,29,30,31,32,33,34,35,38,39,40,41,42,43,44};


    public static Inventory gui(int page) {

        int inventorySize = 54;
        Inventory inventory = Bukkit.createInventory(null, inventorySize, AUCTIONGUI + " (Stranka " + page + ")");

        ItemStack glassPane = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta im = glassPane.getItemMeta();
        if (im != null) im.setDisplayName(ChatColor.WHITE + "");
        glassPane.setItemMeta(im);

        for (int i = 0; i < inventorySize; i++) {
            inventory.setItem(i, glassPane);
        }

        int[] itemLocations = {48, 52};

        ItemStack p = Utils.getTextureHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDJiMGMwN2ZhMGU4OTIzN2Q2NzllMTMxMTZiNWFhNzVhZWJiMzRlOWM5NjhjNmJhZGIyNTFlMTI3YmRkNWIxIn19fQ==");
        im = p.getItemMeta();
        if (im != null) im.setDisplayName(ChatColor.RED + (ChatColor.BOLD + "Dalsi stranka"));
        p.setItemMeta(im);
        inventory.setItem(itemLocations[0], p);

        ItemStack p2 = Utils.getTextureHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDU5YmUxNTU3MjAxYzdmZjFhMGIzNjk2ZDE5ZWFiNDEwNDg4MGQ2YTljZGI0ZDVmYTIxYjZkYWE5ZGIyZDEifX19==");
        ItemMeta im2 = p2.getItemMeta();
        if (im2 != null) im2.setDisplayName(ChatColor.RED + (ChatColor.BOLD + "Predchozi stranka"));
        p2.setItemMeta(im2);
        inventory.setItem(itemLocations[1], p2);

        int slot = 0;
        for (int i = AuctionEntry.AUCTION_ENTRIES.size()-1-(auctionItemLocations.length * (page-1)); i > -1; i--) {
            AuctionEntry entry = AuctionEntry.AUCTION_ENTRIES.get(i);

            ItemStack item = entry.itemStack;
            ItemMeta meta = item.getItemMeta();
            assert meta != null;
            List<String> lore = new ArrayList<>(meta.getLore() != null ? meta.getLore() : Collections.emptyList());
            lore.add("");
            lore.add("Cena predmetu: " + ChatColor.RED + entry.price);
            meta.setLore(lore);
            item.setItemMeta(meta);

            inventory.setItem(auctionItemLocations[slot],item);
            slot++;
            if(slot >= auctionItemLocations.length) break;
        }

        return inventory;


    }
}
