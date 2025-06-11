package tuc.isse;

public class Cell extends GameObjekt {
    private Token token;

    public Cell(){
        this.token = null;

    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Token placetoken(Token t){
        if (this.token == null){
            this.token = t;
            return this.token;
        }
        return null;
    }

    public boolean isleer(){

        return this.token == null;
    }



    @Override
    public String toString() {
        if (token == null){
            return "( )";
        }  else{
            return "(" + token.toString() +")";
        }

    }
}
