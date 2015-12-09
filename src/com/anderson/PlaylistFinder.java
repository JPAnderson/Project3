package com.anderson;

import com.echonest.api.v4.*;

/**
 * Created by Jack on 12/7/2015.
 */

public class PlaylistFinder {
    private String genre;
    private String keySIgnature;
    private String mode;
    private String tempo;
    private String yearComparator;
    private int playlistLength;
    private int year;

    //Overloaded constructors for ever possible entry
    public PlaylistFinder(){

    }

    public PlaylistFinder(String genre){
        this.genre = genre;
    }

    public PlaylistFinder(String genre, String keySig){
        this.genre = genre;
        this.keySIgnature = keySig;
    }

    public PlaylistFinder(String genre, String keySig, String mode){
        this.genre = genre;
        this.keySIgnature = keySig;
        this.mode = mode;
    }

    public PlaylistFinder(String genre, String keySig, String mode, String tempo){
        this.genre = genre;
        this.keySIgnature = keySig;
        this.mode = mode;
        this.tempo = tempo;
    }

    public PlaylistFinder(String genre, String keySig, String mode, String tempo, String yearComp){
        this.genre = genre;
        this.keySIgnature = keySig;
        this.mode = mode;
        this.tempo = tempo;
        this.yearComparator = yearComp;
    }

    public PlaylistFinder(String genre, String keySig, String mode, String tempo, String yearComp, int listLength){
        this.genre = genre;
        this.keySIgnature = keySig;
        this.mode = mode;
        this.tempo = tempo;
        this.yearComparator = yearComp;
        this.playlistLength = listLength;
    }

    public PlaylistFinder(String genre, String keySig, String mode, String tempo, String yearComp, int listLength, int year){
        this.genre = genre;
        this.keySIgnature = keySig;
        this.mode = mode;
        this.tempo = tempo;
        this.yearComparator = yearComp;
        this.playlistLength = listLength;
        this.year = year;


    }

    //Test code to link to echoNest
    //Not staying, but does work
    public void showList(){
        try{
            EchoNestAPI en = new EchoNestAPI("SEFRW8AEZGLGAWCA3");
            BasicPlaylistParams params = new BasicPlaylistParams();
            params.addArtist("Weezer");
            params.setType(BasicPlaylistParams.PlaylistType.ARTIST_RADIO);
            params.setResults(10);
            Playlist playlist = en.createBasicPlaylist(params);

            for (Song song : playlist.getSongs()) {
                System.out.println(song.toString());
            }
        }catch(EchoNestException ENE){
            System.out.println("something went wrong with echonest!");
        }
    }
}

