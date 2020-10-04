package com.example.records;

import java.util.Scanner;

public class RunProgram {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * @author Madeleine
     * @version 1.0
     * @since 2018-10-15
     */
    public static void main(String args[]) {
     //Object av klasserna för att kunna komma åt metoderna och kunna override metoderna i klasserna.
     GeneralPlayList a = new GeneralPlayList("","");
     SpecificPlayList b = new SpecificPlayList("","", 0, "");


        boolean quit = false;
        a.printOptions();

        while (!quit) {
            //För att kunna kolla vilken typ av spellista man vill skapa
            System.out.print("\n");
            System.out.println("Do you want to make a General play list or a specific one?");
            System.out.println("Press G for General and S for specific");
            String checkoption = scanner.nextLine();

            System.out.print("Press 8 for options: ");
            int options = scanner.nextInt();
            scanner.nextLine();

            switch (options) {
                case 0:
                    System.out.println("Shuts down..");
                    quit = true;
                    break;

                case 1:
                    if(checkoption.equals("G") || checkoption.equals("g")) {
                        GeneralPlayList.playlistfunctions.printSongs();
                    }else if(checkoption.equals("S") || checkoption.equals("s")){
                        SpecificPlayList.playlistfunctions.printSongs();
                    }
                    break;
                case 2:
                    if (checkoption.equals("G") || checkoption.equals("g")) {
                   a.addToList();
                    } else if (checkoption.equals("S") || checkoption.equals("s")) {
                       b.addToList();
                    }
                    break;

                case 3:
                    if(checkoption.equals("G") || checkoption.equals("g")) {
                        a.removeSong();
                    } else if(checkoption.equals("S") || checkoption.equals("s")){
                       b.removeSong();
                    }
                    break;

                case 4:
                    if(checkoption.equals("G") || checkoption.equals("g")) {
                        a.searchSong();
                    }else if (checkoption.equals("S") || checkoption.equals("s")) {
                        b.searchSong();
                    }
                    break;

                case 5:
                    a.updateSong();
                    break;
                case 6:
                    GeneralPlayList.playlistfunctions.printFavoritSongs();
                    break;

                case 7:
                     b.addToList();
                    break;
                case 8:
                    a.printOptions();
                    break;

                case 9:
                    SpecificPlayList.playlistfunctions.printSongs();
            }

        }

    }
}


