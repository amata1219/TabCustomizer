package amata1219.tab.customizer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.UUID;

public class AchieveCommand implements CommandExecutor {

    private final PlayerAchieveRepository playerAchieveRepository;

    public AchieveCommand(PlayerAchieveRepository playerAchieveRepository) {
        this.playerAchieveRepository = playerAchieveRepository;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            warnSenderAboutMissingArguments(sender);
            return true;
        }

        switch (args[0]) {
            case "set": {
                if (args.length <= 2) {
                    warnSenderAboutMissingArguments(sender);
                    return true;
                }

                UUID specifiedPlayerUniqueId = playerUniqueId(args[0]);
                if (specifiedPlayerUniqueId == null) {
                    warnSenderAboutMissingSpecifiedPlayer(sender);
                    return true;
                }


                String newAchieve = args[1];

                playerAchieveRepository.setAchieve(specifiedPlayerUniqueId, newAchieve);
                break;
            }
            case "remove": {
                if (args.length <= 1) {
                    warnSenderAboutMissingSpecifiedPlayer(sender);
                    return true;
                }

                UUID specifiedPlayerUniqueId = playerUniqueId(args[1]);
                if (specifiedPlayerUniqueId == null) {
                    warnSenderAboutMissingSpecifiedPlayer(sender);
                    return true;
                }

                playerAchieveRepository.removeAchieve(specifiedPlayerUniqueId);
                break;
            }
            default: {
                sender.sendMessage(ChatColor.RED + "指定された引数が正しくありません。");
                break;
            }
        }

        return true;
    }

    private static UUID playerUniqueId(String playerName) {
        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(playerName);
        return offlinePlayer.hasPlayedBefore() ? offlinePlayer.getUniqueId() : null;
    }

    private static void warnSenderAboutMissingArguments(CommandSender sender) {
        sender.sendMessage(ChatColor.RED + "引数が不足しています。");
    }

    private static void warnSenderAboutMissingSpecifiedPlayer(CommandSender sender) {
        sender.sendMessage(ChatColor.RED + "指定されたプレイヤーは存在しません。");
    }

}
