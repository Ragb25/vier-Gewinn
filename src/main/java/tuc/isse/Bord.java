package tuc.isse;

import javax.swing.*;


/**
 * email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 */

public class Bord extends GameObjekt{

    public Cell[][] getGameBord() {
        return gameBord;
    }

    public void setGameBord(Cell[][] gameBord) {
        this.gameBord = gameBord;
    }

    private Cell[][] gameBord  = new Cell[6][7]; // Das Spielfeld

    /*
    Getter und setter von gameBoard.
     */
    /*
    Jetzt füllen wir unser Spielfeld mit den Cell.
     */
    public Bord(){
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                Cell cell = new Cell();
                gameBord[i][j] = cell;
            }
        }

    }

    /*
    Die Methode canDrop. Die wird überprüfen, ob eine Cell bereits besetzt ist und den entsprechende Entscheidung treffen.
     */
    public boolean canDrop(int columnsIndex){
        if(columnsIndex<0 || columnsIndex>7){
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
                gameBord[i][columnsIndex].placetoken(new Token(color));
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
    /*
    Die Methode checkWinner prüft, ob eine Farbe das Spiel gewonnen hat.
    Vorgehen: Über jede einzelne Zeile iterieren und das Token der cell holen. Danach die Farbe(color)
    des Tokens speichern anschließen wird geprüft, ob diese Farbe horizontal, vertikal oder diagonal vier
    Mäle kommt.
     */

    public Winner checkWinner(){

        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                Token token = gameBord[i][j].getToken();
                if(token == null) continue;
                Color color = token.getColor();

                // Horizontal prüfen
                if(j<=3 && checkLine(color, i, j, 0, 1)){
                    return color == Color.RED ? Winner.RED : Winner.BLUE;
                }

                // Vertical Prüfen
                if(i<=2 && checkLine(color, i, j, 1, 0)){
                    return color == Color.RED? Winner.RED : Winner.BLUE;
                }

                // Diagonal recht prüfen.
                if(j<=2 && i<=3 && checkLine(color, i, j, 1, 1)){
                    return color == Color.BLUE? Winner.BLUE : Winner.RED;
                }

                // Diagonal links prüfen.
                if(i<=2 && j>=3 && checkLine(color, i, j, 1, -1)){
                    return color == Color.BLUE? Winner.BLUE : Winner.RED;
                }
            }



        }
        return Winner.NONE; // Kein Gewinner gefunden


    }
    /*
    Die Methode checkline prüft, ob eine bestimmte Farbe horizontal, vertikal oder diagonal vier Mäle kommt.
     */
    private boolean checkLine(Color color, int toCheckLine, int toCheckColumns,int toCheckDirection1, int toCheckDirection2 ){
        boolean checker = true;
        for(int i=0; i<4; i++){
            int compterLine = toCheckLine + toCheckDirection1*i;
            int compterColums = toCheckColumns + toCheckDirection2*i;
            if( gameBord[compterLine][compterColums].getToken()==null || color!=gameBord[compterLine][compterColums].getToken().getColor() ){
                checker = false;
                break;
            }
        }
        if(checker) return true;
        else return false;
    }

}
