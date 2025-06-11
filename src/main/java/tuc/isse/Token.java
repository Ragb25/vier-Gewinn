package tuc.isse;

/**
* email:ragb25@tu-clausthal.de
* email: Ft81@tu-clausthal.de
*@autor1 Ramane Gbatkom Mouliom Abdel
*@author2 TIEGAM NJOYA FRANCK WILFRIED
*/

//class Token
public class Token extends GameObjekt {
    private Color color;

    //instance of class
    public Token(Color color) {
        this.color = color;
    }

    // nimmt die farbe
    public Color getColor() {

        return this.color;
    }



    /*return eine farbe des Tokens
     *X = RED, O = BLUE
     */
    @Override
    public String toString() {
        return (color == Color.RED) ? "X" : "O";
    }


}



