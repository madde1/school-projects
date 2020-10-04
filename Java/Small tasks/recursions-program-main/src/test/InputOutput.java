package test;
import java.util.Scanner;
public class InputOutput {
/** recursions program
 * A function that takes a int
 *
 * If input is 3 the output 6
 * If input is 5 the output 15
 * If input is 10 the output 55
 * 

    **/
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int inputNumber;

        System.out.println("Enter a number: ");
        inputNumber = scanner.nextInt();

        System.out.println(checkNumber(inputNumber));
        checkNumber(inputNumber);

    }

    public static int checkNumber(int inputNumber){
        if(inputNumber!=0){
            return inputNumber + checkNumber(inputNumber -1);
        }
        else {
            return inputNumber;
        }
    }
}
