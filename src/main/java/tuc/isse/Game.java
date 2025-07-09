package tuc.isse;

import java.io.IOException;

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
        this.bord = bord;
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

    public void setBord(Bord bord) {
        this.bord = bord;
    }
    public Player getIstDran() {
        return istDran;
    }





    public abstract void doGame(Player playerO, Player playerX) throws ColumnFullException, IllegalMoveException, IOException;

}
