package com.arisoft.addressbook.swinggui;

import javax.swing.JButton;
import java.awt.event.ActionListener;

/**
 * Created by Aritra Sengupta
 * on 2021-01-29.
 */
public class Button extends JButton {
    public Button(ActionListener actionListener){
        this.addActionListener(actionListener);
    }
}
