package amata1219.tab.customizer;

import java.util.HashMap;
import java.util.UUID;

public class PlayerAchieveRepository {

    private final HashMap<UUID, String> playerUniqueIdsToAchieves;

    public PlayerAchieveRepository(HashMap<UUID, String> playerUniqueIdsToAchieves) {
        this.playerUniqueIdsToAchieves = playerUniqueIdsToAchieves;
    }

}
