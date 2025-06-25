package tuc.isse;
import org.junit.jupiter.api.Test;
import tuc.isse.Bord;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 */
public class TestBord {

    @Test
     void test1(){
       Bord bord1 = new Bord();

       /*
       Die zu testeten Tabelle generieren
        */
       bord1.dropToken(Color.RED, 6);
       bord1.dropToken(Color.BLUE, 4);
       bord1.dropToken(Color.RED, 6);
       bord1.dropToken(Color.BLUE, 2);
       bord1.dropToken(Color.BLUE, 4);
       bord1.dropToken(Color.BLUE, 5);
       bord1.dropToken(Color.RED, 6);
       bord1.dropToken(Color.RED, 2);
       bord1.dropToken(Color.BLUE, 3);
       bord1.dropToken(Color.RED, 4);
       bord1.dropToken(Color.RED, 5);
       bord1.dropToken(Color.BLUE, 6);



        String expected1 =
                        "( )( )( )( )( )( )( )\n" +
                        "( )( )( )( )( )( )( )\n" +
                        "( )( )( )( )( )( )(0)\n" +
                        "( )( )( )( )(X)( )(X)\n" +
                        "( )( )(X)( )(0)(X)(X)\n" +
                        "( )( )(0)(0)(0)(0)(X)\n";

        assertEquals(expected1, bord1.toString()); //Erster Test

        System.out.println("Test 1: Der Winner ist " + bord1.TestVictory());
        assertEquals(bord1.TestVictory(), Winner.NONE);

    }
    @Test
    void test2(){

       /*
       Die zu testete Tabelle generieren
        */

       Bord bord = new Bord();
       bord.dropToken(Color.RED, 6);
       bord.dropToken(Color.RED, 6);
       bord.dropToken(Color.BLUE, 6);
       bord.dropToken(Color.RED, 6);
       bord.dropToken(Color.BLUE, 5);
       bord.dropToken(Color.BLUE, 5);
       bord.dropToken(Color.RED, 5);
       bord.dropToken(Color.BLUE, 4);
       bord.dropToken(Color.RED, 4);
       bord.dropToken(Color.RED, 4);
       bord.dropToken(Color.RED, 3);
       bord.dropToken(Color.BLUE, 2);
       bord.dropToken(Color.RED, 2);
       bord.dropToken(Color.BLUE, 2);
       bord.dropToken(Color.RED, 1);
       bord.dropToken(Color.BLUE, 0);
       bord.dropToken(Color.BLUE, 0);


       String expected =
                       "( )( )( )( )( )( )( )\n" +
                       "( )( )( )( )( )( )( )\n" +
                       "( )( )( )( )( )( )(X)\n" +
                       "( )( )(0)( )(X)(X)(0)\n" +
                       "(0)( )(X)( )(X)(0)(X)\n" +
                       "(0)(X)(0)(X)(0)(0)(X)\n";
       assertEquals(expected, bord.toString());

        System.out.println("Test 2: Der Winner ist " + bord.TestVictory());
       assertEquals(bord.TestVictory(), Winner.RED);
    }
    @Test
    void test3(){
      /*
      Die dritte Tabelle generieren.
       */
       Bord bord = new Bord();
       bord.dropToken(Color.BLUE, 6);
       bord.dropToken(Color.BLUE, 5);
       bord.dropToken(Color.BLUE, 5);
       bord.dropToken(Color.BLUE, 5);
       bord.dropToken(Color.RED, 4);
       bord.dropToken(Color.RED, 4);
       bord.dropToken(Color.RED, 4);
       bord.dropToken(Color.RED, 4);
       bord.dropToken(Color.RED, 3);
       bord.dropToken(Color.RED, 2);
       bord.dropToken(Color.BLUE, 2);
       bord.dropToken(Color.RED, 2);
       bord.dropToken(Color.BLUE, 2);
       bord.dropToken(Color.BLUE, 1);
       bord.dropToken(Color.RED, 1);
       bord.dropToken(Color.BLUE, 1);
       bord.dropToken(Color.RED, 0);
       bord.dropToken(Color.BLUE, 0);


       String expected =
                       "( )( )( )( )( )( )( )\n" +
                       "( )( )( )( )( )( )( )\n" +
                       "( )( )(0)( )(X)( )( )\n" +
                       "( )(0)(X)( )(X)(0)( )\n" +
                       "(0)(X)(0)( )(X)(0)( )\n" +
                       "(X)(0)(X)(X)(X)(0)(0)\n";
       assertEquals(expected, bord.toString());

        System.out.println("Test 3: Der Winner ist " + bord.TestVictory());
       assertEquals(bord.TestVictory(), Winner.BLUE);


    }
}
