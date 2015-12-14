package com.anderson;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jack on 12/14/2015.
 */
public class PlaylistsViewGUI extends JFrame {
    private JPanel rootPanel;
    private JTextField textField1;
    private JButton playlistSearchButton;

    private Dimension d = new Dimension(350, 400);


    protected PlaylistsViewGUI(){

        setContentPane(rootPanel);
        rootPanel.setPreferredSize(d);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        playlistSearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
