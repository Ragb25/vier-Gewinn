package tuc.isse;

import javax.swing.*;
import java.io.IOException;

public class ConsoleGame extends Game{

    public ConsoleGame(Bord bord) {
        super(bord);
    }

    @Override
    public void doGame(Player playerO, Player playerX) throws ColumnFullException, IllegalMoveException, IOException {
        Bord bord = super.getBord();

        Player istDran = playerO;
        super.setPlayerO(playerO);
        super.setPlayerO(playerX);
        while(bord.TestVictory()==Winner.NONE){
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
