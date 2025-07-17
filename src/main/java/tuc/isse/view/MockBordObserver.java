package tuc.isse.view;
/**
 * email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 */
public class MockBordObserver implements BordObserver {
    private boolean updateCalled = false;

    @Override
    public void update(ObservableBord bord) {
        // Setze die Variable auf true, wenn die update-Methode aufgerufen wird
        updateCalled = true;
    }

    public boolean isUpdateCalled() {
        return updateCalled;
    }
}
