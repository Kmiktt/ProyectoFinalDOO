package org.example.GUI;

import org.example.Logica.Consumibles.*;
import org.example.Logica.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**El panel encargado de almacenar todos los paneles que se
 * ven en pantalla y en actualizar a todos los paneles cuando es necesario.
 * Tambien es capaz de añadir nuevos paneles para simular que se está expandiendo
 * la tienda*/
public class PanelBase extends JPanel {
    static private PanelAcciones pAcciones;
    static private ArrayList<JPanel> paneles;
    static private int index;
    private final Timer t;
    public PanelBase(){
        super();
        Usuario user = Usuario.getInstance();
        user.recibirDinero(2000);
        user.agregarObjeto(new ComidaGenerica());
        user.agregarObjeto(new Krill());
        user.agregarObjeto(new Medicina());
        user.agregarObjeto(new Pescado());
        user.agregarObjeto(new Carne());
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
    /**Metodo encargado de rotar entre las distintas salas disponibles, volviendo al inicio cuando llega al final
     * de la lista*/
    public void cambiarSala(){
        this.remove(paneles.get(index));
        index = (index + 1) % paneles.size();
        this.add(paneles.get(index), BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
        actualizarPanelActual();
    }
    /**Metodo para añadir paneles a la seleccion que hay disponible
     * @param p Panel que se añade a la tienda*/
    public void agregarPanel(JPanel p ){
        paneles.add(p);
    }
    /**Metodo estatico que actualiza los datos y la información visual
     * del panel de acciones, para cuando las acciones del panel principal
     * afectan a este*/
    static public void actualizarPanelAcciones(){
        pAcciones.actualizar();
    }
    /**Metodo estatico que actualiza los datos y la información visual
     * del panel superior, utilizado para cuando las acciones del panel
     * de acciones afectan al panel principal*/
    static public void actualizarPanelActual(){
        if (paneles.get(index) instanceof Refreshable) ((Refreshable)paneles.get(index)).actualizar();
    }
    /**Devuelve el panel actual, util para identificar si un panel implementa una interfaz en particular
     * @return JPanel que se encuentra como panel principal*/
    static JPanel getPanelActual(){
        return paneles.get(index);
    }
    /**Metodo encargado de lanzar actualizaciones de tiempo, tiene un
     * timer asociado que llama a este metodo y actualiza a todos los
     * paneles necesarios, ademas de modificar su duracion de acuerdo a
     * la velocidad actual*/
    public void timeUpdate(){
        for (JPanel p: paneles){
            if (p instanceof TimeUpdatable) {
                ((TimeUpdatable) p).timeUpdate();
            }
        }
        t.setDelay(10000/Usuario.getInstance().velocidad);
    }
}