package tuc.isse.controller;

import tuc.isse.view.ColumnFullException;
import tuc.isse.view.IllegalMoveException;
import tuc.isse.model.Bord;
import tuc.isse.model.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 */
public class ConsolePlayer extends Player {
    private Bord bord;
    private Color color;

    public ConsolePlayer(Color color, Bord bord) {
        super(color, bord);
        this.bord = bord;
        this.color = color;
    }

    /*
    Hier nehmen wir einfach die Eingabe des Nutzers uns Spielen wir damit.
     */
    @Override
    public void doTurn() throws ColumnFullException, IllegalMoveException, IOException {

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(consoleReader.readLine());
        super.doDrop(input);
    }
}
