package tuc.isse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 */
public class TestBord {

    @Test
     void test1() throws ColumnFullException, IllegalMoveException {
       Bord bord1 = new Bord();

       /*
       Die zu testeten Tabelle generieren
        */
       bord1.dropToken(bord1.getToken(Color.RED), 6);
       bord1.dropToken(bord1.getToken(Color.BLUE), 4);
       bord1.dropToken(bord1.getToken(Color.RED), 6);
       bord1.dropToken(bord1.getToken(Color.BLUE), 2);
       bord1.dropToken(bord1.getToken(Color.BLUE), 4);
       bord1.dropToken(bord1.getToken(Color.BLUE), 5);
       bord1.dropToken(bord1.getToken(Color.RED), 6);
       bord1.dropToken(bord1.getToken(Color.RED), 2);
       bord1.dropToken(bord1.getToken(Color.BLUE), 3);
       bord1.dropToken(bord1.getToken(Color.RED), 4);
       bord1.dropToken(bord1.getToken(Color.RED), 5);
       bord1.dropToken(bord1.getToken(Color.BLUE), 6);


        String expected1 =
                        "( )( )( )( )( )( )( )\n" +
                        "( )( )( )( )( )( )( )\n" +
                        "( )( )( )( )( )( )(0)\n" +
                        "( )( )( )( )(X)( )(X)\n" +
                        "( )( )(X)( )(0)(X)(X)\n" +
                        "( )( )(0)(0)(0)(0)(X)\n";

        assertEquals(expected1, bord1.toString()); //Erster Test

        System.out.println("Test 1: Der Winner ist " + bord1.TestVictory());

        // Erweiterung des Testes
        assertEquals(bord1.TestVictory(), Winner.NONE);

    }
    @Test
    void test2() throws ColumnFullException, IllegalMoveException {

       /*
       Die zu testete Tabelle generieren
        */

       Bord bord = new Bord();
       bord.dropToken(bord.getToken(Color.RED), 6);
       bord.dropToken(bord.getToken(Color.RED), 6);
       bord.dropToken(bord.getToken(Color.BLUE), 6);
       bord.dropToken(bord.getToken(Color.RED), 6);
       bord.dropToken(bord.getToken(Color.BLUE), 5);
       bord.dropToken(bord.getToken(Color.BLUE), 5);
       bord.dropToken(bord.getToken(Color.RED), 5);
       bord.dropToken(bord.getToken(Color.BLUE), 4);
       bord.dropToken(bord.getToken(Color.RED), 4);
       bord.dropToken(bord.getToken(Color.RED), 4);
       bord.dropToken(bord.getToken(Color.RED), 3);
       bord.dropToken(bord.getToken(Color.BLUE), 2);
       bord.dropToken(bord.getToken(Color.RED), 2);
       bord.dropToken(bord.getToken(Color.BLUE), 2);
       bord.dropToken(bord.getToken(Color.RED), 1);
       bord.dropToken(bord.getToken(Color.BLUE), 0);
       bord.dropToken(bord.getToken(Color.BLUE), 0);


       String expected =
                       "( )( )( )( )( )( )( )\n" +
                       "( )( )( )( )( )( )( )\n" +
                       "( )( )( )( )( )( )(X)\n" +
                       "( )( )(0)( )(X)(X)(0)\n" +
                       "(0)( )(X)( )(X)(0)(X)\n" +
                       "(0)(X)(0)(X)(0)(0)(X)\n";
       assertEquals(expected, bord.toString());

        System.out.println("Test 2: Der Winner ist " + bord.TestVictory());
        // Erweiterung des Testes
       assertEquals(bord.TestVictory(), Winner.RED);
    }
    @Test
    void test3() throws ColumnFullException, IllegalMoveException {
      /*
      Die dritte Tabelle generieren.
       */
       Bord bord = new Bord();
       bord.dropToken(bord.getToken(Color.BLUE), 6);
       bord.dropToken(bord.getToken(Color.BLUE), 5);
       bord.dropToken(bord.getToken(Color.BLUE), 5);
       bord.dropToken(bord.getToken(Color.BLUE), 5);
       bord.dropToken(bord.getToken(Color.RED), 4);
       bord.dropToken(bord.getToken(Color.RED), 4);
       bord.dropToken(bord.getToken(Color.RED), 4);
       bord.dropToken(bord.getToken(Color.RED), 4);
       bord.dropToken(bord.getToken(Color.RED), 3);
       bord.dropToken(bord.getToken(Color.RED), 2);
       bord.dropToken(bord.getToken(Color.BLUE), 2);
       bord.dropToken(bord.getToken(Color.RED), 2);
       bord.dropToken(bord.getToken(Color.BLUE), 2);
       bord.dropToken(bord.getToken(Color.BLUE), 1);
       bord.dropToken(bord.getToken(Color.RED), 1);
       bord.dropToken(bord.getToken(Color.BLUE), 1);
       bord.dropToken(bord.getToken(Color.RED), 0);
       bord.dropToken(bord.getToken(Color.BLUE), 0);


       String expected =
                       "( )( )( )( )( )( )( )\n" +
                       "( )( )( )( )( )( )( )\n" +
                       "( )( )(0)( )(X)( )( )\n" +
                       "( )(0)(X)( )(X)(0)( )\n" +
                       "(0)(X)(0)( )(X)(0)( )\n" +
                       "(X)(0)(X)(X)(X)(0)(0)\n";

        System.out.println("Test 3: Der Winner ist " + bord.TestVictory());

        // Erweiterung des Testes
        assertEquals(expected, bord.toString());
        assertEquals(bord.TestVictory(), Winner.BLUE);


    }

    @Test
    void test4() throws ColumnFullException, IllegalMoveException{
        Bord bord = new Bord();
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                if(i%2==0){
                    bord.dropToken(bord.getToken(Color.RED), i);
                }else bord.dropToken(bord.getToken(Color.BLUE), i);

            }
        }
        bord.dropToken(bord.getToken(Color.BLUE), 6);
        bord.dropToken(bord.getToken(Color.RED), 6);
        bord.dropToken(bord.getToken(Color.RED), 6);
        bord.dropToken(bord.getToken(Color.BLUE), 6);
        bord.dropToken(bord.getToken(Color.BLUE), 6);
        bord.dropToken(bord.getToken(Color.RED), 6);


        assertEquals(bord.TestVictory(), Winner.TIE);
        System.out.println("Der Winner ist " + bord.TestVictory());

    }
}
