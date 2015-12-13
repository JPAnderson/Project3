package com.anderson;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class DataBaseGUI extends JFrame {
    private JPanel rootPanel = new JPanel();
    private Dimension d = new Dimension(300, 300);
    private JLabel title = new JLabel();
    private JList<String> songJList;




    protected DataBaseGUI(ArrayList<String> songList){
        String[] songArray = songList.toArray(new String[songList.size()]);
        songJList = new JList(songArray);

        rootPanel.setPreferredSize(d);
        setContentPane(rootPanel);
        setVisible(true);

        title.setText("Playlist Result:");
        rootPanel.add(title, BorderLayout.NORTH);
        rootPanel.add(songJList, BorderLayout.NORTH);



        pack();
    }
}
