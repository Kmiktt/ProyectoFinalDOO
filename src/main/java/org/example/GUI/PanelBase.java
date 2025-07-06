package org.example.GUI;

import org.example.Logica.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelBase extends JPanel {
    private PanelHabitat pSala;
    private PanelRefugio pRefugio;
    private PanelAcciones pAcciones;
    private PanelTienda pTienda;
    private ArrayList<JPanel> paneles;
    private Usuario user;
    private int index;
    public PanelBase(){
        super();
        user = Usuario.getInstance();
        user.recibirDinero(500);
        this.setLayout(new BorderLayout());
        pSala = new PanelHabitat("terrestre");
        pTienda = new PanelTienda();
        pRefugio = new PanelRefugio();
        pSala.setPreferredSize(new Dimension(500,300));
        paneles = new ArrayList<>();
        index=0;
        paneles.add(pSala);
        paneles.add(pRefugio);
        paneles.add(pTienda);
        this.add(pSala,BorderLayout.CENTER);
        pAcciones = new PanelAcciones(this);
        this.add(pAcciones,BorderLayout.SOUTH);
    }
    public void cambiarSala(){
        this.remove(paneles.get(index));
        index = (index + 1) % paneles.size();
        this.add(paneles.get(index), BorderLayout.CENTER);
        this.revalidate();
        this.repaint();

    }
}