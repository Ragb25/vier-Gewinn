package tuc.isse;

public class Main {
    public static void main(String [] args) {
        Bord bord = new Bord();

        try {

            bord.dropToken(Color.RED, 6);
            bord.dropToken(Color.RED, 6);
            bord.dropToken(Color.BLUE, 6);
            bord.dropToken(Color.RED, 6);
            bord.dropToken(Color.BLUE, 5);
            bord.dropToken(Color.BLUE, 5);
            bord.dropToken(Color.RED, 5);
            bord.dropToken(Color.BLUE, 4);
            bord.dropToken(Color.RED, 4);
            bord.dropToken(Color.RED, 4);
            bord.dropToken(Color.RED, 3);
            bord.dropToken(Color.BLUE, 2);
            bord.dropToken(Color.RED, 2);
            bord.dropToken(Color.BLUE, 2);
            bord.dropToken(Color.RED, 1);
            bord.dropToken(Color.BLUE, 0);
            bord.dropToken(Color.BLUE, 0);
            bord.dropToken(Color.BLUE, 6); // 7e jeton → déclenche l'exception
            System.out.println(bord);
        } catch (ColumnFullException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}
