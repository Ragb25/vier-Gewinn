package tuc.isse.controller;



import tuc.isse.model.Bord;
import tuc.isse.model.Color;
import tuc.isse.view.ColumnFullException;
import tuc.isse.view.IllegalMoveException;
import tuc.isse.view.VierGewinntFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/**
 * email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 */
public class FramePlayer extends Player implements ActionListener {

    private VierGewinntFrame fram;  // Referenz auf die Benutzeroberfläche

    public FramePlayer(Color color, Bord bord, VierGewinntFrame fram) {
        super(color, bord);
        this.fram = fram;
    }

    @Override
    public void doTurn() {
        // Der FramePlayer wird als ActionListener auf der Benutzeroberfläche registriert
        fram.addButtonListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Extrahiere die Spaltennummer aus dem ActionCommand des Buttons
        int columnIndex = Integer.parseInt(e.getActionCommand());

        try {
            // Der Spieler setzt ein Token in die gewählte Spalte
            doDrop(columnIndex);
        } catch (ColumnFullException | IllegalMoveException | IOException ex) {
            ex.printStackTrace();
        }

        // Entferne den FramePlayer als ActionListener, wenn der Zug abgeschlossen ist
        fram.removeButtonListener(this);
    }
}

