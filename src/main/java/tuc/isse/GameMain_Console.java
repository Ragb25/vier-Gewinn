package tuc.isse;

import tuc.isse.controller.ConsoleGame;
import tuc.isse.controller.ConsolePlayer;
import tuc.isse.model.Bord;
import tuc.isse.model.Color;
import tuc.isse.view.ColumnFullException;
import tuc.isse.view.IllegalMoveException;

import java.io.IOException;
/**
 * email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 */
public class GameMain_Console {

    public static void main(String [] args) throws ColumnFullException, IllegalMoveException, IOException {

        Bord bord = new Bord();

        ConsolePlayer consolePlayer1 = new ConsolePlayer(Color.BLUE, bord);
        ConsolePlayer consolePlayer2 = new ConsolePlayer(Color.RED, bord);

        ConsoleGame consoleGame = new ConsoleGame(bord);
        consoleGame.doGame(consolePlayer1, consolePlayer2);

    }
}
