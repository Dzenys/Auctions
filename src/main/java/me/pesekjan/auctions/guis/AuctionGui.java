package me.pesekjan.auctions.guis;

import me.pesekjan.auctions.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class AuctionGui {

    public static final String AUCTIONGUI = ChatColor.YELLOW + (ChatColor.BOLD + "Aukcni Mistnost");
    private static final int[] auctionItemLocations = {11,12,13,14,15,16,17,20,21,22,23,24,25,26,29,30,31,32,33,34,35,38,39,40,41,42,43,44};


    public static Inventory gui1() {

        int inventorySize = 54;
        Inventory inventory = Bukkit.createInventory(null, inventorySize, AUCTIONGUI);

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
        SkullMeta sm = (SkullMeta)p.getItemMeta();
        if (im != null) im.setDisplayName(ChatColor.RED + (ChatColor.BOLD + "Dalsi stranka"));
        p.setItemMeta(im);
        inventory.setItem(itemLocations[0], p);

        ItemStack p2 = Utils.getTextureHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDU5YmUxNTU3MjAxYzdmZjFhMGIzNjk2ZDE5ZWFiNDEwNDg4MGQ2YTljZGI0ZDVmYTIxYjZkYWE5ZGIyZDEifX19==");
        ItemMeta im2 = p2.getItemMeta();
        if (im2 != null) im2.setDisplayName(ChatColor.RED + (ChatColor.BOLD + "Predchozi stranka"));
        p2.setItemMeta(im2);
        inventory.setItem(itemLocations[1], p2);

        for (int i = 0; i < auctionItemLocations.length; i++) {

        }

        return inventory;


    }
}
