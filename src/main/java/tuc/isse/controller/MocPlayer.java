package tuc.isse.controller;

import tuc.isse.view.ColumnFullException;
import tuc.isse.view.IllegalMoveException;
import tuc.isse.model.Bord;
import tuc.isse.model.Color;

import java.io.IOException;
/**
 * email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 */
public class MocPlayer extends Player {
    private int moveFirstColumn;
    private int moveSecondColumn;
    private int round;
    private Color color;
    private Bord bord;

    public MocPlayer(Color color, Bord bord, int moveFirstColumn, int moveSecondColumn, int round) {
        super(color, bord);
        this.moveFirstColumn = moveFirstColumn;
        this.moveSecondColumn = moveSecondColumn;
        this.round = round;
        this.bord = bord;
        this.color = color;

    }

    @Override
    public void doTurn() throws ColumnFullException, IllegalMoveException, IOException {


        if(round%2 == 0){
            super.doDrop(moveFirstColumn);
        } else super.doDrop(moveSecondColumn);

        round += 1;

    }
}
