package sample;

import java.awt.*;
/**I denna klassen finns två metoder, en för vardera spelare där det genereras random nummer för varje spelare.
 * Vinnare kollas i main metoden genom en if sats bara.*/
public class Controller {

    /**Har använt denna metod för att kolla så att knappar och så funkar som det ska,
     * den skriver bara ut hej. */
 /*   String printOutput() {
        String test = "hej";
        System.out.println("hej");
        return test;
    }*/

 //Metod för spelare två. 
   int tossDicePlayer2() {
        int diceToss = 5;
        int diceSides = 6;
        int player2 = 0;
        int[] tossArray;
        tossArray = new int[1];
        for (int i = 1; i <= diceToss; i++) {
            tossArray[0] = (int) (1 + diceSides * Math.random());
            player2 += tossArray[0];


        }
       return player2;
    }
    //Metod för spelare ett

    int tossDicePlayer1() {
        int diceToss = 5;
        int diceSides = 6;
        int player1 = 0;
        int[] tossArray;
        tossArray = new int[1];
        for (int i = 1; i <= diceToss; i++) {
            tossArray[0] = (int) (1 + diceSides * Math.random());
            player1 += tossArray[0];


        }
        return player1;
    }


}