package com.exampel;

import java.util.Scanner;
public class klasser {
    public static void main(String arg[]){
        Scanner scan = new Scanner(System.in);

    /*
    Skapar två objekt (instanser) av klassen Bil (två biltyper)
    För att kunna använda klassen Bil då den inte har en egen main-metod måste man använda nyckelordet new i satsen för att skapa ett objekt (instans).
    */
        System.out.print("Skriv in hastigheten för din Saab: ");
        String hastSaab = scan.nextLine();

        System.out.print("Skriv in hastigheten för din Volvo: ");
        String hastVolvo = scan.nextLine();

        System.out.print("Vill du att volvon ska köra framåt eller bakåt? ");
        String framBakvolvo = scan.nextLine();

        System.out.print("Vill du att saaben ska köra framåt eller bakåt? ");
        String framBaksaab = scan.nextLine();

        cars saab = new cars("1.2", "röd", hastSaab, "2017", framBakvolvo);
        cars volvo = new cars("1.6", "blå", hastVolvo, "1999", framBaksaab);

        // Vilken är den snabbaste bilen
        String snabbastText;
        if (Integer.valueOf(saab.getHastighet()) > Integer.valueOf(volvo.getHastighet())) {
            snabbastText = "Saab är snabbast!";
        } else {
            snabbastText = "Volvo är snabbast!";
        }
        String framBak;
        if (saab.getFrambak() == "framåt"){
            framBak = "framåt";
        }
        else {
            framBak = "bakåt";
        }
        if (volvo.getFrambak() == "framåt"){
            framBak = "framåt";
        }
        else {
            framBak = "bakåt";
        }
        // Skriver ut info för varje bil
        System.out.println(saab.bilInfo("Saab"));
        System.out.println(volvo.bilInfo("Volvo"));
        System.out.println(snabbastText);
    }
}
