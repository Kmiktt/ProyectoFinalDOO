package org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class PanelBase extends JPanel {
    private PanelSalaActual pSala;
    private PanelAcciones pAcciones;
    public PanelBase(){
        super();
        this.setLayout(new BorderLayout());
        pSala = new PanelSalaActual();
        pSala.setPreferredSize(new Dimension(500,300));
        this.add(pSala,BorderLayout.CENTER);
        pAcciones = new PanelAcciones();
        this.add(pAcciones,BorderLayout.SOUTH);
    }
}