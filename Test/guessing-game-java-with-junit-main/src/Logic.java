import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Logic {

    private int winNum;
    private int upLimit = 100;
    private int lowLimit = 0;
    private  Random randomGen = new Random();
    private ArrayList<Integer> arrayList = new ArrayList<>();


    public boolean isInRange(int guess) {
        if (guess >= lowLimit && guess <= upLimit) {
            return true;
        }
        return false;
    }

    public boolean lower(int guess) {
        if (guess < winNum) {
            return true;
        }
        return false;
    }

    public boolean higher(int guess) {
        if (guess > winNum) {
            return true;
        }
        return false;
    }

    public boolean isWinner(int guess) { //this one call first
        if (guess == winNum) {
            return true;
        }
        return false;
    }

    public String gameResult(int guess){
        if(isWinner(guess)){
           System.out.println("You won!");
        }else if(lower(guess)){
            System.out.println("Too low!");
        }else if(higher(guess)){
            System.out.println("Too high!");
        }
        return "You don't get to play anymore!";
    }

    public int randomStartNum(){
        return winNum = randomGen.nextInt(101);
    }

    public void startNumbArray(){
        int randomStart = randomGen.nextInt(101);
        if (randomStart != winNum) {
            arrayList.add(randomStart);
        }
    }

    public void genArrayList() {
        int count = 0;
        while (count < 10) {
            int randomInt = randomGen.nextInt(101);
            for (int i = 0; i <= arrayList.size(); i++) {
                if (!arrayList.get(i).equals(randomInt) && randomInt != winNum) {
                    arrayList.add(randomInt);
                    break;
                }
            }
            count++;
        }
    }


    public int getWinNum() {  //getter do we need this?
        return winNum;
    }

    public int getUpLimit() {
        return upLimit;
    }

    public int getLowLimit() {
        return lowLimit;
    }

    public ArrayList<Integer> getArrayList() {
        return arrayList;
    }

}

