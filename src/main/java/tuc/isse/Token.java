package tuc.isse;

public class Token extends GameObjekt {
    private Color color;


    public Token(Color color) {
        this.color = color;
    }


    public Color getColor() {

        return this.color;
    }

    @Override
    public String toString() {
        return (color == Color.RED) ? "X" : "O";
    }


}



