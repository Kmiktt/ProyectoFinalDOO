package org.example.GUI;

import org.example.Logica.Gato;
import org.example.Logica.Mascota;
import org.example.Logica.Refugio;
import org.example.Logica.Usuario;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelRefugio extends JPanel implements Refreshable,TimeUpdatable{
    private JPanel panelContenido;
    private Refugio refugio;
    public boolean disponible;
    public PanelRefugio(){
        super();
        refugio = new Refugio();
        refugio.actualizarAnimales();
        refugio.actualizarStock(4);
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
        updatearVisual();

    }
    public void updatearVisual(){
        panelContenido.removeAll();
        for (int i = 0; i<4; i++){
            if(refugio.getStock().size()<=i){
                panelContenido.add(PanelCreator.Vacio.crear());
                continue;
            }
            Mascota m = refugio.getStock().get(i);
            panelContenido.add(new subPanelMasc_Ref(m,i,this));
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        disponible= Usuario.getInstance().getMascota()==null;
    }

    public void adoptarMascota(String nombre,int index){
        refugio.adoptarAnimal(index, nombre);
        actualizar();
    }

    public void actualizarStock(){
        refugio.actualizarStock(4);
        actualizar();
    }

    public void actualizar() {
        updatearVisual();
        revalidate();
        repaint();
        PanelBase.actualizarPanelAcciones();
    }

    public void timeUpdate() {
        actualizarStock();
    }
}
