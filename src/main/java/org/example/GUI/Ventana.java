package org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    private PanelBase pb;
    Ventana(){
        super();
        this.setSize(1600,900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Programa de Mascotas");
        this.setResizable(false);
        pb=new PanelBase();
        this.add(pb); //se agrega al sur
        this.setVisible(true);
    }
}