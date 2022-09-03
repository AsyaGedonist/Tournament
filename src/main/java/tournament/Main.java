package tournament;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        Player player1 = new Player(1, "Asya", 5);
        Player player2 = new Player(2, "Kostya", 8);
        Player player3 = new Player(3, "Anya", 7);
        Player player4 = new Player(4, "Billy", 3);


        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        System.out.println(game.findByName("Asya"));


    }
}
