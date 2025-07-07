package org.example.GUI;

import org.example.Logica.ComidaGenerica;
import org.example.Logica.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelBase extends JPanel {
    private PanelHabitat pHabitat0;
    private PanelRefugio pRefugio;
    static private PanelAcciones pAcciones;
    private PanelTienda pTienda;
    private PanelDesbloqueable pDesbloqueable;
    private Usuario user;
    static private ArrayList<JPanel> paneles;
    static private int index;
    public PanelBase(){
        super();
        user = Usuario.getInstance();
        user.recibirDinero(500);
        user.agregarObjeto(new ComidaGenerica());
        this.setLayout(new BorderLayout());
        pHabitat0 = new PanelHabitat("terrestre");
        pTienda = new PanelTienda();
        pRefugio = new PanelRefugio();
        pDesbloqueable = new PanelDesbloqueable(this);
        paneles = new ArrayList<>();
        index=3;
        paneles.add(pRefugio);
        paneles.add(pTienda);
        paneles.add(pDesbloqueable);
        paneles.add(pHabitat0);
        this.add(pHabitat0,BorderLayout.CENTER);
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
    public void agregarPanel(JPanel p ){
        paneles.add(p);
    }
    static public void actualizarPanelAcciones(){
        pAcciones.actualizar();
    }
    static public void actualizarPanelActual(){
        JPanel p = paneles.get(index);
        if (p instanceof Refreshable) ((Refreshable) p).actualizar();
    }

    static JPanel getPanelActual(){
        return paneles.get(index);
    }
}