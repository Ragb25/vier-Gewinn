package tuc.isse.controller;



import tuc.isse.model.*;
import tuc.isse.model.VierGewinntFrame;

import java.io.IOException;

import tuc.isse.model.ColumnFullException;
import tuc.isse.model.IllegalMoveException;
import tuc.isse.model.Winner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrameGame extends Game implements BordObserver, ActionListener {

    private VierGewinntFrame frame;  // Referenz auf die Benutzeroberfläche
    private ObservableBord bord;

    public FrameGame(ObservableBord bord, VierGewinntFrame frame) {
        super( bord);
        this.frame = frame;
        this.bord = bord;
        // Hier registrieren wir FrameGame als ActionListener für die Buttons
        frame.addButtonListener(this);  // Add FrameGame as ActionListener
    }

    @Override
    public void doGame(Player player1, Player player2) throws ColumnFullException, IllegalMoveException, IOException {
        super.setBord((ObservableBord) bord);
        setPlayerX(player1);
        setPlayerO(player2);

        // Setze den ersten Spieler (aktuell wird 'playerX' gesetzt)
        setIstDran(player1);
        // Registriere den Observer
        getBord();

        // Spiel startet, der erste Spieler macht seinen Zug
        getIstDran().doTurn();

    }

    @Override
    public void update(ObservableBord bord) throws ColumnFullException, IllegalMoveException, IOException {
        // Überprüfe, ob es einen Gewinner gibt
        Winner winner = bord.TestVictory();
        if (winner != Winner.NONE) {
            // Wenn es einen Gewinner gibt, deaktiviere die Buttons
            frame.deactivateButtons();
            if (winner == Winner.RED) {
                System.out.println("Player Red wins!");
            } else if (winner == Winner.BLUE) {
                System.out.println("Player Blue wins!");
            }
        } else {
            // Wenn kein Gewinner, wechsle den Spieler
            swapPlayer();
            // Der neue Spieler macht seinen Zug
            getIstDran().doTurn();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Récupère la colonne sur laquelle l'utilisateur a cliqué
        int columnIndex = Integer.parseInt(e.getActionCommand());

        // Essaie de jouer un jeton dans la colonne choisie
        try {
            getIstDran().doDrop(columnIndex);  // Appelle la méthode doDrop pour déposer le jeton
        } catch (ColumnFullException | IllegalMoveException | IOException ex) {
            ex.printStackTrace();  // Affiche une erreur si la colonne est pleine ou le coup est illégal
        }

        // Après un mouvement, enlève le listener
        frame.removeButtonListener(this);
    }

}
