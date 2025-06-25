package tuc.isse;

public class Main {
    public static void main(String [] args){
        Bord bord = new Bord();

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
        System.out.println(bord);

        bord.TestVictory();
        System.out.println(bord.TestVictory());
    }
}
