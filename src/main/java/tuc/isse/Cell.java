package tuc.isse;

/**
 *email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 *
 *
 */

// class Cell
public class Cell extends GameObjekt {
    private Token token;

    //instance of class
    public Cell(){
        this.token = null;

    }


    //nimmt der Token
    public Token getToken() {
        return token;
    }



   //die methode placetoken erlaubt es, einmalig ein Token zu legen, wenn die zelle leer ist
    public boolean placetoken(Token t){
        if (this.token == null){
            this.token = t;
            return true;
        }
        return false;
    }


    // die methode überpruft, ob eine zelle leer ist
    public boolean isleer(){

        return this.token == null;
    }


    /*diese methode hier gibt eine darstellung der zelle
     * "( )" leer
     * "(x)" token RED
     * "(O)"token BLUE
     */
    @Override
    public String toString() {
        if (token == null){
            return "( )";
        }  else{
            return "(" + token.toString() +")";
        }

    }
}
