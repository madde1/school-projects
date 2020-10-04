package com.example.records;

import java.util.ArrayList;
/**
 * I denna klassen finns funktioner som lägg till, tabort, updatera m.m det är i denna klassen alla inmatning läggs till
 * i arraylistorna. */
public class PlayListFunctions {
    /**
     * Alla ArrayListorna för programmet kan kallas på med samma funktion PlayListFunction()
     */
    private ArrayList<SpecificPlayList> specificPlayLists;
    private ArrayList<GeneralPlayList> generalSongList;
    private ArrayList<FavoritSong> favoritSongs;

    public PlayListFunctions() {
        this.generalSongList = new ArrayList<GeneralPlayList>();
        this.specificPlayLists = new ArrayList<SpecificPlayList>();
        this.favoritSongs = new ArrayList<FavoritSong>();
    }

    /** */

    //Lägger till inmatiningen i arraylistan för GeneralPlayList
    public boolean addNewSong(GeneralPlayList songs) {
        if (findSongs(songs.getSongName()) >= 0) {
            System.out.println("The song is already saved.");
            return false;
        }
        generalSongList.add(songs);
        return true;
    }
    public boolean addNewFavoritSong(FavoritSong favoritSong) {
        if (findSongs(favoritSong.getFavoritSong()) >= 0) {
            System.out.println("The song is already saved.");
            return false;
        }
      favoritSongs.add(favoritSong);
        return true;
    }

    public boolean updateSong(GeneralPlayList songs, GeneralPlayList newSong) {
        int foundPosition = findSongs(songs);
        if (foundPosition < 0) {
            System.out.println(songs.getSongName() + " could not find the song you wanted to update");
            return false;
        }
        this.generalSongList.set(foundPosition, newSong);
        System.out.println(songs.getSongName() + ", have been updated.");
        return true;
    }

    public boolean removeSongs(GeneralPlayList songs) {
        int foundPosition = findSongs(songs);
        if (foundPosition < 0) {
            System.out.println(songs.getSongName() + " could not find the song you wanted to remove");
            return false;
        }
        this.generalSongList.remove(foundPosition);
        System.out.println(songs.getSongName() + " have been removed from the playlist.");
        return true;
    }

    private int findSongs(GeneralPlayList songs) {
        return this.generalSongList.indexOf(songs);
    }

    private int findSongs(String songName) {
        for (int i = 0; i < this.generalSongList.size(); i++) {
            GeneralPlayList songs = this.generalSongList.get(i);
            if (songs.getSongName().equals(songName)) {
                return i;
            }
        }
        return -1;
    }

    public String searchSongs(GeneralPlayList songs) {
        if (findSongs(songs) >= 0) {
            return songs.getSongName();
        }
        return null;
    }

    //retunerar ett object GeneralPlayList
    public GeneralPlayList searchSongs(String songs) {
        int position = findSongs(songs);
        if (position >= 0) {
            return this.generalSongList.get(position);
        }
        return null;
    }

    /**
     * Alla Funktioner för SpecificPlaylist
     */

    //Lägger till inmatningen i arraylistan för SpecificPlayList.
    public boolean addNewSong(SpecificPlayList songs) {
        if (findSong(songs.getSongName()) >= 0) {
            System.out.println("The song is already saved.");
            return false;
        }
        specificPlayLists.add(songs);
        return true;
    }

    public boolean removeSong(SpecificPlayList songs) {
        int foundPosition = findSong(songs);
        if (foundPosition < 0) {
            System.out.println(songs.getSongName() + " could not find the song you wanted to remove");
            return false;
        }
        this.specificPlayLists.remove(foundPosition);
        System.out.println(songs.getSongName() + " have been removed from the playlist.");
        return true;
    }

    private int findSong(SpecificPlayList songs) {
        return this.specificPlayLists.indexOf(songs);
    }

    private int findSong(String songName) {
        for (int i = 0; i < this.specificPlayLists.size(); i++) {
            SpecificPlayList songs = this.specificPlayLists.get(i);
            if (songs.getSongName().equals(songName)) {
                return i;
            }
        }
        return -1;
    }

    public String searchSong(SpecificPlayList songs) {
        if (findSong(songs) >= 0) {
            return songs.getSongName();
        }
        return null;
    }

    //retunerar ett object (specificPlayList)
    public SpecificPlayList searchSong(String song) {
        int position = findSong(song);
        if (position >= 0) {
            return this.specificPlayLists.get(position);

        }
        return null;
    }

    /**
     * Skriver ut låtarna man har lagt till i arraylistan, beroende på om det är
     * super eller subklassen så körs de olika looparna.
     */

    public void printSongs() {
        System.out.println("Playlist: ");
        //Skriver ut lista över låtarna i från superklassen GeneralPlaylist
        for (int i = 0; i < generalSongList.size(); i++) {
            System.out.println((i + 1) + " " +
                    generalSongList.get(i).getSongName() + " : " +
                    generalSongList.get(i).getArtist());

        }
        //Skriver ut lista över låtarna i från subklassen specific playlist
        for (int i = 0; i < specificPlayLists.size(); i++) {
            System.out.println((i + 1) + " " +
                    specificPlayLists.get(i).getSongName() + " : " +
                    specificPlayLists.get(i).getArtist() + ", " +
                    specificPlayLists.get(i).getBmp() + ", " +
                    specificPlayLists.get(i).getGenre());

        }
    }

    public void printFavoritSongs(){
        System.out.println("Favorite songs: ");
        for (int i = 0; i < favoritSongs.size(); i++) {
            System.out.println((i + 1) + " " +
                    favoritSongs.get(i).getFavoritSong() + " : " +
                    favoritSongs.get(i).getFavoritArtist());
        }
    }
}
