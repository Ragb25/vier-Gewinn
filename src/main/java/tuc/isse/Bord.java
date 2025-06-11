package tuc.isse;

import javax.swing.*;

public class Bord extends GameObjekt{

    private Cell[][] gameBord  = new Cell[6][7]; // Das Spielfeld
    private Token token;

    public Bord(Cell [][] gameBord, Token token){
        this.gameBord = gameBord;
        this.token = token;
    }
    /*
    Jetzt füllen wier unser Spielfeld mit den Cell.
     */
    public Bord(String [] GameBord){
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                Cell cell = new Cell();
                gameBord[i][j] = cell;
            }
        }

    }

    /*
    Getter und setter für das gamebord
     */
    public Cell[][] getGameBord() {
        return gameBord;
    }

    public void setGameBord(Cell[][] gameBord) {
        this.gameBord = gameBord;
    }
    /*
    Die Methode canDrop. Die wird überprüfen, ob eine Cell bereits besetzt ist und den entsprechende Entscheidung treffen.
     */
    public boolean canDrop(int columnsIndex){
        if(columnsIndex<=0 || columnsIndex>7){
            return false;
        } else return gameBord[0][columnsIndex].isleer();
    }

    /*
    Die Methode dropToken prüft zuerst, ob eine Spalte besetzt werden kann. Wenn möglich stellt sie ein Token in der unterste cell
     */
    public boolean dropToken(Color color, int columnsIndex){
        if (!canDrop(columnsIndex)){
            return false;
        }
        for(int i=5; i>=0; i--){
            if(gameBord[i][columnsIndex].isleer()){
                gameBord[i][columnsIndex].setToken(new Token(color));
                return true;
            }
        }
        return false;
    }

    /*
    Die Methode toString gibt einfach das ganze Spielfeld als String zurück
     */

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 7; c++) {
                sb.append(gameBord[r][c].toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
