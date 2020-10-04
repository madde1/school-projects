package algoritm1;
import java.util.Scanner;
public class algoritm1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write a number: ");
        int inputNumber = scanner.nextInt();

        if(isPrime(inputNumber)){
            System.out.println(inputNumber + " is a prime number");
        }
        else {
            System.out.println(inputNumber + " is not a prime number");
        }
    }

    public static boolean isPrime(int inputNumber) {
        if (inputNumber <= 0) {
            return false;
        }
        for (int i = 2; i<Math.sqrt(inputNumber); i++){
            if (inputNumber % i == 0){
                return false;
            }
        }
        return true;
    }
}