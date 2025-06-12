package tuc.isse;

/**
 * email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 */
//class Cell
public class Cell extends GameObjekt {
    private Token token;

    //instance of class
    public Cell(){
        this.token = null;

    }


    // nimmt die privatte attribut Token
    public Token getToken() {
        return token;
    }



    // diese methode erlaubt es ein Token in einer zelle zu legen, wenn es leer ist
    public Token placetoken(Token t){
        if (this.token == null){
            this.token = t;
            return this.token;
        }return null;
    }


    //diese methode prüft, ob eine zelle leer ist
    public boolean isleer(){

        return this.token == null;
    }


    /*gibt eine darstellung der zelle
    * "()" für leer
    * "(x)" oder "(O)" für den Token
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
