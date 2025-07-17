package tuc.isse;

import tuc.isse.view.BordObserver;
import tuc.isse.view.ObservableBord;
import tuc.isse.model.*;
import tuc.isse.view.VierGewinntFrame;

public class TestGui {
    public static void main(String[] args) {
        // Erstelle eine Instanz von ObservableBord anstelle von Bord
        ObservableBord bord = new ObservableBord(); // Verwende ObservableBord
        VierGewinntFrame frame = new VierGewinntFrame(bord);
        bord.addObserver((BordObserver) frame);  // Füge den Observer hinzu

        // Simuliere einen Zug
        Token token = bord.getToken(Color.RED); // Beispiel: Token rot
        try {
            bord.dropToken(token, 0);  // Füge Token in die erste Spalte hinzu
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


