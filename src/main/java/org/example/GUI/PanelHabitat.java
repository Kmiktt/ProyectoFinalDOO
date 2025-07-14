package org.example.GUI;

import org.example.Logica.Mascotas.*;
import org.example.Logica.Habitat;
import org.example.Logica.Mascotas.Mascota;
import org.example.Logica.TomaMascota;
import org.example.Logica.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**JPanel encargado de mostrar a todas las mascotas que residen en el habitat, y permitirte interactuar con ellas*/
public class PanelHabitat extends JPanel implements Refreshable, TimeUpdatable, TomaMascota {
    private final Habitat habitat;
    private ArrayList<subPanelMasc_Hab> subPanels;
    public PanelHabitat(String tipo){
        super();
        habitat = new Habitat(tipo);
        this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(80,80,120,80),null));
        this.setLayout(new GridLayout(2,3,30,20));
        crearPaneles();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(new ImageIcon("src/main/resources/fondohabitat"+habitat.getTipo()+".jpg").getImage(),0,0,null);
    }
    /**Metodo que crea los distintos paneles de mascota, utilizado tambien a la hora de modificar la cantidad de mascotas
     * del habitat para evitar que ocurran excepciones por punteros apuntando a mascotas inexistentes
     * Los paneles que crean son de la clase subPanelMasc_Hab*/
    private void crearPaneles(){
        this.removeAll();
        subPanels = new ArrayList<>();
        for (int i = 0; i<6; i++){
            if(habitat.size()>i) {
                subPanelMasc_Hab p = new subPanelMasc_Hab(this, i); this.add(p); subPanels.add(p);}
            else {this.add(PanelCreator.Vacio.crear());}
        }
    }
    /**Le entrega una mascota al usuario, y la quita del habitat
     * @param index La posición de la mascota que se le entrega al usuario*/
    public void quitarMascota(int index){
        if (Usuario.getInstance().getMascota()==null){
            Mascota m = habitat.darMascota(index);
            Usuario.getInstance().tomarMascota(m);
            crearPaneles();
        }
        PanelBase.actualizarPanelAcciones();
        actualizar();
    }
    public Habitat getHabitat(){return habitat;}

    public void actualizar() {
        subPanels.forEach(subPanelMasc_Hab::actualizar);
        revalidate();
        repaint();
    }

    public void timeUpdate() {
        for (int i=0; i<habitat.size(); i++){
            habitat.getMascota(i).update();
        }
        actualizar();
    }
    /**Agrega una mascota al habitat y actualiza los paneles usando crearPaneles()
     * @param ma Mascota que agregar al habitat
     * @return null, pues al recibir la mascota, quien entrego la mascota se queda sin ella*/
    public Mascota agregarMascota(Mascota ma) {
        ma.ubicacion=habitat;
        habitat.agregarMascota(ma);
        crearPaneles();
        actualizar();
        return null;
    }
}

