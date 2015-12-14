package com.anderson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class DataBaseGUI extends JFrame {
    private JPanel rootPanel = new JPanel();
    private Dimension d = new Dimension(350, 350);
    private JLabel title = new JLabel();
    private JList<String> songJList;
    private JButton quit = new JButton("Close");
    private JButton save = new JButton("Save list");
    private JButton regen = new JButton("Regenerate");
    private JLabel saveLabel = new JLabel();

    private JTextField saveNameTextBox = new JTextField();
    private JButton confirmSave = new JButton("Save!");

    private Database db = new Database();


    protected DataBaseGUI(ArrayList<String> songList){
      //  db.createDatabase();

        final String[] songArray = songList.toArray(new String[songList.size()]);
        songJList = new JList(songArray);

        rootPanel.setPreferredSize(d);
        setContentPane(rootPanel);
        setVisible(true);

        saveNameTextBox.setColumns(10);

        title.setText("Playlist Result:");
        rootPanel.add(title, BorderLayout.PAGE_START);
        rootPanel.add(songJList, BorderLayout.CENTER);
        rootPanel.add(quit, BorderLayout.LINE_END);
        rootPanel.add(save, BorderLayout.LINE_END);
        rootPanel.add(regen, BorderLayout.LINE_END);
        rootPanel.add(saveLabel, BorderLayout.SOUTH);
        rootPanel.add(saveNameTextBox, BorderLayout.SOUTH);
        rootPanel.add(confirmSave, BorderLayout.SOUTH);

        saveLabel.setVisible(false);
        saveNameTextBox.setVisible(false);
        confirmSave.setVisible(false);
        pack();

        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveLabel.setText("Please enter a name for this playlist");
                saveLabel.setVisible(true);
                saveNameTextBox.setVisible(true);
                confirmSave.setVisible(true);
            }
        });

        confirmSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String toDataBase = saveNameTextBox.getText();
                db.createAndFillTable(toDataBase, songArray);
            }
        });
    }
}
