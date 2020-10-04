package com.example.records;

public class FavoritSong  {

    private String favoritSong;
    private String favoritArtist;

    //kontstuktor för subklass
    public FavoritSong(String favoritSong, String favoritArtist) {
        this.favoritSong = favoritSong;
        this.favoritArtist = favoritArtist;
    }

    public String getFavoritArtist() {
        return favoritArtist;
    }

    public String getFavoritSong() {
        return favoritSong;
    }

    public static FavoritSong createFavoritSong(String favoritSong, String favoritArtist){
        return new FavoritSong(favoritArtist, favoritSong);
    }

}



