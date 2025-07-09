package tuc.isse;

import java.io.IOException;

public class GameMain_Console {

    public static void main(String [] args) throws ColumnFullException, IllegalMoveException, IOException {

        Bord bord = new Bord();

        ConsolePlayer consolePlayer1 = new ConsolePlayer(Color.BLUE, bord);
        ConsolePlayer consolePlayer2 = new ConsolePlayer(Color.RED, bord);

        ConsoleGame consoleGame = new ConsoleGame(bord);
        consoleGame.doGame(consolePlayer1, consolePlayer2);

    }
}
