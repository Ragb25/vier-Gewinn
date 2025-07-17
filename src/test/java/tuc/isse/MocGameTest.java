package tuc.isse;
import org.junit.jupiter.api.Test;
import tuc.isse.controller.ConsoleGame;
import tuc.isse.view.ColumnFullException;
import tuc.isse.view.IllegalMoveException;
import tuc.isse.view.ObservableBord;
import tuc.isse.model.*;
import tuc.isse.controller.MocPlayer;
import tuc.isse.view.MockBordObserver;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MocGameTest {

    @Test
    void Test() throws IllegalMoveException, ColumnFullException, IOException {
        Bord bord = new ObservableBord(); // Verwende ObservableBord statt Bord
        MockBordObserver mockObserver = new MockBordObserver();

        // Füge den Observer hinzu
        ((ObservableBord) bord).addObserver(mockObserver);

        MocPlayer mocplayer1 = new MocPlayer(Color.BLUE, bord, 1, 2, 0);
        MocPlayer mocPlayer2 = new MocPlayer(Color.RED, bord, 3, 5, 0);

        ConsoleGame consoleGame = new ConsoleGame(bord);
        consoleGame.doGame(mocplayer1, mocPlayer2);

        // Überprüfe, ob das Spiel gewonnen wurde
        assertEquals(bord.TestVictory(), Winner.BLUE);

        // Teste, ob der Observer benachrichtigt wurde
        assertTrue(mockObserver.isUpdateCalled(), "Observer wurde nicht benachrichtigt.");
    }
}
