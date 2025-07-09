package tuc.isse;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 */

public class Bord extends GameObjekt {

    private List<List<Cell>> gameBord = new ArrayList<>(); // Das Spielfeld
    private Map<String, List<Token>> redLager = new HashMap<>(); // Lager für Token mit Farbe Rot
    private Map<String, List<Token>> blueLager = new HashMap<>(); // Lager für Token mit Farbe Blau

    /*
    Getter und setter von gameBoard.
     */
    /*
    Jetzt füllen wir unser Spielfeld mit den Cell.
     */
    public Bord() {

        blueLager.put("BLUE", new ArrayList<>());
        redLager.put("RED", new ArrayList<>());

        /*
        Hier werden wir unsere Lager mit entsprechenden Token füllen.
        Der Schlüssel ist einfach ein String.
         */
        for(int i=1; i<22; i++){
            blueLager.get("BLUE").add(new Token(Color.BLUE));
            redLager.get("RED").add(new Token(Color.RED));
        }

        /*
        Hier füllen wir unser GameBord. Unser Gamebord besteht aus eine Liste von 6 Line.
        Wir füllen zuerst eine Liste mit 7 Token, danach fügen wir diese Liste zu Gamebord.
         */
        for (int i = 0; i < 6; i++) {
            List<Cell> line = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                Cell cell = new Cell();
                line.add(cell);
            }

            gameBord.add(line);
        }

    }


    /*
    Die Methode canDrop. Die wird überprüfen, ob eine Cell bereits besetzt ist und den entsprechende Entscheidung treffen.
     */
    private boolean canDrop(int columnsIndex) {
        if (columnsIndex < 0 || columnsIndex > 7) {
            return false;
        } else return gameBord.get(0).get(columnsIndex).isleer();
    }

    /*
    Die Methode droToken wirft eine Exception, wenn die spalte voll ist
    Und wirft eine IllegalMoveException ob eine Farbe bereits gewonnen hat.
     */
    public void dropToken(Token token, int columnsIndex) throws ColumnFullException, IllegalMoveException {

        if (!canDrop(columnsIndex)) {
            throw new ColumnFullException("column" + columnsIndex +"ist full.");
        }
        try {
            if (TestVictory()!=Winner.NONE) throw new IllegalMoveException("Jemand hat bereits gewonnen");
        } catch (IllegalMoveException e){
            System.out.println("Jemand hat bereits gewonnen");
        }

        for (int i = 5; i >= 0; i--) {
            if (gameBord.get(i).get(columnsIndex).isleer()) {
                gameBord.get(i).get(columnsIndex).placetoken(token);
                return ;
            }
        }

    }
    /*
    Hier gehen wir in einem Lager mit der Farbe color und nehmen wir ein Token raus.
    Danach entfernen wir ein Token in diesem Lager.
     */
    public Token getToken (Color color){
        if(color == Color.RED){
            if(hasToken(Color.RED)){
                Token getToken = redLager.get("RED").get(0);
                redLager.get("RED").remove(0);
                return getToken;
            }

        }else if(color==Color.BLUE){
            if(hasToken(Color.BLUE)) {
                Token getToken = blueLager.get("BLUE").get(0);
                blueLager.get("BLUE").remove(0);
                return getToken;
            }
        }
        return null;
    }
    /*
    Hier prüfen wir einfach, ob Lager noch Werte enthalten (Falls sie Token haben oder nicht)
     */
    public boolean hasToken(Color color){
        if(color==Color.RED){
            boolean red = !redLager.get("RED").isEmpty();
            return red;
        } else if(color==Color.BLUE){
            boolean blue = !blueLager.get("BLUE").isEmpty();
            return blue;
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
                sb.append(gameBord.get(r).get(c).toString());
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
                Token token = gameBord.get(i).get(j).getToken();
                if (token == null) continue; // leere token enthalten keine Farbe
                Color colorToCheck = token.getColor();

                if (color == colorToCheck && j <= 3 && toCheckRow(colorToCheck, i, j)) { // wenn j großer als 3 ist, werden wird die Länge von gameBord überschreiten.
                    return true;
                }

            }
        }
        return false;
    }

    /*
    Die Methode toCheckRow überprüft, ob eine bestimmte Farbe die Siegbedingung erfüllt.
     */
    private boolean toCheckRow(Color color,int toCheckLine,int toCheckColumn) {
        int istRow = 1; // Zählt wie oft die Farbe in Zickzak vorkommt
        int colomnRechner = toCheckColumn;
        int lineRechner = toCheckLine;

        if (lineRechner<5){ // ist lineRechner schon gleich 5, könnten wir nicht mehr von unten prüfen.
            for(int i=1; i<4; i++){

                if(lineRechner==toCheckLine){ // Sorgt dafür, dass wir immer die Zeile wechseln.
                    lineRechner += 1;
                } else { lineRechner -= 1;}

                colomnRechner += 1;
                if( gameBord.get(lineRechner).get(colomnRechner).getToken()== null) break; // Falls das token leer ist, sind wir fertig
                if(gameBord.get(lineRechner).get(colomnRechner).getToken().getColor()==null || color!=gameBord.get(lineRechner).get(colomnRechner).getToken().getColor()){
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
                if( gameBord.get(lineRechner).get(colomnRechner).getToken()== null) break;
                if(gameBord.get(lineRechner).get(colomnRechner).getToken().getColor()==null || color!=gameBord.get(lineRechner).get(colomnRechner).getToken().getColor()) break;

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
                Token token = gameBord.get(i).get(j).getToken();
                if (token == null) continue; // leere token enthalten keine Farbe
                Color colorToCheck = token.getColor();

                if (color == colorToCheck && i <= 2 && toCheckColumn(colorToCheck, i, j)) {
                    return true;
                }

            }
        }
        return false;

    }

    // Das gleiche Verfahren wie bei toCheckLine
    private boolean toCheckColumn(Color color,int toCheckLine,int toCheckColumn){
        int istRow = 1;
        int colomnRechner = toCheckColumn;
        int lineRechner = toCheckLine;
        if(toCheckColumn<6){
            for(int i=1; i<4; i++){
                if(colomnRechner==toCheckColumn){
                    colomnRechner += 1;
                } else { colomnRechner -= 1;}

                lineRechner += 1;
                if( gameBord.get(lineRechner).get(colomnRechner).getToken()== null) break;
                if(gameBord.get(lineRechner).get(colomnRechner).getToken().getColor()==null || color!=gameBord.get(lineRechner).get(colomnRechner).getToken().getColor()) break;

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
                if( gameBord.get(lineRechner).get(colomnRechner).getToken()== null) continue;
                if(gameBord.get(lineRechner).get(colomnRechner).getToken().getColor()==null || color!=gameBord.get(lineRechner).get(colomnRechner).getToken().getColor()) break;

                else istRow += 1;
            }
        }

        if(istRow==4) return true;

        return false;

    }

    private boolean isTie(){

        return blueLager.get("BLUE").isEmpty()  || redLager.get("RED").isEmpty();

    }

    // Hier ist die Methode, die unserer isRowVictory und isColumnVictory aufruft.
    public Winner TestVictory(){
        if(isRowVictory(Color.RED) || isColumnVictory(Color.RED)){
            return Winner.RED;     // Wenn die Farbe RED eine der Siegbedingungen erfüllt.
        } else if(isRowVictory(Color.BLUE) || isColumnVictory(Color.BLUE)){
            return Winner.BLUE;
        } else if(isTie()) return Winner.TIE;

        return Winner.NONE;
    }
}