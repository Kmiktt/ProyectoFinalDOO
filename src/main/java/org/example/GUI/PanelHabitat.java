package org.example.GUI;

import org.example.Logica.Gato;
import org.example.Logica.Mascota;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class PanelHabitat extends JPanel {
    ArrayList<Mascota> mascotasDeHabitat;
    public PanelHabitat(){
        super();
        this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(80,80,120,80),null));
        this.setLayout(new GridLayout(2,3,30,20));
        mascotasDeHabitat = new ArrayList<>();
        Mascota m = new Gato("Kevin", "Aqui",0);
        mascotasDeHabitat.add(m);
        mascotasDeHabitat.add(m);
        Mascota m2 = new Gato("Kevin2", "Aqui",0);
        m2.hambre=3;
        m2.felicidad=10;
        m2.salud=0;
        Mascota m3 = new Gato("Kevin3", "Aca",0);
        m3.felicidad=50;
        m3.hambre=40;
        mascotasDeHabitat.add(m2);
        mascotasDeHabitat.add(m3);
        for (int i = 0; i<6; i++){
            if(mascotasDeHabitat.size()>i) {PMascInHabitat p = new PMascInHabitat(mascotasDeHabitat.get(i)); this.add(p);}
            else {this.add(PanelCreator.Vacio.crear());}
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(new ImageIcon("src/main/resources/fondotest.jpg").getImage(),0,0,null);
    }
    public void quitarMascota(int index){
        Mascota m = mascotasDeHabitat.get(index);
        mascotasDeHabitat.remove(index);
        this.remove(index);
        this.add(PanelCreator.Vacio.crear());
    }
    public void addMascota(Mascota m){
        m.ubicacion=this;
        for (int i = mascotasDeHabitat.size(); i<6; i++){this.remove(i);}
        mascotasDeHabitat.add(m);
        this.add(new PMascInHabitat(m));
        for (int i = mascotasDeHabitat.size(); i<6; i++){this.add(PanelCreator.Vacio.crear());}
    }
}

