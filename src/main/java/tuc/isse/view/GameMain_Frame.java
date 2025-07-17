package tuc.isse.view;



import tuc.isse.controller.FrameGame;
import tuc.isse.controller.FramePlayer;
import tuc.isse.controller.Player;
import tuc.isse.model.Color;
/**
 * email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 */
public class GameMain_Frame {

    public static void main(String[] args) {
        // Erstelle das Spielfeld und die Benutzeroberfläche
        ObservableBord bord = new ObservableBord();  // Utilise ObservableBord ici, pas Bord

        VierGewinntFrame frame = new VierGewinntFrame(bord);

        // Erstelle die Spieler
        Player player1 = new FramePlayer(Color.RED, bord, frame);  // Spieler 1 (rot)
        Player player2 = new FramePlayer(Color.BLUE, bord, frame); // Spieler 2 (blau)

        // Erstelle das Spielobjekt (FrameGame) und starte das Spiel
        FrameGame game = new FrameGame( bord, frame);
        try {
            // Starte das Spiel mit den beiden Spielern
            game.doGame(player1, player2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
