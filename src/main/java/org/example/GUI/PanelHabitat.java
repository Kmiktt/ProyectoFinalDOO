package org.example.GUI;

import org.example.Logica.Gato;
import org.example.Logica.Habitat;
import org.example.Logica.Mascota;
import org.example.Logica.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PanelHabitat extends JPanel {
    private Habitat habitat;
    public PanelHabitat(String tipo){
        super();
        habitat = new Habitat(tipo);
        this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(80,80,120,80),null));
        this.setLayout(new GridLayout(2,3,30,20));
        Mascota m = new Gato("Kevin",0);
        habitat.agregarMascota(m);
        Mascota m2 = new Gato("Kevin2",0);
        m2.hambre=3;
        m2.felicidad=10;
        m2.salud=0;
        Mascota m3 = new Gato("Kevin3",0);
        m3.felicidad=50;
        m3.hambre=40;
        habitat.agregarMascota(m2);
        habitat.agregarMascota(m3);
        for (int i = 0; i<6; i++){
            if(habitat.size()>i) {PMascInHabitat p = new PMascInHabitat(this, i); this.add(p);}
            else {this.add(PanelCreator.Vacio.crear());}
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(new ImageIcon("src/main/resources/fondotest.jpg").getImage(),0,0,null);
        PanelInventario.actualizarDatos();
    }
    public void quitarMascota(int index){
        if (Usuario.getInstance().getMascota()==null){
            Mascota m = habitat.darMascota(index);
            this.remove(index);
            this.add(PanelCreator.Vacio.crear());
            Usuario.getInstance().tomarMascota(m);
        }
        revalidate();
        repaint();
    }
    public void addMascota(Mascota m){
        m.ubicacion=habitat;
        for (int i = habitat.size(); i<6; i++){this.remove(i);}
        habitat.agregarMascota(m);
        this.add(new PMascInHabitat(this, habitat.size()-1));
        for (int i = habitat.size(); i<6; i++){this.add(PanelCreator.Vacio.crear());}
    }
    public Habitat getHabitat(){return habitat;}
}

