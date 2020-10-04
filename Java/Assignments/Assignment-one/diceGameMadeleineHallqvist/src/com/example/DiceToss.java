package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class DiceToss {
    // Welcomes player to the game.
    public static void Welcome(){
        System.out.println("Welcome to this dice game, Hope you have fun playing!");
    }
    // Gets how many players that are going to play
    public static int getPlayers(){
        Scanner scan = new Scanner(System.in);
        System.out.print("How many players: ");
        int players = scan.nextInt();
        return players;
    }
    // Gets the name of the players
    public static String[] getNames(int numberOfPlayers){
        Scanner scan = new Scanner(System.in);
        String playerName[] = new String[numberOfPlayers];
        for (int i = 0; i < playerName.length; i++) {
            System.out.print("Enter player " + (i + 1) + " name: ");
            playerName[i] = scan.nextLine();
        }
        return playerName;
    }
    // Gets how many throws the players wants.
    public static int getToss(){
        Scanner scan = new Scanner(System.in);
        System.out.print("How many dice tosses: ");
        int tosses = scan.nextInt();
        return tosses;
    }
    // Plays the main game
    public static int[] playGame(int numberOfPlayers, int numberOfTosses, String playerName[]){
        int diceSides = 6;
        int toss ;
        int sumOfPlayer[] = new int[numberOfPlayers];
        int diceToss[] = new int[numberOfTosses];

        for (int i = 0; i < playerName.length; i++) {
            System.out.println("player " + playerName[i]);
            for (int j = 0; j < diceToss.length; j++) {
                toss = (int) (1 + diceSides * Math.random());
                System.out.println((j + 1) + " toss is: " + toss); //j + 1 so that spot number 0 in the array is not used
                sumOfPlayer[i] += toss;
            }
            System.out.println("Total is: " + sumOfPlayer[i] + '\n');
        } return sumOfPlayer;
    }
    // Crowns the winner of the game
    public static int crownWinner(int[] sumOfPlayer, String playerName[]){
        int winner = 0;
        int highestScore = sumOfPlayer[0];
        for (int i = 0; i < sumOfPlayer.length; i++) {
            if (sumOfPlayer[i] >= highestScore) {
                highestScore = sumOfPlayer[i];
                winner = i;
             }
        }
        System.out.print("Winner is player " + playerName[winner] +  " with highest score of " + highestScore + "\n" );
        return winner;
    }
    //Sorting list, sorts from the highest value too the lowest.
    public static  int[] sortList(int[] unsortedArray){

        int size = unsortedArray.length; // number of elements to sort
        //bubble sort
        for(int  a = 1; a < size; a++ ){
            for(int b = size-1; b >= a; b--){
                if(unsortedArray[b-1] < unsortedArray[b]){
                    int temp = unsortedArray[b-1];
                    unsortedArray[b-1] = unsortedArray[b];
                    unsortedArray[b]= temp;
                }
            }
        }
        return unsortedArray;
    }
    //Makes the highscore list.
   public static int[] highScoreList(int[] sumPlayer, int highScore[], boolean firstTime ){
        int[] sorted = sortList(sumPlayer);
        System.out.println("High Score: ");

        // first game, add values to highscore
        if ( firstTime == true) {
            for (int i = 0; i < sorted.length; i++) {
                highScore[i] = sorted[i];
            }

        }else{ //Second rond, check if the new values are bigger than the old values.
            for( int j =0; j < highScore.length; j++ ) {
                for (int i = 0; i < sorted.length; i++) {
                    if (sorted[0] > highScore[0]) {
                        highScore[0] = sorted[0];
                    if(sorted[1]>highScore[1]){
                           highScore[1]= sorted[1];
                        }
                    if(sorted[2] > highScore[2]){
                            highScore[2] = sorted[2];
                        }
                    }
                }
            }
        }
        // prints out the highscore list
        for (int i = 0; i < highScore.length; i++) {
            System.out.println(highScore[i]);
        }
       return highScore;
   }

    // Ask the players if they want to play again.
    public static String playAgain(){
        String input;
        Scanner scan = new Scanner(System.in);
        System.out.print("Do you wish to play again? yes or no : ");
        input = scan.nextLine();
        return input;
    }


    public static void main(String[] args) {

        Welcome();
        int winner ;
        String input;
        int tosses;
        int players;
        int[] sumOfPlayer;
        String[] playerName;
        int highScore[] = new int [3]; //The high score array
        boolean firstTime = true;
        //Do While loop so the game can be played more then once.
        do {
            players = getPlayers();
            playerName = getNames(players);
            tosses = getToss();
            sumOfPlayer = playGame(players, tosses, playerName);
            winner = crownWinner(sumOfPlayer, playerName);
            highScore = highScoreList(sumOfPlayer, highScore, firstTime);
            input = playAgain();
            firstTime = false;
        } while (input.equals("yes"));
       System.out.println("Thanks for playing!");

    }
}


