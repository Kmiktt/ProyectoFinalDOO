package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonVel extends JButton{
    public ButtonVel(String s){
        super(s);
        this.setBorder(BorderFactory.createLineBorder(Color.CYAN,3));
        this.setFocusPainted(false);
    }
    @Override
    public String toString(){
        return (this.getUIClassID()+" - "+this.getText());
    }
}

