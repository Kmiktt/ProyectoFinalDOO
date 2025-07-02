package org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class PanelAcciones extends JPanel {
    private JPanel pVelocidad;
    private JPanel pInvententario;
    private JPanel pMapa;
    public PanelAcciones(){
        super();
        PanelCreator.Acciones.update(this);
        pVelocidad = new PanelVelocidad();
        this.add(pVelocidad);
        pInvententario = new PanelInventario();
        this.add(pInvententario);

        pMapa = PanelCreator.PanMap.crear();
        this.add(pMapa);
        JButton mapa = new JButton("Revisar Mapa");
        mapa.setFont(new Font("Comic Sans MS",Font.PLAIN,16));
        mapa.setPreferredSize(new Dimension(250,50));
        pMapa.add(mapa);
    }
}
