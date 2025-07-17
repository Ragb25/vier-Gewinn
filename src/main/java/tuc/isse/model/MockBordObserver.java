package tuc.isse.model;

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
