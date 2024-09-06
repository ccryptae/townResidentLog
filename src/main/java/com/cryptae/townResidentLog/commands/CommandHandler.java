package com.cryptae.townResidentLog;

import com.palmergames.bukkit.towny.Towny;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.TownyUniverse;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CommandHandler implements CommandExecutor {

    private final TownResidentLog plugin;

    public CommandHandler(TownResidentLog plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command.");
            return false;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Usage: /town residentlog");
            return false;
        }

        if (args[0].equalsIgnoreCase("residentlog") || args[0].equalsIgnoreCase("reslog")) {
            Resident resident = TownyUniverse.getDataSource().getResident(player.getUniqueId()).orElse(null);

            if (resident == null || !resident.hasTown()) {
                player.sendMessage(ChatColor.RED + "You are not in a town.");
                return false;
            }

            Town town = resident.getTown();

            // Fetch and display the resident log here
            displayResidentLog(town, player);
            return true;
        }

        player.sendMessage(ChatColor.RED + "Invalid command usage.");
        return false;
    }

    private void displayResidentLog(Town town, Player player) {
        // Fetch resident logs from HistoryManager
        List<ResidentLogEntry> logs = HistoryManager.getLogEntriesForTown(town.getName());
        player.sendMessage(ChatColor.GREEN + "Resident Log for Town: " + town.getName());
        if (logs.isEmpty()) {
            player.sendMessage(ChatColor.YELLOW + "No resident log entries found.");
            return;
        }
        for (ResidentLogEntry entry : logs) {
            player.sendMessage(ChatColor.GRAY + entry.toString());
        }
    }
}
