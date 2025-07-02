package org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class PanelInventario extends JPanel {
    private JButton invent;
    public PanelInventario(){
        super();
        PanelCreator.BaseAcc.update(this);
        invent = new JButton(new ImageIcon("src/main/resources/iconInventario.png"));
        invent.addActionListener(new InventarioListener());
        invent.setBackground(new Color(79,39,11));
        invent.setFocusPainted(false);
        this.add(invent);

    }
}