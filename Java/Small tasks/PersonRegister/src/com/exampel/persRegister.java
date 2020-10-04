package com.exampel;

import java.util.Scanner;

public class persRegister {
    public static void main (String args[]){
    Scanner scan = new Scanner(System.in);
        //Skriva in namn
        // Skriva in ålder
        // skriva in adress
        //skriva in telefon
         String arrpers[] = new String[3];
         arrpers [0] = "";
         arrpers[1] = "";
         arrpers [2] ="";



        for (int i = 0; i < arrpers.length; i++) {
            System.out.print("Skriv in personens namn: ");
            String name = scan.nextLine();
            System.out.print("Skriv in personens ålder: ");
            String age = scan.nextLine();
            System.out.print("Skriv in personens adress: ");
            String adress = scan.nextLine();
            System.out.print("Skriv in personens telefonnr: ");
            String phonenbr = scan.nextLine();

            if ( arrpers.length <= 1){
                person persOne = new person(name, age, adress, phonenbr);
               arrpers[0] += persOne.Personinfo();

            }else if (arrpers.length <=2){
                person persTwo = new person(name, age, adress, phonenbr);
               arrpers[1] += persTwo.Personinfo();
            }else if(arrpers.length <= 3){
                person personThree = new person(name, age, adress, phonenbr);
               arrpers[2] += personThree.Personinfo();
            }
        }
        System.out.println(arrpers[0]);
        System.out.println(arrpers[1]);
        System.out.println(arrpers[2]);

    }

}
