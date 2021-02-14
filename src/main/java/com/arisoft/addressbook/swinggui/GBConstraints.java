package com.arisoft.addressbook.swinggui;

import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Created by Aritra Sengupta
 * on 2021-02-02.
 */
public class GBConstraints extends GridBagConstraints {
    public void init(){
        this.insets = new Insets(10, 10, 10, 10);
    }

    public void setGridX(int x){
        this.gridx = x;
    }

    public void setGridY(int y){
        this.gridy = y;
    }

    public void setGridWidth(int gridWidth){
        this.gridwidth = gridWidth;
    }

    public void setAnchor(int anchor){
        this.anchor = anchor;
    }
}
