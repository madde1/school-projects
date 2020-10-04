package com.example;

import java.util.Scanner;

public class FarCel {
    public static void main(String[] args){
        float far, cel;

        Scanner scan = new Scanner(System.in);

        System.out.print("Do you want to convert Farenheit press F or do you want to convert Celsius to Farenheit, press C: ");
        String con = scan.nextLine();

        if(con.equals("F")){

        System.out.print("Enter temperatue in Farenheit: ");
        far = scan.nextInt();

        cel = ((far - 32)*5)/9;

        System.out.println("The temperatue in Celsius = " + cel);
        }
    else if (con.equals("C")){
            System.out.print("Enter temperatue in Celsius: ");
            cel = scan.nextInt();

            far =cel * 9/5 + 32;

            System.out.println("The temperatue in farenheit is: " + far);
        }
        else{
            System.out.println("Please choose F or C");
        }
    }

}
