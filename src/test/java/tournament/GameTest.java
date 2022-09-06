package tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Asya", 5);
    Player player2 = new Player(2, "Kostya", 8);
    Player player3 = new Player(3, "Anya", 7);
    Player player4 = new Player(4, "Billy", 3);

    Player player5 = new Player(5, "Petya", 8);

    @BeforeEach
    public void setup() {
        game.register(player1, "Средний");
        game.register(player2, "Мастер");
        game.register(player3, "Средний");
        game.register(player4, "Новичок");
        game.register(player5, "Мастер");
    }

    @Test
    public void ShouldViewAll() {
        HashMap<Player, String > expected = new HashMap<Player, String >(){{
           put(player1, "Средний");
           put(player2, "Мастер");
           put(player3, "Средний");
           put(player4, "Новичок");
           put(player5, "Мастер");
        }};

        HashMap<Player, String> actual = game.findAll();
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
