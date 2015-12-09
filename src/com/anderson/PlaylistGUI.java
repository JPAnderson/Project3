package com.anderson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Jack on 12/7/2015.
 */
public class PlaylistGUI extends JFrame{
    private JPanel rootPanel;
    private JTextField playlistCountBox;
    private JComboBox genreComboBox;
    private JComboBox keySigComboBox;
    private JComboBox majorMinorComboBox;
    private JComboBox tempoComboBox;
    private JTextField yearTextBox;
    private JComboBox timePeriodComboBox;
    private JButton submitButton;
    private JButton clearFieldsButton;

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

        tempoComboBox.addItem("*any*");
        tempoComboBox.addItem("Slow");
        tempoComboBox.addItem("Medium");
        tempoComboBox.addItem("Fast");

        timePeriodComboBox.addItem("*any*");
        timePeriodComboBox.addItem("Before");
        timePeriodComboBox.addItem("During");
        timePeriodComboBox.addItem("After");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

}
