public class Fibonacci {
    //https://www.java-examples.com/fibonacci-series-java-example

    private static int counter = 0;

    /**
     * Call this function to add a new fibonacci number to the series
     */
    protected static void addNewFibonacci() {
        createAnewFibonacciElement();
    }

    private static void createAnewFibonacciElement() {
        if (0 == counter || 1 == counter) {
            Arrays.setFibonacci(counter);
            counter++;
        } else {
            Arrays.setFibonacci(Arrays.getFibonacci().get(counter-1) + Arrays.getFibonacci().get(counter-2));
            counter++;
        }
        if (counter > 1) {
            checkIfEvenOrOddNumber();
        }
    }

    /**
     * Call this function to print the series
     */
    protected static void printGeneratedFibonacciSeries() {
        printFibonacciSeries();
    }

    private static void printFibonacciSeries() {
        System.out.println("Current fibonacci serie: " + Arrays.getFibonacci().toString());
    }

    /**
     * (Extra)
     * Our own functionality - check if number is odd or even
     */
    private static void checkIfEvenOrOddNumber() {
        int value = whatIsValueOfID(whatIsHighestValidIndex());

        if (0 == value) {                       // division by zero is forbidden
            Arrays.setEvenNumbers(value);
        } else if (0 == value % 2) {
            Arrays.setEvenNumbers(value);
        } else {
            Arrays.setOddNumbers(value);
        }
    }
    private static int whatIsHighestValidIndex() {return (Arrays.getFibonacci().size() -1);}
    private static int whatIsValueOfID(int ID) {
        return Arrays.getFibonacci().get(ID);
    }

    protected static void printOddList() {
        printOddNumbers();
    }
    private static void printOddNumbers() {
        System.out.println("odd serie: " + Arrays.getOddNumbers().toString());
    }

    protected static void printEvenList() {
        printEvenNumbers();
    }
    private static void printEvenNumbers() {
        System.out.println("even serie: " + Arrays.getEvenNumbers().toString());
    }
}