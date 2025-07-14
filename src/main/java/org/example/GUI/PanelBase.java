package org.example.GUI;

import org.example.Logica.Consumibles.*;
import org.example.Logica.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelBase extends JPanel {
    static private PanelAcciones pAcciones;
    static private ArrayList<JPanel> paneles;
    static private int index;
    private final Timer t;
    public PanelBase(){
        super();
        Usuario user = Usuario.getInstance();
        user.recibirDinero(500);
        user.agregarObjeto(new ComidaGenerica());
        user.agregarObjeto(new Krill());
        this.setLayout(new BorderLayout());
        PanelHabitat pHabitat0 = new PanelHabitat("terrestre");
        PanelTienda pTienda = new PanelTienda();
        PanelRefugio pRefugio = new PanelRefugio();
        PanelDesbloqueable pDesbloqueable = new PanelDesbloqueable(this);
        PanelComprador pComprador = new PanelComprador();
        paneles = new ArrayList<>();
        index=4;
        paneles.add(pRefugio);
        paneles.add(pTienda);
        paneles.add(pComprador);
        paneles.add(pDesbloqueable);
        paneles.add(pHabitat0);
        this.add(pHabitat0,BorderLayout.CENTER);
        pAcciones = new PanelAcciones(this);
        this.add(pAcciones,BorderLayout.SOUTH);
        t = new Timer(10000/Usuario.getInstance().velocidad,_->timeUpdate());
        t.start();
    }
    public void cambiarSala(){
        this.remove(paneles.get(index));
        index = (index + 1) % paneles.size();
        this.add(paneles.get(index), BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
        actualizarPanelActual();
    }
    public void agregarPanel(JPanel p ){
        paneles.add(p);
    }
    static public void actualizarPanelAcciones(){
        pAcciones.actualizar();
    }
    static public void actualizarPanelActual(){
        if (paneles.get(index) instanceof Refreshable) ((Refreshable)paneles.get(index)).actualizar();
    }

    static JPanel getPanelActual(){
        return paneles.get(index);
    }
    public void timeUpdate(){
        for (JPanel p: paneles){
            if (p instanceof TimeUpdatable) {
                ((TimeUpdatable) p).timeUpdate();
            }
        }
        t.setDelay(10000/Usuario.getInstance().velocidad);
    }
}