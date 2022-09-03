package tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Asya", 5);
    Player player2 = new Player(2, "Kostya", 8);
    Player player3 = new Player(3, "Anya", 7);
    Player player4 = new Player(4, "Billy", 3);

    Player player5 = new Player(5, "Petya", 8);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
    }

    @Test
    public void ShouldViewAll() {
        ArrayList<Player> expected = new ArrayList<>(Arrays.asList(player1, player2, player3, player4, player5));
        ArrayList<Player> actual = game.findAll();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ShouldViewByFindName() {
        Player expected = player1;
        Player actual = game.findByName("Asya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void FirstWin() {
        int expected = 1;
        int actual = game.round("Asya", "Billy");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SecondWin() {
        int expected = 2;
        int actual = game.round("Asya", "Kostya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NoWin() {

        int expected = 0;
        int actual = game.round("Petya", "Kostya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NoFirstPlayer() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Vasya", "Asya");
        });
    }

    @Test
    public void NoSecondPlayer() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Asya", "Vasya");
        });
    }

}
