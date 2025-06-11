package tuc.isse;
import org.junit.jupiter.api.Test;
import tuc.isse.Bord;
import static org.junit.jupiter.api.Assertions.assertEquals;

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


    }
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
                       "( )( )(O)( )(X)(X)(O)\n" +
                       "(O)( )(X)( )(X)(O)(X)\n" +
                       "(O)(X)(O)(X)(O)(O)(X)\n";
       assertEquals(expected, bord.toString());
    }
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
       bord.dropToken(Color.BLUE, 1);
       bord.dropToken(Color.RED, 1);
       bord.dropToken(Color.BLUE, 1);
       bord.dropToken(Color.RED, 0);
       bord.dropToken(Color.BLUE, 0);

       String expected =
                       "( )( )( )( )( )( )( )\n" +
                       "( )( )( )( )( )( )( )\n" +
                       "( )( )(O)( )(X)( )( )\n" +
                       "( )(O)(X)( )(X)(O)( )\n" +
                       "(O)(X)(O)( )(X)(O)( )\n" +
                       "(X)(O)(X)(X)(X)(O)(O)\n";
       assertEquals(expected, bord.toString());


    }
}
