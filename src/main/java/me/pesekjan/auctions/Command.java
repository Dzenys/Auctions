package me.pesekjan.auctions;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Command implements org.bukkit.command.CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String s, String[] args) {

        if (!(sender instanceof Player player))
            return true;

        if (args.length == 0){
            player.sendMessage(ChatColor.GRAY + "======Dostupne prikazy======");
            player.sendMessage(ChatColor.RED + "/ah add <hodnota>" + ChatColor.YELLOW + " - prida item do aukce");
        }

        if (args[0].equals("add")) {
            if (args.length == 1){
                player.sendMessage(ChatColor.RED + "Nenastavil jsi hodnotu predmetu");
                return true;
            }

            if (args[1].matches("\\d+")) {
                if (player.getItemInUse() == null) player.sendMessage(ChatColor.RED + "Nedrzis v ruce predmet");
                AuctionEntry entry = new AuctionEntry(player.getItemInUse(), Integer.parseInt(args[1]), player.getName(), System.currentTimeMillis());
                player.getInventory().setItemInMainHand(null);
                player.sendMessage(ChatColor.RED + "Predmet byl vlozen do aukce");
                return true;
            }
        }
        return true;
    }
}
