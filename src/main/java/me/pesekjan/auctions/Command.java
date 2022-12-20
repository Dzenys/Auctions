package me.pesekjan.auctions;

import me.pesekjan.auctions.guis.AuctionGui;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Command implements org.bukkit.command.CommandExecutor {

    public static Map<Player, Integer> PAGE = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String s, String[] args) {


        if (!(sender instanceof Player player))
            return true;

        if (args.length == 0){
            player.sendMessage(ChatColor.GRAY + "======Dostupne prikazy======");
            player.sendMessage(ChatColor.RED + "/am add <hodnota>" + ChatColor.YELLOW + " - prida item do aukce");
        }

        if (args[0].equals("add")) {
            if (args.length == 1){
                player.sendMessage(ChatColor.RED + "Nenastavil jsi hodnotu predmetu");
                return true;
            }

            if (args[1].matches("\\d+")) {
                if (player.getItemInUse() == null) player.sendMessage(ChatColor.RED + "Nedrzis v ruce predmet");

                ItemStack item = player.getItemInUse().clone();
                player.sendMessage(ChatColor.RED + "Predmet byl vlozen do aukce");
                player.getInventory().setItemInMainHand(null);
                AuctionEntry entry = new AuctionEntry(item, Integer.parseInt(args[1]), player.getName(), System.currentTimeMillis());
                AuctionEntry.AUCTION_ENTRIES.add(entry);
                AuctionEntry.PLAYER_ENTRIES_MAP.putIfAbsent(player, new ArrayList<>());
                AuctionEntry.PLAYER_ENTRIES_MAP.get(player).add(entry);
                return true;
            }
        }

        if(args[0].equals("open")){
            PAGE.put(player, 1);
            player.openInventory(AuctionGui.gui(1));
        }
        return true;
    }
}
