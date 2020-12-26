package amata1219.tab.customizer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class PlayerListNameSwitchTask implements Runnable {

    private final JavaPlugin plugin;

    public PlayerListNameSwitchTask(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        HashMap<Player, String> playersToOriginalPlayerListNames = new HashMap<>();

        for (Player player : Bukkit.getOnlinePlayers()) {
            playersToOriginalPlayerListNames.put(player, player.getPlayerListName());
            player.setPlayerListName("NewName");
        }

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                String originalPlayerListName = playersToOriginalPlayerListNames.get(player);
                if (originalPlayerListName != null) {
                    player.setPlayerListName(originalPlayerListName);
                }
            }
        }, 20L);
    }
}
