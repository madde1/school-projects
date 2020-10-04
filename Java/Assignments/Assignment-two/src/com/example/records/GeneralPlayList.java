package com.example.records;
import java.util.Scanner;


public class GeneralPlayList {
    private static Scanner scanner = new Scanner(System.in);
    public static PlayListFunctions playlistfunctions = new PlayListFunctions();

    private String songName;
    private String artistName;

    //Konstruktor för GeneralPlayList
    public GeneralPlayList(String songName, String artistName) {
        this.songName = songName;
        this.artistName = artistName;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtist() {
        return artistName;
    }


    public static GeneralPlayList createSongs(String songName, String artistName) {
        return new GeneralPlayList(songName, artistName);
    }

  public void addToList() {
      System.out.println("Write in the name of the song: ");
      String songName = scanner.nextLine();
      System.out.println("write the name of the artist");
      String artistName = scanner.nextLine();
      GeneralPlayList newSong = GeneralPlayList.createSongs(songName, artistName);
      if (playlistfunctions.addNewSong(newSong)) {
          System.out.println("New song is added to the playlist: " + songName + " - " + artistName);
      } else {
          System.out.println("Could not add " + songName + " because it already exist");
      }
  }
  /**
   * UpdateSong metoden uppdaterar låten genom att man kan byta namn på låten, artisten, man kan även lägga till
   * den som favorit i favoritlåt listan och man kan lägga till låten i den specifika låtlistan. */

  public void updateSong(){
        System.out.println("Write the name of the song: ");
        String songName = scanner.nextLine();
        GeneralPlayList existingSong = playlistfunctions.searchSongs(songName);
        if(existingSong == null){
            System.out.println("can´t find the song you want to update.");
            return;
        }
        System.out.println("Write a new song name: ");
        String newSongName = scanner.nextLine();
        System.out.println("Write the new name of the artist: ");
        String newArtistName = scanner.nextLine();
        System.out.println("Do you want to add this song to your specifik playlist?" +"\n yes or no");
        String specifikPlaylist = scanner.nextLine();
        if (specifikPlaylist.equals("yes")|| specifikPlaylist.equals("Yes")){
            System.out.println("What is the beats per minuet on the song?");
            int bmp = scanner.nextInt();
            scanner.nextLine();
            System.out.println("What genre is the song?");
            String songGenre = scanner.nextLine();
            SpecificPlayList specificSong = SpecificPlayList.createTypeOfSongs(newSongName, newArtistName, bmp, songGenre);
            SpecificPlayList.playlistfunctions.addNewSong(specificSong);
        }
        System.out.println("Do you want to add this song to your favorite playlist?" + " \n yes or no : ");
        String checkAnswer = scanner.nextLine();
        if(checkAnswer.equals("yes")|| checkAnswer.equals("Yes")) {
            FavoritSong favoritSong = FavoritSong.createFavoritSong(newSongName, newArtistName);
            playlistfunctions.addNewFavoritSong(favoritSong); //Lägger till låten i favoritlåtlistan
            GeneralPlayList newSong = GeneralPlayList.createSongs(newSongName, newArtistName);
            if (playlistfunctions.updateSong(existingSong, newSong)) { //uppdaterar låten i den vanliga spellistan.
                System.out.println("The song has been updated");
            } else {
                System.out.println("Could not update");
            }
        }else {GeneralPlayList newSong = GeneralPlayList.createSongs(newSongName, newArtistName);
            if (playlistfunctions.updateSong(existingSong, newSong)){ // Uppdaterar bara låten och artisten, ifall man inte vill lägga till någonannanstans.
                System.out.println("The song has been updated");
            } else {
                System.out.println("Could not update");
            }
        }
  }
    public void removeSong(){
        System.out.println("write in the name of the song you want to remove");
        String song = scanner.nextLine();
        GeneralPlayList existingSong = playlistfunctions.searchSong(song);
        if(existingSong == null) {
            System.out.println("can´t find the song you want to remove.");
            return;
        }

        if(playlistfunctions.removeSongs(existingSong)){
            System.out.println("The song has been removed");
        }else {
            System.out.println("Could not remove the song.");
        }
    }
    public void searchSong(){
        System.out.println("write the name of the song: ");
        String song = scanner.nextLine();
        GeneralPlayList existingSong = playlistfunctions.searchSongs(song);
        if( existingSong == null){
            System.out.println("Can´t find the song you are searching for.");
            return;
        }
        System.out.println("The song is: " + existingSong.getSongName() + " The artist is: " + existingSong.getArtist());
    }

    //Skriver ut meny valen.
    public void printOptions(){
        System.out.println("Choose");
        System.out.println("0 - Quit\n" +
                "1 - Show Playlist \n" +
                "2 - Add new song to the playlist\n" +
                "3 - Remove a song from the playlist\n" +
                "4 - Search for a song in the playlist\n" +
                "5 - Update song\n"+
                "6 - Show only favorite songs\n" +
                "7 - Add songs to specified song list \n" +
                "8 - Show options");

    }
}






