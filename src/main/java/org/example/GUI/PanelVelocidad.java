package org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class PanelVelocidad extends JPanel {
    private JButton v1;
    private JButton v2;
    private JButton v4;
    private JButton v8;
    public PanelVelocidad(){
        super();
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.red,2));
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new GridBagLayout());
        JLabel titulo = new JLabel("Elegir Velocidad de Juego");
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN,20));
        JPanel panelDeBotones = new JPanel();
        panelDeBotones.setLayout(new GridLayout(2,2,30,10));
        panelDeBotones.setBorder(BorderFactory.createLineBorder(Color.blue,2));
        this.add(panelDeBotones,BorderLayout.CENTER);
        this.add(panelTitulo,BorderLayout.NORTH);
        panelTitulo.add(titulo);
        v1 = new ButtonVel("x1");
        panelDeBotones.add(v1);
        v2 = new ButtonVel("x2");
        panelDeBotones.add(v2);
        v4 = new ButtonVel("x4");
        panelDeBotones.add(v4);
        v8 = new ButtonVel("x8");
        panelDeBotones.add(v8);
    }
}