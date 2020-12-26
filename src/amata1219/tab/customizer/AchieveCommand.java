package amata1219.tab.customizer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AchieveCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        /*
            label → "achieve", "ACHIEVE", "acHiEVe" など 大文字小文字は問わず入ってくるが、
                    全て小文字にした時、確実に"achieve"になることはBukkit(サーバーソフトウェアの名前)により
                    保証されている
            args → コマンドの引数、何が入ってるかはこの時点では不明
         */

        if (args.length == 0) {
            //引数が一つも無い時、つまり、`/achieve` とだけ入力された時

            //引数が不足している旨のエラーメッセージを表示する
            //多くのプラグインはここでコマンド一覧を表示することが多い

            return true;
            //返り値がboolean型だからtrue/falseを指定する必要があるが、全てtrueで問題無い
        }

        switch (args[0]) {
            case "set": {
                //args[0] が "set" の場合

                if (args.length <= 2) {
                    // `/achieve set` か `/achieve set [player-name]` までしか入力していない場合
                    //称号まで絶対に入力してもらう必要があるので、引数が不足していれば弾く

                    return true;
                }

                OfflinePlayer player = Bukkit.getOfflinePlayer(args[1]);
                //指定されたプレイヤー名でプレイヤーを取得してみる
                //オンラインかどうかは分からないので、in状態問わず取得出来る`getOfflinePlayer()`を使う(クラスとほぼ同義)

                if (!player.hasPlayedBefore()) {
                    //OfflinePlayer#hasPlayedBefore()はプレイヤーが一度でもサーバーに参加した事があるかどうかをbool値で返す
                    //つまり、サーバーに参加したことのないプレイヤーでも`getOfflinePlayer()`でnullが返ってくるわけではない

                    return true;
                }

                String achieve = args[1];
                //称号を取得

                //↑このプレイヤー取得の処理はremoveでも使うのでメソッド化しておくと良い感じ

                // ---ここに称号を設定する処理--- //

                break;
                //Javaのswitch文はフォールスルーなのでcase毎にbreakしてswitch文を脱出しないといけない
            }
            case "remove": {
                //args[0] が "remove" の場合

                // ---ここに称号を削除する処理--- //

                break;
            }
            default: {
                //args[0]がsetでもremoveでもなかった場合
                break;
            }
        }

        return true;
    }

}
