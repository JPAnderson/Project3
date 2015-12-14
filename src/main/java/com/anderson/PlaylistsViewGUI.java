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
    private Database db = new Database();
    private JList<String> songJList;

    private Dimension d = new Dimension(350, 400);


    protected PlaylistsViewGUI(){

        setContentPane(rootPanel);
        rootPanel.setPreferredSize(d);
        songJList.setVisible(false);
        pack();
        setVisible(true);

        playlistSearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] toJlist = db.retrievePlaylist(textField1.getText());
                songJList = new JList<String>(toJlist);
                rootPanel.add(songJList);
                songJList.setVisible(true);
                pack();

            }
        });
    }
}
