package com.arisoft.addressbook.swinggui;

import com.arisoft.addressbook.model.AddressBook;
import com.arisoft.addressbook.model.BuddyInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Aritra Sengupta
 * on 2021-01-29.
 */
public class ButtonActionListener implements ActionListener {
    private final JTextField buddyNameTextField;
    private final JTextField buddyPhoneTextField;
    private final AddressBook addressBook;

    public ButtonActionListener(JTextField buddyNameTextField, JTextField buddyPhoneTextField, AddressBook addressBook){
        this.buddyNameTextField =  buddyNameTextField;
        this.buddyPhoneTextField = buddyPhoneTextField;
        this.addressBook = addressBook;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BuddyInfo buddyInfo = new BuddyInfo(buddyNameTextField.getText(),
                buddyPhoneTextField.getText());
        System.out.println("Button Clicked");
        System.out.println(buddyInfo);
        this.addressBook.addBuddy(buddyInfo);
        System.out.println(addressBook);
    }
}
