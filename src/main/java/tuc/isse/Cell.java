package tuc.isse;

public class Cell extends Game0bjekt {
    private Token token;

    public Cell(){
        this.token = null;

    }

    public Token getToken() {
        return token;
    }

    public boolean placetoken(Token t){
        if (this.token == null){
            this.token = t;
            return true;
        }
        return false;
    }

    public boolean isleer(){
        return this.token == null;
    }






    @Override
    public String toString() {
        if (token == null){
            return "()";
        }  else{
            return "(" + token.toString() +")";
        }

    }
}
