
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
/**
 * Program that handels arrays and changes the values.
 * Program can also handle input and insert values.
 * @author Madeleine Hallqvist
*/
public class uppgift1Datalogi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        char t = 't';
        char[] charArray1 = {'s', 't', 'r', 'i', 'n', 'g'};
        char[] charArray2 = {'s', 'i', 'n', 'g'};
        String[] stringArray = new String[1];
        int counter = 0;
        boolean quit = false;

        startMeny();
        while (!quit) {
            System.out.println("Välj 0 för manuell input, 1 för slumpmässig, 2 för att stänga ner programmet: ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    //Start value, Prints out the char array and prints true when hitting a T.
                    //Task Part Main:
                    System.out.println("Main: ");
                    System.out.println(charArray1);
                    detectTinArray(charArray1, t);
                    System.out.println(charArray2);
                    detectTinArray(charArray2, t);

                    //Changes the R:s to T:s in the char array.
                    //Task Part A:
                    System.out.println("A:");
                    changeRToT(charArray1);
                    changeRToT(charArray2);
                    System.out.println(charArray1);
                    System.out.println(charArray2);

                    //Changes so that smal t is capital T.
                    //Task Part B:
                    System.out.println("B: ");
                    System.out.println(charArray1);
                    detectTinArray(charArray1, t);
                    System.out.println(charArray2);
                    detectTinArray(charArray2, t);

                    //Removes all duplicates
                    //Task Part C:
                    System.out.println("C: ");
                    detectTinArray(charArray1, t);
                    detectTinArray(charArray2, t);

                    // Checks if the arrays is identical
                    //Task Part D:
                    System.out.println("D:");
                    if (charArray1 == charArray2) {
                        System.out.println("charArray1 and charArray2 are identical.");
                    }

                    /**
                     * Takes input from user.*/
                    //Task Part E:
                    System.out.println("E");
                    boolean shouldContinue = true;
                    while (shouldContinue) {
                        char[] inputCharArray = new char[3];
                        char output;
                        int checkInputIndex;
                        for (int i = 0; i < inputCharArray.length; i++) {
                            System.out.println("Write input: ");
                            input = scanner.nextLine();
                            if (input.equals("")) {
                                shouldContinue = false;
                                System.out.println("Input is empty, exits.");
                                break;
                            }
                            output = checkInput(input);
                            inputCharArray[i] = output;
                        }
                        if (!shouldContinue) {
                            break;
                        }
                        System.out.println("Write new input: ");
                        input = scanner.nextLine();
                        output = checkInput(input);
                        System.out.println("What array index do you want the new value:");
                        System.out.println("Write 0, 1 or 2");
                        checkInputIndex = scanner.nextInt();
                        if (checkInputIndex > 2) { // kollar om checkinput är mer än 2.
                            System.out.println("We will crash!");
                        }
                        inputCharArray[checkInputIndex] = output; // tillsätter ny input på rätt index

                        System.out.println(Arrays.toString(inputCharArray));
                        scanner.nextLine(); // Rensa buffer
                        String stringFromChar = new String(inputCharArray);
                        if (counter == 0) {
                            stringArray[0] = stringFromChar;
                        }
                        //Kallar på String Array metod för F delen.
                        stringArray = stringArrayAndAddSecondInput(stringFromChar, counter, stringArray);
                        counter++;
                    }
                    break;

                //Random part of the program:
                case 1:
                    //Start value, Prints out the char array and prints true when hitting a T.
                    //Task Part Main:
                    System.out.println("Main: ");
                    System.out.println(charArray1);
                    detectTinArray(charArray1, t);
                    System.out.println(charArray2);
                    detectTinArray(charArray2, t);

                    //Changes the R:s to T:s in the char array.
                    //Task Part A:
                    System.out.println("A:");
                    changeRToT(charArray1);
                    changeRToT(charArray2);
                    System.out.println(charArray1);
                    System.out.println(charArray2);

                    //Changes so that smal t is capital T.
                    //Task Part B:
                    System.out.println("B: ");
                    System.out.println(charArray1);
                    detectTinArray(charArray1, t);
                    System.out.println(charArray2);
                    detectTinArray(charArray2, t);

                    //Removes all duplicates
                    //Task Part C:
                    System.out.println("C: ");
                    detectTinArray(charArray1, t);
                    detectTinArray(charArray2, t);

                    // Checks if the arrays is identical
                    //Task Part D:
                    System.out.println("D: ");
                    if (charArray1 == charArray2) {
                        System.out.println("charArray1 and charArray2 are identical.");
                    }

                    createRandomArray();
                    break;
                //User can exit the program
                case 2:
                    System.out.println("Program shuts down...");
                    quit = true;
                    break;
            }
        }
    }

    /**
     * Creates Random input.*/
    private static void createRandomArray () {
        Scanner inputX = new Scanner(System.in);
        int arrayLength;
        Random r = new Random();

        System.out.println("Input number of index in Array: ");
        arrayLength = inputX.nextInt();

        char[] randomArray = new char[arrayLength];
        char[] real = new char[26];
        real = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (char)(r.nextInt(26) +97);
            System.out.print(randomArray[i]);
        }
        System.out.println();
    }

    //Program start.
    private static void startMeny () { System.out.print("Welcome to the program."); }

    /**
     * @param charArray
     * @param t
     *  Check if there is something in the array.*/
    private static void detectTinArray(char[] charArray, char t) {
        String output = "";
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'T' || t == (charArray[i])) {
                changetToT(charArray);
                output = "true";
                break;
            } else {
                output = "false";
            }
        }
        System.out.println(output);
        int length = charArray.length;
        length = removeDuplicates(charArray, length);
        for(int i = 0; i < length; i++ ){
            System.out.print(charArray[i]);
        }
        System.out.println();
    }
    /**
     * @param charArray
     * Change r to t*/
    private static void changeRToT(char charArray[]) {
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'r') {
                count++;
                charArray[i] = 't';
            }
        }

    }
    /**
     * @param charArray
     * change t to T'*/
    private static void changetToT(char charArray[]) {
        char t = 't';
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 't') {
                charArray[i] = Character.toUpperCase(t);
            }
        }
    }

    /**
     * @param charArray
     * @param n
     * @return j
     * Remove duplicates*/
    private static int removeDuplicates(char[] charArray, int n) {
        if (n == 0 || n == 1 ) { // kollar om array längden är 0 eller 1, om ej fortsätter programmet.
            return n;
        }

        char[] temp = new char[n]; // temporär array
        int j = 0;

        for (int i = 0; i < n - 1; i++) { //går igenom temp arrayen
            if (charArray[i] != charArray[i + 1]) { //jämför platserna i arrayerna
                temp[j++] = charArray[i];
            }
        }
        temp[j++] = charArray[n - 1];

        for (int i = 0; i < j; i++) {
            charArray[i] = temp[i];
        }
        return j; //skickar upp den nya längden på arrayen utan dubbletter.
    }

    /**
     * @param input
     * @return  output
     *Checks if input is char, String or int. */
    private static char checkInput(String input){
        Scanner scanner = new Scanner(System.in);
        char output;
        output = input.charAt(0);
        if(Character.isDigit(output)){
            System.out.println("input is a number");
        }else if(input.length()>1){
            System.out.println("input is a String");
        }else if(input.length() == 1){
            System.out.println("input is a char");
        }

        return output;
    }
    /**
     * @param input
     * @param j
     * @param stringArray
     */
    private static String[] stringArrayAndAddSecondInput(String input, int j, String[] stringArray) {
        if (j > 0) {
            stringArray = addElement(stringArray, input);
        }
        //Prints F part:
        System.out.println("F: ");
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[stringArray.length-1] = input;
            System.out.println(stringArray[i]);
        }
        //Prints ut G part:
        System.out.println("G: ");
        System.out.println(Arrays.toString(printStringArray(j,stringArray)));
        return stringArray;
    }

    /**@param input
     * @param stringArray
     * @return stringArray*/
    private static String[] addElement(String[] stringArray, String input) {
        stringArray = Arrays.copyOf(stringArray, stringArray.length + 1); //Kopierar Arrayen och lägger till en plats.
        return stringArray;
    }

    /**
     * @param array
     * @param n
     * @return array
     */
    private static String[] printStringArray(int n, String[] array){
        if(n != 0){
            return  printStringArray(n-1, array);
        }else {

            return array;
        }
    }
}


