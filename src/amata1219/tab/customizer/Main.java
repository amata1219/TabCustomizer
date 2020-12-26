package amata1219.tab.customizer;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class Main extends JavaPlugin {

    private static Main instance;
    private BukkitTask playerListNameSwitchTask;
    //実行したタスクを保持するためのフィールド

    @Override
    public void onEnable() {
        //サーバー開始時に実行される処理

        instance = this;

        playerListNameSwitchTask = Bukkit.getScheduler().runTaskTimerAsynchronously(this, new PlayerListNameSwitchTask(this), 40L, 40L);
        //PlayerListNameSwitchTask#run()を、40tick(2秒)後から、40tick(2秒)間隔で非同期に実行する
        //タスクはplayerListNameSwitchTaskで保持
    }

    @Override
    public void onDisable() {
        //サーバー終了時に実行される処理

        playerListNameSwitchTask.cancel();
        //保持しておいたタスクをキャンセル
    }

    public static Main instance() {
        return instance;
    }

}
