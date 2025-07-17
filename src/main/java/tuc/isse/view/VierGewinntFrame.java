package tuc.isse.view;

import tuc.isse.model.Bord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 * email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 */

public class VierGewinntFrame extends JFrame {
    private JButton[] columnButtons;  // Array für die Buttons der Spalten
    private JPanel boardPanel;        // Panel für das Spielfeld

    public VierGewinntFrame(Bord bord) {
        this.columnButtons = new JButton[7]; // 7 Spalten
        this.boardPanel = new JPanel(new GridLayout(6, 7)); // 6 Zeilen und 7 Spalten

        // Initialisieren der Spalten-Buttons
        for (int i = 0; i < 7; i++) {
            columnButtons[i] = new JButton("Spalte " + (i + 1));
            columnButtons[i].setActionCommand(String.valueOf(i)); // Setzt die Spaltennummer als ActionCommand
        }

        // Layout für die Buttons an der Oberseite
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        for (int i = 0; i < 7; i++) {
            buttonPanel.add(columnButtons[i]);
        }
        this.add(buttonPanel, BorderLayout.NORTH);  // Füge die Buttons dem Frame hinzu

        // Das Spielfeld-Panel
        this.add(boardPanel, BorderLayout.CENTER);
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Vier Gewinnt");
        this.setVisible(true);
    }

    // Methode zum Hinzufügen eines ActionListeners zu allen Buttons
    public void addButtonListener(ActionListener listener) {
        for (JButton button : columnButtons) {
            button.addActionListener(listener);  // Alle Spalten-Buttons bekommen den Listener
        }
    }

    // Methode zum Entfernen eines ActionListeners von allen Buttons
    public void removeButtonListener(ActionListener listener) {
        for (JButton button : columnButtons) {
            button.removeActionListener(listener);  // Entfernt den Listener von allen Buttons
        }
    }
    public void deactivateButtons() {
        for (JButton button : columnButtons) {
            button.setEnabled(false);  // Deaktiviert alle Spalten-Buttons
        }
    }

}

