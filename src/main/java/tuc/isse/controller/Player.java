package tuc.isse.controller;

import tuc.isse.model.ColumnFullException;
import tuc.isse.model.IllegalMoveException;
import tuc.isse.model.Bord;
import tuc.isse.model.Color;
import tuc.isse.model.Token;

import java.io.IOException;

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
