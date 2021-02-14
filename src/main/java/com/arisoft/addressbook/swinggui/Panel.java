package com.arisoft.addressbook.swinggui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Map;

import javax.swing.*;

/**
 * Created by Aritra Sengupta
 * on 2021-02-02.
 */

class Panel extends JPanel {

    public Panel(Map<Component, GridBagConstraints>
                         componentGridBagConstraintsHashMap) {

        setLayout(new GridBagLayout());

        // add all components using GridBagLayout
        componentGridBagConstraintsHashMap.forEach(this::add);

        // set panel border
        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Add BuddyInfo"));
    }
}