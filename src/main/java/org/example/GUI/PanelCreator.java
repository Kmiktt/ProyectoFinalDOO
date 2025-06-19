package org.example.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public enum PanelCreator {
    VelTitle(new GridBagLayout(), new Color(224, 198, 99,125), null),
    Acciones(new GridLayout(1,3,100,0),null,(BorderFactory.createLineBorder(Color.BLUE,2))),
    VelBotones(new GridLayout(2,2,30,10),new Color(0,0,0,0),BorderFactory.createLineBorder(new Color(0,0,0,0),5));
    private JPanel panel;
    private LayoutManager layout;
    private Color bgColor;
    private Border bord;
    PanelCreator(LayoutManager Layout, Color bg, Border border){
        panel = new JPanel();
        panel.setLayout(Layout);
        panel.setBackground(bg);
        panel.setBorder(border);
        layout = Layout;
        bgColor = bg;
    }
    public void update(JPanel p){
        p.setLayout(layout);
        p.setBackground(bgColor);
        p.setBorder(bord);
    }
    public JPanel crear(){
        return panel;
    }
}
