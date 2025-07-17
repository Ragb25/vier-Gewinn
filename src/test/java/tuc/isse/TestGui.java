package tuc.isse;

import tuc.isse.model.ObservableBord;
import tuc.isse.model.*;

public class TestGui {
    public static void main(String[] args) {
        // Erstelle eine Instanz von ObservableBord anstelle von Bord
        ObservableBord bord = new ObservableBord(); // Verwende ObservableBord
        VierGewinntFrame frame = new VierGewinntFrame(bord);
        bord.addObserver(frame);  // Füge den Observer hinzu

        // Simuliere einen Zug
        Token token = bord.getToken(Color.RED); // Beispiel: Token rot
        try {
            bord.dropToken(token, 0);  // Füge Token in die erste Spalte hinzu
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


