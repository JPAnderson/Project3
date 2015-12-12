package com.anderson;

import com.echonest.api.v4.*;

import java.io.IOException;
//TODO add echonest libraries to github

/**
 * Created by Jack on 12/7/2015.
 */

public class PlaylistFinder {
    private String genre;
    private String keySIgnature;
    private String mode;
    private float tempo;
    private String yearComparator;
    private int playlistLength;
    private int year;

    private float ECtempo;
    private String ECgenre;
    private int ECmode;
    private int ECkey;




    public PlaylistFinder(int songs, String genre, String key, String mode, float tempo){
        this.playlistLength = songs;
        this.genre = genre;
        this.keySIgnature = key;
        this.mode = mode;
        this.tempo = tempo;


        translateEntriesToNumbers(this.tempo, this.keySIgnature, this.mode, this.genre);
    }

    public void translateEntriesToNumbers(float tempo, String key, String mode, String genre){

        if(mode.equals("Minor")){
            this.ECmode = 0;
        }else {
            this.ECmode = 1;
        }

        if(key.equals("C")){
            this.ECkey = 0;
        }
        else if(key.equals("C#")){
            this.ECkey = 1;
        }
        else if(key.equals("D")){
            this.ECkey = 2;
        }
        else if(key.equals("D#")){
            this.ECkey = 3;
        }
        else if(key.equals("E")){
            this.ECkey = 4;
        }
        else if(key.equals("F")){
            this.ECkey = 5;
        }
        else if(key.equals("F#")){
            this.ECkey = 6;
        }
        else if(key.equals("G")){
            this.ECkey = 7;
        }
        else if(key.equals("G#")){
            this.ECkey = 8;
        }
        else if(key.equals("A")){
            this.ECkey = 9;
        }
        else if(key.equals("A#")){
            this.ECkey = 10;
        }
        else if(key.equals("B")){
            this.ECkey = 11;
        }

        this.ECtempo = tempo;

        this.ECgenre = genre;


    }

    public void createdPlayList() throws IOException{
        try{
            EchoNestAPI API = new EchoNestAPI("SEFRW8AEZGLGAWCA3");

            DynamicPlaylistParams playListParams = new DynamicPlaylistParams();
            playListParams.setType(PlaylistParams.PlaylistType.CATALOG_RADIO);
            playListParams.setMode(this.ECmode);
            playListParams.setKey(this.ECkey);
            playListParams.setMinTempo(this.ECtempo);
        //    playListParams.addStyle(this.ECgenre);
  //          playListParams.setResults(this.playlistLength);



            Playlist playlist = API.createDynamicPlaylist(playListParams);



            for(Song song : playlist.getSongs()){
                System.out.println(song.toString());
            }

        } catch(EchoNestException ene){
            System.out.println("Something's wrong with echonest");
            System.out.println(ene.getCause());
            ene.printStackTrace();
        }
    }




//    //Test code to link to echoNest
//    //Not staying, but does work
//    //                  lie ^
//    public void showList(){
//        try{
//            EchoNestAPI en = new EchoNestAPI("SEFRW8AEZGLGAWCA3");
//            BasicPlaylistParams params = new BasicPlaylistParams();
//            params.addArtist("Weezer");
//            params.setType(BasicPlaylistParams.PlaylistType.ARTIST_RADIO);
//            params.setResults(10);
//            Playlist playlist = en.createBasicPlaylist(params);
//
//            for (Song song : playlist.getSongs()) {
//                System.out.println(song.toString());
//            }
//        }catch(EchoNestException ENE){
//            System.out.println("something went wrong with echonest!");
//        }
//    }
}

