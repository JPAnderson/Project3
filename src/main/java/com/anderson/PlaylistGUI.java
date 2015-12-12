package com.anderson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Created by Jack on 12/7/2015.
 */
public class PlaylistGUI extends JFrame{
    private JPanel rootPanel;
    private JTextField playlistCountBox;
    private JComboBox genreComboBox;
    private JComboBox keySigComboBox;
    private JComboBox majorMinorComboBox;
 //   private JComboBox tempoComboBox;
 //   private JTextField yearTextBox;
 //   private JComboBox timePeriodComboBox;
    private JButton submitButton;
    private JButton clearFieldsButton;
    private JTextField tempoTextBox;

    private String userSongCount;
    private String userGenre;
    private String userKey;
    private String userMode;
    private String userTempo;
    private String userTimeCriteria;
 //   private String userYear;

 //   private int userYearInt;
    private int userSongCountInt;
    private float userTempoFloat;

    private PlaylistFinder plFinder;

    private String inputError = "Whole Numbers";


    private Dimension d = new Dimension(300, 350);

    protected PlaylistGUI(){

        setContentPane(rootPanel);
        rootPanel.setPreferredSize(d);
        pack();
        setVisible(true);

        //Populate combo boxes
        genreComboBox.addItem("Rock");
        genreComboBox.addItem("Jazz");
        genreComboBox.addItem("Pop");

        keySigComboBox.addItem("*any*");
        keySigComboBox.addItem("C");
        keySigComboBox.addItem("C#");
        keySigComboBox.addItem("D");
        keySigComboBox.addItem("D#");
        keySigComboBox.addItem("E");
        keySigComboBox.addItem("F");
        keySigComboBox.addItem("F#");
        keySigComboBox.addItem("G");
        keySigComboBox.addItem("G#");
        keySigComboBox.addItem("A");
        keySigComboBox.addItem("A#");
        keySigComboBox.addItem("B");

        majorMinorComboBox.addItem("*any*");
        majorMinorComboBox.addItem("Major");
        majorMinorComboBox.addItem("Minor");




        submitButton.addActionListener(new ActionListener() {
           // @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        clearFieldsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playlistCountBox.setText("");
            }
        });

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userSongCount = playlistCountBox.getText();
                userTempo = tempoTextBox.getText();
                userGenre = (String)genreComboBox.getSelectedItem();
                userKey = (String)keySigComboBox.getSelectedItem();
                userMode = (String)majorMinorComboBox.getSelectedItem();


                try {
                    userSongCountInt = Integer.parseInt(userSongCount);
                } catch(NumberFormatException nfe){
                    playlistCountBox.setText(inputError);
                }


                try{
                    userTempoFloat = Float.parseFloat(userTempo);
                }catch(NumberFormatException nfe){
                    tempoTextBox.setText(inputError);
                }

                try {
                    plFinder = new PlaylistFinder(userSongCountInt, userGenre, userKey, userMode, userTempoFloat);
                    plFinder.createdPlayList();

                }catch(IOException ioe){
                    System.out.println("Something was wrong with IO");
                    System.out.println(ioe.getCause());
                }





            }
        });

    }

}

//minneapolis edu simpleCardLayout
