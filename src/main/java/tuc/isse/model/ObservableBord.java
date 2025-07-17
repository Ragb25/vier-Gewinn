package tuc.isse.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ObservableBord extends Bord {

    private List<BordObserver> observers = new ArrayList<>(); // Liste der Observer

    // Methode zum Hinzufügen eines Beobachters
    public void addObserver(BordObserver observer) {
        observers.add(observer);
    }

    // Methode zum Entfernen eines Beobachters
    public void removeObserver(BordObserver observer) {
        observers.remove(observer);
    }

    // Benachrichtige alle Observer
    public void notifyObserver() throws ColumnFullException, IllegalMoveException, IOException {
        for (BordObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void dropToken(Token token, int columnsIndex) throws ColumnFullException, IllegalMoveException, IOException {
        super.dropToken(token, columnsIndex); // Rufe die Methode der Basisklasse auf
        notifyObserver(); // Benachrichtige alle Observer nach dem Hinzufügen eines Tokens
    }
}

