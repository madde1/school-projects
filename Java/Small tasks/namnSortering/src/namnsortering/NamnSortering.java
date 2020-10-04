package namnsortering;

import java.util.Arrays;
import java.util.Random;

public class NamnSortering {

    public static void main(String[] args) {

        String[] newArray = {"Mattias", "Madde", "Anna", "Janna", "Sofia", "Joshua", "Nihad", "Alexis", "Pär",
                "Alexander", "Linus", "Viktor", "Lucie", "Andreas", "Simon", "Lars", "Wictor", "Carl"};
        selectionSort(newArray);
        //sortRandom(newArray);
    }
    private static void sortRandom(String[] newArray){
        Random random = new Random();
        for(int i = 0; i < newArray.length; i++){

        }
    }

    private static void selectionSort(String[] newArray) {


        for (int a = 0; a < newArray.length; a++) {
            int minIndex = a;
            for (int b = a + 1; b < newArray.length; b++) {
                if (newArray[b].compareTo(newArray[minIndex]) < 0) {
                    minIndex = b;
                }
            }
            String temp = newArray[a];
            newArray[a] = newArray[minIndex];
            newArray[minIndex] = temp;
            System.out.println(newArray[a]);
        }
    }
}