package amata1219.tab.customizer;

import java.util.HashMap;
import java.util.UUID;

public class PlayerAchieveRepository {

    private final HashMap<UUID, String> playersUniqueIdsToAchieves;

    public PlayerAchieveRepository(HashMap<UUID, String> playerUniqueIdsToAchieves) {
        this.playersUniqueIdsToAchieves = playerUniqueIdsToAchieves;
    }

    //プレイヤーの称号を取得する(get)
    public String achieve(UUID playerUniqueId) {
        return playersUniqueIdsToAchieves.get(playerUniqueId);
    }

    //プレイヤーのUUIDに称号を紐づける(put)
    public void setAchieve(UUID playerUniqueId, String achieve) {
        playersUniqueIdsToAchieves.put(playerUniqueId, achieve);
    }

    //プレイヤーの称号を削除する(remove)
    public void removeAchieve(UUID playerUniqueId) {
        playersUniqueIdsToAchieves.remove(playerUniqueId);
    }


}
