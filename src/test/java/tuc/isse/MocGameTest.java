package tuc.isse;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MocGameTest {

    @Test
    void Test() throws IllegalMoveException, ColumnFullException, IOException {
        Bord bord = new Bord();
        MocPlayer mocplayer1 = new MocPlayer(Color.BLUE, bord, 1, 2, 0);
        MocPlayer mocPlayer2 = new MocPlayer(Color.RED, bord, 3, 5, 0);

        ConsoleGame consoleGame = new ConsoleGame(bord);
        consoleGame.doGame(mocplayer1, mocPlayer2);

        assertEquals(bord.TestVictory(), Winner.BLUE);
    }
}
