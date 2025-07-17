package tuc.isse.controller;

import tuc.isse.view.ColumnFullException;
import tuc.isse.view.IllegalMoveException;
import tuc.isse.model.Bord;
import tuc.isse.model.Color;
import tuc.isse.model.Token;

import java.io.IOException;
/**
 * email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 */
public abstract class Player {
    private Color color;
    Bord bord;

    public Player(Color color, Bord bord){
        this.color = color;
        this.bord = bord;
    }

    protected void doDrop(int columnIndex) throws ColumnFullException, IllegalMoveException, IOException {
        Token token = bord.getToken(color);

        bord.dropToken(token, columnIndex);



    }

    public abstract void doTurn() throws ColumnFullException, IllegalMoveException, IOException;
}
