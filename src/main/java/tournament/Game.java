package tournament;

import java.util.ArrayList;

public class Game {
    public ArrayList<Player> registered = new ArrayList<>();

    public void register(Player player) {
        registered.add(player);
    }

    public ArrayList<Player> findAll() {
        return registered;
    }

    public Player findByName(String name) {
        Player thisPlayer = null;
        for (Player player : registered) {
            if (player.getName() == name) {
                thisPlayer = player;
            }
        }
        return thisPlayer;
    }

    public int round(String playerName1, String playerName2) {
        int index1 = 0;
        int index2 = 0;
        Player firstPlayer = null;
        Player secondPlayer = null;

        for (Player player : registered) {
            if (player.getName() == playerName1) {
                index1++;
                firstPlayer = player;
            }
        }
        if (index1 == 0) {
            throw new NotRegisteredException("Player " + playerName1 + " not found");
        } else {
            for (Player player : registered) {
                if (player.getName() == playerName2) {
                    index2++;
                    secondPlayer = player;
                }
            }
            if (index2 == 0) {
                throw new NotRegisteredException("Player " + playerName2 + " not found");
            } else {
                int whoWin = firstPlayer.compareTo(secondPlayer);
                return whoWin;
            }
        }
    }
}