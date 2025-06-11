package tuc.isse;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int choise = 0;
        System.out.println("Willkommen zu dem Spiel Viergewinn.\n"
                + "Drücken Sie 1 wenn Sie bereit sind, zu spielen!");
        while(choise!=1){
            choise = Integer.parseInt(JOptionPane.showInputDialog("Drücken Sie 1 wenn Sie bereit sind, zu spielen!"));
        }

        Bord bord = new Bord(); // Das Spielfeld erzeugen.
        System.out.println(bord);
        Winner winner = null;

        do {
            int cho = 7;
            do{
                cho = Integer.parseInt(JOptionPane.showInputDialog("Spieler Blau: Wählen sie die Spalte wo sie spilen möchten"));
                while(!bord.dropToken(Color.BLUE, cho)){
                    cho = Integer.parseInt(JOptionPane.showInputDialog("Wählen Sie eine andere Spalte, da diese schon voll ist."));
                }
                System.out.println(bord);
                // Spieler Rot
                cho = Integer.parseInt(JOptionPane.showInputDialog("Spieler Rot: Wählen sie die Spalte wo sie spilen möchten"));
                while(!bord.dropToken(Color.RED, cho)){
                    cho = Integer.parseInt(JOptionPane.showInputDialog("Wählen Sie eine andere Spalte, da diese schon voll ist."));
                }
                System.out.println(bord);

                 }while (cho<0 || cho>6);
            winner = bord.checkWinner();

        }while(winner == Winner.NONE );

        System.out.println("Der Winner ist " + winner);


    }
}
