package org.example.GUI;

import javax.swing.*;

public class Ventana extends JFrame {
    Ventana(){
        super();
        this.setSize(1600,900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Programa de Mascotas");
        this.setResizable(false);
        PanelBase pb = new PanelBase();
        this.add(pb); //se agrega al sur
        this.setVisible(true);
    }
}