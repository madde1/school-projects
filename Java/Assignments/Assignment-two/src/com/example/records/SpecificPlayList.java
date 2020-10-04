package com.example.records;
import java.util.Scanner;

public class SpecificPlayList extends GeneralPlayList {

    private static Scanner scanner = new Scanner(System.in);
    public static PlayListFunctions playlistfunctions = new PlayListFunctions();

    private int bmp;
    private String genre;

    //kontstuktor för subklass
    public SpecificPlayList(String songName, String artistName, int bmp, String genre) {
        super(songName, artistName);
        this.bmp = bmp;
        this.genre = genre;
    }

    public int getBmp() {
        return bmp;
    }

    public String getGenre() {
        return genre;
    }

    public static SpecificPlayList createTypeOfSongs(String songName, String artistName, int bmp, String genre) {
        return new SpecificPlayList(songName, artistName, bmp, genre);
    }

    private static void list() {
        System.out.println("Write in the name of the song");
        String songName = scanner.nextLine();
        System.out.println("Write the name of the artist");
        String artistName = scanner.nextLine();
        System.out.println("What is the beats per minuet on the song?");
        int bmp = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What genre is the song?");
        String songGenre = scanner.nextLine();
        SpecificPlayList newSong = SpecificPlayList.createTypeOfSongs(songName, artistName, bmp, songGenre);
        if (playlistfunctions.addNewSong(newSong)) {
            System.out.println("New song is added to the playlist: " + songName + " - " + artistName + ", BMP: " + bmp + ", Genre: " + songGenre);
        } else {
            System.out.println("Could not add " + songName + " because it already exist");
        }
    }

    private static void remove() {
        System.out.println("write in the name of the song you want to remove");
        String song = scanner.nextLine();
        SpecificPlayList existingSong = playlistfunctions.searchSong(song);
        if (existingSong == null) {
            System.out.println("can´t find the song you want to remove.");
            return;
        }

        if (playlistfunctions.removeSong(existingSong)) {
            System.out.println("The song has been removed");
        } else {
            System.out.println("Could not remove the song.");
        }
    }
    private void search(){
        System.out.println("write the name of the song: ");
        String song = scanner.nextLine();
        SpecificPlayList existingSong = playlistfunctions.searchSong(song);
        if( existingSong == null){
            System.out.println("Can´t find the song you are searching for.");
            return;
        }

        System.out.println("The song is: " + existingSong.getSongName() + ", The artist is: " + existingSong.getArtist()
             + "\n , The beats per minute is: " + existingSong.getBmp() +", The genre is: " + existingSong.getGenre());
    }

    @Override
    public void addToList() {
        list();
    }

    @Override
    public void removeSong() {
        remove();
    }
    @Override
    public void searchSong(){
        search();
    }

}
