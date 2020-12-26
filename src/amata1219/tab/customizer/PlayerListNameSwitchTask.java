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
        //プレイヤーと元のプレイヤーリストネームを結び付けて保持するためのマップ

        for (Player player : Bukkit.getOnlinePlayers()) {
            //全オンラインプレイヤーを一人ひとり処理していく
            playersToOriginalPlayerListNames.put(player, player.getPlayerListName());
            //元の名前をプレイヤーに結び付けて、マップに保持させておく

            player.setPlayerListName("NewName");
            //プレイヤーに新しいプレイヤリストネームを設定する
        }

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            //遅延処理をする
            for (Player player : Bukkit.getOnlinePlayers()) {
                //全オンラインプレイヤーを一人ひとり処理していく

                String originalPlayerListName = playersToOriginalPlayerListNames.get(player);
                //プレイヤーに結び付けておいた元の名前をマップから読み取る

                player.setPlayerListName(originalPlayerListName);
                //元の名前に再設定する
            }
        }, 20L);
        //20tick(1秒後)に実行するよう指定する
    }
}
