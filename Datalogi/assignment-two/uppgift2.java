

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class uppgift2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int options;
        String input;

        System.out.println("Welcome!");

        boolean quit = false;
        printOptions();

        while (!quit){
            System.out.println("Press 5 for options:");
            options = scanner.nextInt();
            scanner.nextLine();

            switch (options){
                case 0:
                    System.out.println("Shuts down..");
                    quit = true;
                    break;
                case 1:
                    boolean valid = true;
                    while (valid) {
                        System.out.println("Please write an input: ");
                        input = scanner.nextLine();
                        if (Character.isLetter(input.charAt(0))) { //Kollar om input är en char, ber då om int istället.
                            System.out.println("Only input numbers!");

                        }else if (Character.isDigit(input.charAt(0))) { //Kollar om input är en siffra
                            int primeNumber = Integer.parseInt(input); // Gör om input till int.

                            if (arrayList.contains(primeNumber)) { //Kollar om input redan finns i arrayen, ber i så fall om ny input.
                                System.out.println("The given input already exists");
                                valid = true;
                            } else {
                                if (isPrime(primeNumber)) { //Skickar int in en metod som kollar om det är ett primtal
                                    arrayList.add(primeNumber); //lägger till i arraylistan
                                    System.out.println(primeNumber + " är ett primtal");
                                    valid = false;
                                } else {
                                    System.out.println(primeNumber + " är inte ett primtal");
                                    valid = true;
                                }
                            }
                        }
                    }
                    System.out.println(addAllValues(arrayList));//Kallar på en metod som lägger ihop alla primtal och skriver ut summan och kollar om summan är ett primtal.
                    break;

                case 2:
                    int size ;
                    size = arrayList.size();
                    System.out.println(Arrays.toString(sortArray(arrayList,size))); //Kallar på/skriver ut metoden som sorterar arrayen
                    break;
                case 3:
                    searchNumber(arrayList); //Kallar på en metod som letar upp int i arrayen
                    break;
                case 4:
                    findPrimeNumbers(); //Kallar på metod som letar upp så många primtal som användaren vill få fram
                    break;
                case 5:
                    printOptions();
                    break;
            }
        }
    }

    /**
     * Metoden skriver ut meny valen i en lista*/
    private static void printOptions(){
        System.out.println("Choices: ");
        System.out.println("0 - Quit\n" +
                "1 - Add\n" +
                "2 - Sort\n"+
                "3 - Search\n" +
                "4 - Find prime numbers\n"+
                "5 - Show options");
    }

    /** Metoden kollar om input är ett primtal.
     * @param inputNumber;*/
    private static boolean isPrime(int inputNumber) {
        if (inputNumber <= 0) {
            return false;
        }
        for (int i = 2; i<=Math.sqrt(inputNumber); i++){
            if (inputNumber % i == 0){
                return false;
            }
        }
        return true;
    }
    /**Metod som adderar alla primtal och kolla om summan också är ett primtal, lägger i så fall till detta tal i arrayen
     * @param arrayList;
     * @return arrayList;*/
    private static ArrayList addAllValues(ArrayList<Integer> arrayList){
        int sum = 0;
        boolean valid = false;
        while (!valid) {
            //Lägger ihop alla talen i arrayen
            for (int number : arrayList) {
                sum += number;
            }
            //Kollar om summan också är ett primtal
            if (isPrime(sum)) {
                arrayList.add(sum);
                System.out.println(sum);
                valid = true;
            }
        }
        return arrayList;
    }
    /**Metod som använder Shell sort för att sortera Arraylistan
     * @param arrayList ;
     * @param size ;*/
    private static Integer[] sortArray(ArrayList<Integer> arrayList, int size){
        //Gör om Arraylist till Array för att kunna sortera med Shell Sort
        Integer[] arraylistSort = arrayList.toArray(new Integer[arrayList.size()]);

        for(int gap = size/2; gap > 0; gap /=2){

            for(int i = gap; i < size; i += 1){
                int temp = arraylistSort[i];
                int j;

                for(j = i; j >= gap && arraylistSort[j - gap] > temp; j -= gap){
                    arraylistSort[j] = arraylistSort[j - gap];
                }
                arraylistSort[j] = temp;
            }
        }
        return arraylistSort;
    }
    /**Metod för att kolla om det användaren vill söka efter finns i arrayen och
     * om det inte finns skrivs närmsta värdet ut.
     * @param arrayList ;*/
    private static void searchNumber(ArrayList arrayList){
        String search;
        int searchInt;
        Scanner scanner = new Scanner(System.in);
        int size;
        int findNumber = 0;
        size = arrayList.size();
        Integer[] sortedArray;
        //Arrayen skickas in i sorterings metoden för att lättare hitta rätt värde och vilket värde som är närmast
        sortedArray = sortArray(arrayList,size);

        System.out.println("What number do you want to search for? ");
        search = scanner.nextLine();
        searchInt = Integer.parseInt(search); //Omvandlar String till int.
        //Kollar närmsta värdet till det man får in i input.
        int distance = Math.abs(sortedArray[0] -searchInt);
        for(int i = 1; i <sortedArray.length; i++){
            int idistance = Math.abs(sortedArray[i] -searchInt);
            if(idistance < distance){
                findNumber = i;
                distance = idistance;
            }
        }
        int closestNumber = sortedArray[findNumber];
        //Skriver ut om den hittas eller ej och vilket närmsta numret är om den inte hittas.
        if(arrayList.contains(searchInt)){
            System.out.println(searchInt +  " was found");
            System.out.println(Arrays.toString(sortedArray));
        }else {
            System.out.println(searchInt + " was not found");
            System.out.println(closestNumber + " was the closest number");
        }
    }
    /**Metoden hittar primtal och lägger dom i en array, Arrayen rensas varje gång man kör och börjar på nästa
     * gång på det högsta värdet i tidigare arrayen.*/
    private static void findPrimeNumbers() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> findPrimeNumbersArray = new ArrayList<>();
        int amountOfNumbers;
        int status = 1, primeNumbers = 2, count, j;
        String input;
        boolean shouldContinue = true;

        while (shouldContinue) {
            System.out.println("How many prime numbers do you want to find? ");
            input = scanner.nextLine();

            if(Character.isLetter(input.charAt(0))){ //Kollar om input är en char
                shouldContinue = false;
                System.out.println("Please only input numbers");
                break;
            }
            amountOfNumbers = Integer.parseInt(input); // Gör om input till Int.

            if(amountOfNumbers == 0){ //Om man skriver in 0 går man ur loopen.
                break;
            }
            if(Character.isDigit(input.charAt(0))){ //Kollar så det är en int man matat in.
                for (count = 1; count <= amountOfNumbers; ) {
                    for (j = 2; j <= Math.sqrt(primeNumbers); j++) {
                        if (primeNumbers % j == 0) {
                            status = 0;
                            break;
                        }
                    }
                    //Om ett primtal hittas blir status 0 i loopen och går in i if satsen och tillsätter värdet i arrayen.
                    if (status != 0) {
                        findPrimeNumbersArray.add(primeNumbers);
                        count++;
                    }
                    status = 1;
                    primeNumbers++;

                }
            }
            System.out.println(findPrimeNumbersArray);
            System.out.println(findPrimeNumbersArray.get(findPrimeNumbersArray.size() - 1));
            primeNumbers = findPrimeNumbersArray.get(findPrimeNumbersArray.size() -1); //Hämtar högsta(sista värdet i arrayen)
            findPrimeNumbersArray.clear(); //Rensar arrayen
        }
    }
}



