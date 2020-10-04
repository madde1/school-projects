import java.util.Date;

class Add {

    static void userInput() {
        System.out.print("Write: ");
        String input = UserInput.getString();

        // Här ska kryptering in
        String thisIsEncrypted = Encryption.stringToEncrypt(input);
        Arrays.setStrings(thisIsEncrypted);

        System.out.println("\nA new String '" + input + "' was added to.. " + thisIsEncrypted);
        printWholeArray();
        timeStamp();
        System.out.println("increasing the fibonacci series...");
        Fibonacci.addNewFibonacci();
        Fibonacci.printGeneratedFibonacciSeries();
    }

    private static void printWholeArray() {
        System.out.println(Arrays.getStrings());
    }

    private static void timeStamp(){
        Date date = new Date();
        Arrays.getTimeStamp().add(date);
        printTimeStamp();
    }

    private static void printTimeStamp(){
        System.out.println(Arrays.getTimeStamp());
    }
}