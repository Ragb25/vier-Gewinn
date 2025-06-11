package tuc.isse;

public class Bord extends GameObjekt{

    private String [][] gameBord  = new String[6][7];
    private token token;

    public Bord(String [][] gameBord, token token){
        this.gameBord = gameBord;
        this.token = token;
    }
    public Bord(String [] GameBord){
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                Cell cell = new Cell();
                gameBord[i][j] = cell;
            }
        }

    }

    public String[][] getGameBord() {
        return gameBord;
    }

    public void setGameBord(String[][] gameBord) {
        this.gameBord = gameBord;
    }


}
