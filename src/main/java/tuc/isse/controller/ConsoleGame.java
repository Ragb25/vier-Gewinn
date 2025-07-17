package tuc.isse.controller;

import tuc.isse.model.*;
import tuc.isse.view.ColumnFullException;
import tuc.isse.view.IllegalMoveException;
import tuc.isse.view.ObservableBord;

import java.io.IOException;
/**
 * email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 */
public class ConsoleGame extends Game {

    public ConsoleGame(Bord bord) {
        super((ObservableBord) bord);
    }

    @Override
    public void doGame(Player playerO, Player playerX) throws ColumnFullException, IllegalMoveException, IOException {
        Bord bord = super.getBord();

        Player istDran = playerO;
        super.setPlayerO(playerO);
        super.setPlayerO(playerX);
        while(bord.TestVictory()== Winner.NONE){
            System.out.println(bord);


            super.setIstDran(istDran);
            System.out.println("Spieler 0, was ist dein nächster Zug?");
            super.getIstDran().doTurn();
            System.out.println(bord);

            System.out.println("Spieler X, was ist dein nächster Zug?");
            super.swapPlayer();
            super.getIstDran().doTurn();
            System.out.println(bord);

        }
        System.out.println("Der Winner ist " + bord.TestVictory());


    }
}
