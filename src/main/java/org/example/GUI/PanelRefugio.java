package org.example.GUI;

import org.example.Logica.Gato;
import org.example.Logica.Mascota;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelRefugio extends JPanel {
    private ArrayList<Mascota> mascotasLista;
    private ArrayList<Mascota> mascotasDisponibles;
    private JPanel panelContenido;
    public PanelRefugio(){
        super();
        mascotasLista = new ArrayList<>();
        mascotasDisponibles = new ArrayList<>();
        mascotasDisponibles.add(new Gato("Test","Test",0));
        this.setBorder(BorderFactory.createEmptyBorder(80,80,100,80));
        this.setBackground(new Color(100,100,255,255));
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JPanel panelVacio = new JPanel();
        panelVacio.setBackground(Color.LIGHT_GRAY);
        panelVacio.setBorder(BorderFactory.createLineBorder(Color.black));
        c.gridx = 0; // Primera columna
        c.gridy = 0; // Primera fila
        c.weightx = 0.5; // 30% del ancho
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH; // Expandir en ambas direcciones
        this.add(panelVacio, c);

        // Panel de contenido (70% del espacio)
        panelContenido = new JPanel();
        panelContenido.setBackground(Color.BLUE);
        panelContenido.setLayout(new GridLayout(2,2,10,10));
        c.gridx = 1;
        c.weightx = 0.5; // 70% del ancho
        this.add(panelContenido, c);
        updatear();

    }
    public void updatear(){
        while (!mascotasLista.isEmpty()) mascotasLista.removeFirst();
        panelContenido.removeAll();
        for (int i = 0; i<4; i++){
            Mascota base = (mascotasDisponibles.get((int) ((Math.random()*100)%mascotasDisponibles.size()))).clonar();
            base.felicidad = (int) (base.atri.getFelicidad() * Math.random());
            base.hambre = (int) (base.atri.getHambre() * Math.random());
            base.higiene = (int) (base.atri.getHigiene() * Math.random());
            base.salud = (int) (base.atri.getSalud() * Math.random());
            mascotasLista.add(base);
            panelContenido.add(new subPanelMasc_Ref(mascotasLista.get(i)));
        }
    }
}
