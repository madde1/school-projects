
public class Main {
    private static boolean quit = false;
    public static void main(String[] args) {
        runProgram();
    }

    private static void runProgram() {
        while(!quit) {
            printMenu();
            int action = UserInput.getNumber();

            if (action >= 0 && action <= 9) {
                switch (action) {
                    case 1:
                        add();
                        break;
                    case 2:
                        edit();
                        break;
                    case 3:
                        search();
                        break;
                    case 4:
                        sort();
                        break;
                    case 5:
                        delete();
                        break;
                    case 6:
                        printExtra();
                        break;
                    case 7:
                        countWords();
                        break;
                    case 8:
                        recursion();
                        break;
                    case 9:
                        debug();
                        break;
                    case 0:
                        quit();
                        break;
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nChoices:");
        System.out.println(
                        "+----------------------------+\n" +
                        "| 1  - Add                   |\n" +
                        "| 2  - Edit                  |\n" +
                        "| 3  - Search                |\n" +
                        "| 4  - Sort                  |\n" +
                        "| 5  - Remove                |\n" +
                        "| 6  - Print EXTRA           |\n" +
                        "| 7  - Count Words           |\n" +
                        "| 8  - Recursion             |\n" +
                        "| 9  - Debug                 |\n" +
                        "| 0  - Quit                  |\n" +
                        "+----------------------------+\n");
        System.out.print("Your choice: ");
    }

    private static void add() {
        System.out.println("add function...");
        Add.userInput();
    }

    private static void edit() {
        System.out.println("Edit");
        Edit.start();
    }

    private static void search() {
        System.out.println("Serch...");
        Search.goToSearch();
    }

    private static void sort() {
        System.out.println("Sort...");
        Sort.goToSort();
    }

    private static void delete() {
        System.out.println("Remove...");
        Delete.deleteStart();
    }

    private static void printExtra() {
        System.out.println(
                "Prints the even and the odd Fibonacci series\n" +
                "OddNumbers contains: " + Arrays.getOddNumbers().size() + " " + Arrays.getOddNumbers().toString() +"\n" +
                "EvenNumbers contains: " + Arrays.getEvenNumbers().size() + " " + Arrays.getEvenNumbers().toString()
                );
    }

    private static void countWords() {
        System.out.println("Count words...");
        CountWords.startCount();
    }

    private static void recursion() {
        Recursion.startRecursion();
    }

    private static void debug() {
        Debug.start();
    }

    private static void quit() {
        System.out.println("Quit...");
        UserInput.closeScanner();
        quit = true;
    }
}

