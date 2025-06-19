package org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class PanelInventario extends JPanel {
    private JButton invent;
    public PanelInventario(){
        super();
        ImageIcon icon = new ImageIcon("src/main/resources/iconInventario.png");
        Image img = icon.getImage();
        Image newimg =  img.getScaledInstance(img.getWidth(null)/2,img.getHeight(null)/2, Image.SCALE_SMOOTH);
        invent = new JButton(new ImageIcon(newimg));
        invent.addActionListener(new InventarioListener());
        this.setBorder(BorderFactory.createLineBorder(Color.orange,2));
        this.add(invent);

    }
}