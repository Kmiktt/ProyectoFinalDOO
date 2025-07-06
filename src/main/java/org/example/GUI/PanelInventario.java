package org.example.GUI;

import org.example.Logica.Mascota;

import javax.swing.*;
import java.awt.*;

public class PanelInventario extends JPanel {
    private JButton invent;
    private static Mascota mascotaAlmacenada;
    public PanelInventario(){
        super();
        mascotaAlmacenada = null;
        PanelCreator.BaseAcc.update(this);
        JPanel test = new JPanel(new GridBagLayout());
        test.setBackground(new Color(79,39,11));
        GridBagConstraints gbc = new GridBagConstraints();
        for (int i = 0; i < 2; i++){
            gbc.gridx = i;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            test.add(new JLabel("",new ImageIcon("src/main/resources/arrow0.png"),SwingConstants.CENTER),gbc);
            JPanel espacio = new JPanel();
            gbc.gridy = 1;
            espacio.setPreferredSize(new Dimension(100, 80)); // Ancho = tamaño del JFrame, alto = 80px
            espacio.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80)); // Limitar su tamaño máximo de alto
            espacio.setBackground(Color.LIGHT_GRAY); // (Opcional) Color para visualizar el espacio
            JButton botonCheckearMascota = new JButton("Checkear");
            botonCheckearMascota.addActionListener(e -> checkearMascota());
            espacio.add(botonCheckearMascota);
            test.add(espacio,gbc);
            gbc.gridy = 2;
            test.add(new JLabel("",new ImageIcon("src/main/resources/arrow1.png"),SwingConstants.CENTER),gbc);
        }
        JPanel espacio = new JPanel();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight=3;
        espacio.setPreferredSize(new Dimension(100, 80)); // Ancho = tamaño del JFrame, alto = 80px
        espacio.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80)); // Limitar su tamaño máximo de alto
        espacio.setBackground(Color.LIGHT_GRAY); // (Opcional) Color para visualizar el espacio
        test.add(espacio,gbc);
        this.add(test);

    }
    static public void setMascotaAlmacenada(Mascota m){
        mascotaAlmacenada = m;
    }
    static public Mascota getMascotaAlmacenada(){
        return mascotaAlmacenada;
    }
    private void checkearMascota(){
        System.out.println(mascotaAlmacenada);
    }
}