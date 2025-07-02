package org.example.GUI;

import org.example.Logica.Gato;
import org.example.Logica.Mascota;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class PanelSalaActual extends JPanel {
    ArrayList<Mascota> mascotasDeHabitat;
    public PanelSalaActual(){
        super();
        this.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(80,80,120,80),BorderFactory.createLineBorder(Color.orange)));
        this.setLayout(new GridLayout(2,3,30,20));
        mascotasDeHabitat = new ArrayList<Mascota>();
        Mascota m = new Gato("Kevin", "Aqui",0);
        mascotasDeHabitat.add(m);
        mascotasDeHabitat.add(m);
        mascotasDeHabitat.add(m);
        mascotasDeHabitat.add(m);



        for (int i = 0; i<6; i++){
            if(mascotasDeHabitat.size()>i) {PMascInHabitat p = new PMascInHabitat(mascotasDeHabitat.get(i)); this.add(p);}
            else {JPanel p = new JPanel(); this.add(p);}
        }
    }
}

