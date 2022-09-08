package tournament;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> registered = new ArrayList<>();

    public void register(Player player) {
        registered.add(player);
    }

    public ArrayList<Player> findAll() {
        return registered;
    }

    public Player findByName(String name) {
        Player thisPlayer = null;
        for (Player player : registered) {
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