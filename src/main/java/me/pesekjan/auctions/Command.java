package me.pesekjan.auctions;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements org.bukkit.command.CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String s, String[] args) {

        if (!(sender instanceof Player))
            return true;

        Player player = ((Player) sender);

        if (args.length == 0){
            player.sendMessage(ChatColor.GRAY + "======Dostupne prikazy======");
            player.sendMessage(ChatColor.RED + "/ah add <hodnota>" + ChatColor.YELLOW + " - prida item do aukce");

        }
        if (args.length != 1){
            player.sendMessage(ChatColor.RED + "Neplatny prikaz");
        }










        return true;
    }
}
