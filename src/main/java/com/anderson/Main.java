package com.anderson;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        //Setting the look and feel to Windows
        //must be called before instantiating the GUI

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
            System.out.println("Look and feel not supported!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found exception!");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("Instantiation exception!");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("Illegal access!");
            e.printStackTrace();
        }
        //Create the GUI
        PlaylistGUI GUI = new PlaylistGUI();

    }



   // public void
}

