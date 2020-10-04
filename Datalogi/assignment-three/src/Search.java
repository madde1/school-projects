class Search {

    /**
     * Search methods used by every search function in the program
     * returns indexId when the element is found or -1 if the element isn't found
     */
    protected static int searchAndGetStringIndex(String searchFor) {
        return searchAndGetStringIndexInternal(searchFor);
        // if -1 is returned, the element was not found
    }

    private static int searchAndGetStringIndexInternal(String searchFor) {
        return Encryption.searchEncrypt(searchFor);
    }

    /**
     * Explicit for Search Menu
     */
    protected static void goToSearch() {internal();}

    private static void internal() {menu();userChoice();}

    private static void menu() {
        System.out.print(
                        "+----------------+\n" +
                        "|   Choices:     |\n" +
                        "|  1. String     |\n" +
                        "|  2. Fibonacci  |\n" +
                        "+----------------+\n" +
                        "Choice: ");
    }

    private static void userChoice() {
        int input = UserInput.getNumber();
        if (1 == input) {
            searchString();
        } else if (2 == input) {
            searchFibonacci();
        }
    }

    /**
     * The two different search methods
     * One to search for stored strings and the other to search for stored fibonacci numbers.
     * (EXTRA)
     * if there is no match on Fibonacci, tell user what number is closest.
     */
    private static void searchString() {
        // Check if Arrays.strings is empty, true if empty
        boolean ArrayListIsEmpty = Arrays.getStrings().isEmpty();

        if (ArrayListIsEmpty) {                           // if isEmpty = true
            System.out.println("No numbers stored!");
        } else {
            System.out.print("Write what you are searching for: ");
            String input = UserInput.getString();
            int indexId = searchAndGetStringIndexInternal(input);
            if (indexId >= 0) {
                System.out.println(Encryption.stringToDecrypt(Arrays.getStrings().get(indexId)) + " existed!");
            } else {
                System.out.println(input + " was not found!");
            }
        }
    }

    private static void searchFibonacci() {
        // Check if Arrays.strings is empty, true if empty
        boolean ArrayListIsEmpty = Arrays.getFibonacci().isEmpty();

        if (ArrayListIsEmpty) {                           // if isEmpty = true
            System.out.println("No numbers stored!");
        } else {                                            // if isEmpty = false
            System.out.print("Write what you are searching for: ");
            int userInput = UserInput.getNumber();
            if (userInput == -1) {
                return;
            }
            // when we have a valid number
            searchFor(userInput);
        }
    }

    /**
     * Search for the number and in the same loop check for closest number
     */
    private static void searchFor(int numberToBeChecked) {
        int distance = Integer.MAX_VALUE;
        int idClosest = 0;
        int newDistance;

        for (int i = 0; i < Arrays.getFibonacci().size(); i++) {
            // search for numberToBeChecked
            int temp = Arrays.getFibonacci().get(i);
            if (temp == numberToBeChecked) {
                System.out.println(Arrays.getFibonacci().get(i) + " was found");
                return;
            }

            // Check distance from numberToBeChecked to temp, save id if newDistance is shortest
            newDistance = Math.abs(numberToBeChecked - temp);   // Extra
            if (newDistance < distance) {
                idClosest = i;
                distance = newDistance;
            }
        }
        System.out.println(
                numberToBeChecked + " was not found.\n" +
                "Closest number is: " + Arrays.getFibonacci().get(idClosest)
                );
    }
}