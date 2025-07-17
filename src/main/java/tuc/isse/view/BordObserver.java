package tuc.isse.view;

import java.io.IOException;
/**
 * email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 */
public interface BordObserver {
    public void update(ObservableBord bord) throws ColumnFullException, IllegalMoveException, IOException;
}
