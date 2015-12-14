package com.anderson;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jack on 12/14/2015.
 */
public class Database {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/";
    private static String DB_NAME = "songDB";
    static final String USER = "root";
    static final String PASSWORD = "team13";
    static Statement statement = null;
    static Connection connection = null;
     ResultSet resultSet = null;

    public static void createDatabase(){
        try {
            try{
                String Driver = "com.mysql.jdbc.Driver";
                Class.forName(Driver);
            } catch (ClassNotFoundException cnfe){
                System.out.println("Drivers not found. Exit");
                System.exit(-1);
            }
//            String createDatabase = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
//            statement.executeUpdate(createDatabase);

            connection = DriverManager.getConnection(DATABASE_URL + DB_NAME, USER, PASSWORD);
            statement = connection.createStatement();

            // create database
         //   String createDatabase = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
         //   statement.executeUpdate(createDatabase);

            System.out.println("Database created");

        } catch (SQLException sqle){
            sqle.printStackTrace();

        }
    }

    public static void createAndFillTable(String tableName, String[] songArray){

        try {
            ArrayList<String> songArrayList = new ArrayList<String>(Arrays.asList(songArray));
            String tableUpdate;

            String createPlaylistTable = "CREATE TABLE " + tableName + " (song varchar(40))";
            statement.executeUpdate(createPlaylistTable);

            for(String song : songArrayList){
                tableUpdate = "INSERT INTO " + tableName + " VALUE ('" + song + "')";
                statement.executeUpdate(tableUpdate);
                System.out.println(song + " inserted into " + tableName);
            }

        } catch (Exception e){
            System.out.println(e);
        }
    }

    public String[] retrievePlaylist(String plName){
        ArrayList<String> retrievePL = new ArrayList<String>();

        try{
            String search = "SELECT * FROM " + plName;
            resultSet = statement.executeQuery(search);

            while(resultSet.next()){
                String songToAdd = resultSet.getString(0);
                System.out.println(songToAdd);
                retrievePL.add(songToAdd);
            }
            String[] arrayPL = retrievePL.toArray(new String[retrievePL.size()]);
            return arrayPL;



        }catch(SQLException e){
            System.out.println("Something stupid went wrong");
            String[] errorArray = {"ERROR"};
            return errorArray;
        }
    }
}
