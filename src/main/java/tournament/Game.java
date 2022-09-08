package tournament;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private HashMap<Player, String> registered = new HashMap<>();

    public void register(Player player, String level) {
        registered.put(player, level);
    }

    public HashMap<Player, String> findAll() {
        return registered;
    }

    public Player findByName(String name) {
        Player thisPlayer = null;
        for (Player player : registered.keySet()) {
            if (player.getName().equals(name)) {
                thisPlayer = player;
            }
        }
        if (thisPlayer == null) {
            throw new NotRegisteredException("Player " + name + " not found");
        } else {
            return thisPlayer;
        }
    }

    public int round(String playerName1, String playerName2) {

        Player firstPlayer = findByName(playerName1);
        Player secondPlayer = findByName(playerName2);

        int whoWin = firstPlayer.compareTo(secondPlayer);
        return whoWin;
    }
}