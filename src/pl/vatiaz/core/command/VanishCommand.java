package pl.vatiaz.core.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;

public class VanishCommand implements CommandExecutor {

    private HashSet<Player> vanishedPlayers = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "Ta komenda jest tylko dla graczy!"));
            return true;
        }

        Player player = (Player) sender;
        if (player.isOp() || player.hasPermission("cmd.vanish")) {
            if (vanishedPlayers.contains(player)) {
                for (Player p : sender.getServer().getOnlinePlayers()) {
                    p.showPlayer(player);
                }
                vanishedPlayers.remove(player);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eJesteś teraz widoczny."));
            } else {
                for (Player p : sender.getServer().getOnlinePlayers()) {
                    p.hidePlayer(player);
                }
                vanishedPlayers.add(player);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cJesteś teraz niewidoczny."));
            }
            return true;
        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cNie masz uprawnien &7(cmd.teleport)"));
            return true;
        }
    }
}
