package org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class PanelAcciones extends JPanel {
    private JPanel pVelocidad;
    private JPanel pInvententario;
    private JPanel pMapa;
    public PanelAcciones(){
        super();
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
        this.setLayout(new GridLayout(1,3,100,0));
        pVelocidad = new PanelVelocidad();
        this.add(pVelocidad);
        pInvententario = new PanelInventario();
        this.add(pInvententario);
        pMapa = new JPanel();
        pMapa.setBorder(BorderFactory.createLineBorder(Color.MAGENTA,2));
        pMapa.setLayout(new GridBagLayout());
        this.add(pMapa);
        JButton mapa = new JButton("Revisar Mapa");
        mapa.setFont(new Font("Comic Sans MS",Font.PLAIN,16));
        mapa.setPreferredSize(new Dimension(250,50));
        pMapa.add(mapa);
    }
}
