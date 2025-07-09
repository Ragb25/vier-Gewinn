package tuc.isse;

public class MocPlayer extends Player{
    private int moveFirstColumn;
    private int moveSecondColumn;
    private int round;
    private Color color;
    private Bord bord;

    public MocPlayer(Color color, Bord bord, int moveFirstColumn, int moveSecondColumn, int round) {
        super(color, bord);
        this.moveFirstColumn = moveFirstColumn;
        this.moveSecondColumn = moveSecondColumn;
        this.round = round;
        this.bord = bord;
        this.color = color;

    }

    @Override
    public void doTurn() throws ColumnFullException, IllegalMoveException {


        if(round%2 == 0){
            super.doDrop(moveFirstColumn);
        } else super.doDrop(moveSecondColumn);

        round += 1;

    }
}
