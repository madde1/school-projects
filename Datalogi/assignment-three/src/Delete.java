/**
 * Class that checks if the value the User wants to delete exists,
 * if it does, it removes the value and the same index place in TimeStamp Array
 * as in the String array.
 */
class Delete {

    /**
     * Starts the delete part and calls on deleteValuesInArray
     */
    protected static void deleteStart(){
        deleteValueInArray();
    }

    /**
     * Method that deletes the value that the user wants to remove from the array
     */
    private static void deleteValueInArray() {
        System.out.println("What do you want to delete: ");
        String checkValue = UserInput.getString();
        int index = Search.searchAndGetStringIndex(checkValue); //Get the index of user input.
        //Checks if the string contains the given value, if so, remove it from the array.
        if (index >= 0) {
            System.out.println(checkValue + " is removed");
            Arrays.getStrings().remove(index); //Removes value from array
            Arrays.getTimeStamp().remove(index); //Removes same index place in TimeStamp array as in String array.
        } else {
            System.out.println(checkValue + " could not be found");
        }
    }
}