package tuc.isse.model;

import java.io.IOException;

public interface BordObserver {
    public void update(ObservableBord bord) throws ColumnFullException, IllegalMoveException, IOException;
}
