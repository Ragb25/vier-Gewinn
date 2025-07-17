package tuc.isse.controller;

import tuc.isse.view.ColumnFullException;
import tuc.isse.view.IllegalMoveException;
import tuc.isse.model.Bord;
import tuc.isse.view.ObservableBord;

import java.io.IOException;
/**
 * email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 */
public abstract class Game {
    private Bord bord;

    public void setPlayerX(Player playerX) {
        this.playerX = playerX;
    }

    public void setPlayerO(Player playerO) {
        this.playerO = playerO;
    }

    private Player playerO;
    private Player playerX;
    private Player istDran;

    public Game(Bord bord){
        this.bord =  bord;
    }
    public void setIstDran(Player istDran) {
        this.istDran = istDran;
    }
    protected void swapPlayer(){

        if(istDran == playerO){
            istDran = playerX;
        } else istDran = playerO;
    }
    public Bord getBord() {
        return bord;
    }

    public void setBord(ObservableBord bord) {
        this.bord = bord;
    }
    public Player getIstDran() {
        return istDran;
    }





    public abstract void doGame(Player playerO, Player playerX) throws ColumnFullException, IllegalMoveException, IOException;

}
