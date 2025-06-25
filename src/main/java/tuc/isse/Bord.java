package tuc.isse;

import javax.swing.*;


/**
 * email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 */

public class Bord extends GameObjekt {

    public Cell[][] getGameBord() {
        return gameBord;
    }

    public void setGameBord(Cell[][] gameBord) {
        this.gameBord = gameBord;
    }

    private Cell[][] gameBord = new Cell[6][7]; // Das Spielfeld

    /*
    Getter und setter von gameBoard.
     */
    /*
    Jetzt füllen wir unser Spielfeld mit den Cell.
     */
    public Bord() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Cell cell = new Cell();
                gameBord[i][j] = cell;
            }
        }

    }

    /*
    Die Methode canDrop. Die wird überprüfen, ob eine Cell bereits besetzt ist und den entsprechende Entscheidung treffen.
     */
    public boolean canDrop(int columnsIndex) {
        if (columnsIndex < 0 || columnsIndex > 7) {
            return false;
        } else return gameBord[0][columnsIndex].isleer();
    }

    /*
    Die Methode dropToken prüft zuerst, ob eine Spalte besetzt werden kann. Wenn möglich stellt sie ein Token in der unterste cell
     */
    public boolean dropToken(Color color, int columnsIndex) {
        if (!canDrop(columnsIndex)) {
            return false;
        }
        for (int i = 5; i >= 0; i--) {
            if (gameBord[i][columnsIndex].isleer()) {
                gameBord[i][columnsIndex].placetoken(new Token(color));
                return true;
            }
        }
        return false;
    }

    /*
    Die Methode toString gibt einfach das ganze Spielfeld als String zurück
     */

    public String toString() {
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
    des Tokens speichern anschließen wird geprüft, ob die Siegbedingung erfüllt(in Zeile)
    Mäle kommt.
     */

    private boolean isRowVictory(Color color) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Token token = gameBord[i][j].getToken();
                if (token == null) continue; // leere token enthalten keine Farbe
                Color colorToCheck = token.getColor();

                if (color == colorToCheck && j <= 3 && toCheckRow(colorToCheck, i, j, 1)) { // wenn j großer als 3 ist, werden wird die Länge von gameBord überschreiten.
                    return true;
                }

            }
        }
        return false;
    }

    /*
    Die Methode toCheckRow überprüft, ob eine bestimmte Farbe die Siegbedingung erfüllt.
     */
    private boolean toCheckRow(Color color,int toCheckLine,int toCheckColumn, int lineRechner) {
        int istRow = 1; // Zählt wie oft die Farbe in Zickzak vorkommt
        int colomnRechner = toCheckColumn;
        lineRechner = toCheckLine;

        if (lineRechner<5){ // ist lineRechner schon gleich 5, könnten wir nicht mehr von unten prüfen.
            for(int i=1; i<4; i++){

                if(lineRechner==toCheckLine){ // Sorgt dafür, dass wir immer die Zeile wechseln.
                    lineRechner += 1;
                } else { lineRechner -= 1;}

                colomnRechner += 1;
                if( gameBord[lineRechner][colomnRechner].getToken()== null) break; // Falls das token leer ist, sind wir fertig
                if(gameBord[lineRechner][colomnRechner].getToken().getColor()==null || color!=gameBord[lineRechner][colomnRechner].getToken().getColor()){
                    break;
                }

                else istRow += 1; // Nur wenn die betrachtete Farbe noch mal in der richtigen Position vorkommt.

            }

        }

         if(istRow==4) return true; // Die Farbe hat das Spiel gewonnen.

        // Hier wiederholen wir das Gleiche aber für die Zeile oben.
        istRow = 1;
        colomnRechner = toCheckColumn;
        lineRechner = toCheckLine;
        if (toCheckLine>0){
            for(int i=1; i<4; i++){
                if(lineRechner==toCheckLine){
                    lineRechner -= 1;
                } else { lineRechner += 1;}

                colomnRechner += 1;
                if( gameBord[lineRechner][colomnRechner].getToken()== null) break;
                if(gameBord[lineRechner][colomnRechner].getToken().getColor()==null || color!=gameBord[lineRechner][colomnRechner].getToken().getColor()) break;

                else istRow += 1;
            }
        }
        if(istRow==4) return true;

        return false;
    }
    /*
    Die Methode checkWinner prüft, ob eine Farbe das Spiel gewonnen hat.
    Vorgehen: Über jede einzelne Zeile iterieren und das Token der cell holen. Danach die Farbe(color)
    des Tokens speichern anschließen wird geprüft, ob die Siegbedingung erfüllt(in Spalte)
    Mäle kommt.
     */
    private boolean isColumnVictory (Color color){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Token token = gameBord[i][j].getToken();
                if (token == null) continue; // leere token enthalten keine Farbe
                Color colorToCheck = token.getColor();

                if (color == colorToCheck && i <= 2 && toCheckColumn(colorToCheck, i, j, 1)) {
                    return true;
                }

            }
        }
        return false;

    }

    // Das gleiche Verfahren wie bei toCheckLine
    private boolean toCheckColumn(Color color,int toCheckLine,int toCheckColumn, int colomnRechner){
        int istRow = 1;
        colomnRechner = toCheckColumn;
        int lineRechner = toCheckLine;
        if(toCheckColumn<6){
            for(int i=1; i<4; i++){
                if(colomnRechner==toCheckColumn){
                    colomnRechner += 1;
                } else { colomnRechner -= 1;}

                lineRechner += 1;
                if( gameBord[lineRechner][colomnRechner].getToken()== null) continue;
                if(gameBord[lineRechner][colomnRechner].getToken().getColor()==null || color!=gameBord[lineRechner][colomnRechner].getToken().getColor()) break;

                else istRow += 1;
            }
        }

        if(istRow==4) return true;

        istRow = 1;
        colomnRechner = toCheckColumn;
        lineRechner = toCheckLine;
        if(toCheckColumn>0){
            for(int i=1; i<4; i++){
                if(colomnRechner==toCheckColumn){
                    colomnRechner -= 1;
                } else { colomnRechner += 1;}

                lineRechner += 1;
                if( gameBord[lineRechner][colomnRechner].getToken()== null) continue;
                if(gameBord[lineRechner][colomnRechner].getToken().getColor()==null || color!=gameBord[lineRechner][colomnRechner].getToken().getColor()) break;

                else istRow += 1;
            }
        }

        if(istRow==4) return true;

        return false;

    }
    // Hier ist die Methode, die unserer isRowVictory und isColumnVictory aufruft.
    public Winner TestVictory(){
        if(isRowVictory(Color.RED) || isColumnVictory(Color.RED)){
            return Winner.RED;     // Wenn die Farbe RED eine der Siegbedingungen erfüllt.
        } else if(isRowVictory(Color.BLUE) || isColumnVictory(Color.BLUE)){
            return Winner.BLUE;
        }


        return Winner.NONE;
    }
}