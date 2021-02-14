package com.arisoft.addressbook.swinggui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.EventQueue;

/**
 * Created by Aritra Sengupta
 * on 2021-01-29.
 */
public class Frame extends JFrame {
    public void init() {
        EventQueue.invokeLater(() -> {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE );
            pack();
            setLocationRelativeTo(null);    //center on screen
            setResizable(false);
            setVisible(true);
        });
    }
}