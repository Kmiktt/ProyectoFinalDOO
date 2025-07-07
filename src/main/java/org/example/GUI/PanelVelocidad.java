package org.example.GUI;

import org.example.Logica.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelVelocidad extends JPanel implements Actualizable{
    private JLabel titulo;
    public PanelVelocidad() {
        super();
        PanelCreator.PanVel.update(this);
        JPanel panelTitulo = PanelCreator.VelTitle.crear();
        JPanel panelDeBotones = PanelCreator.VelBotones.crear();
        titulo = new JLabel("Elegir Velocidad de Juego: x1");
        titulo.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(panelDeBotones,BorderLayout.CENTER);
        this.add(panelTitulo,BorderLayout.NORTH);
        panelTitulo.add(titulo);
        for(int i = 1; i<=8; i*=2){
            JButton b = new JButton("x"+i);
            int finalI = i;
            b.addActionListener(e-> cambiarVelocidad(finalI));
            b.setFocusPainted(false);
            panelDeBotones.add(b);
        }
    }
    private void cambiarVelocidad(int vel){
        Usuario.getInstance().velocidad=vel;
        actualizar();
    }

    public void actualizar() {
        titulo.setText("Elegir Velocidad de Juego: x"+Usuario.getInstance().velocidad);
        revalidate();
        repaint();
    }
}