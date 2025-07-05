package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAcciones extends JPanel {
    private JPanel pVelocidad;
    private JPanel pInvententario;
    private JPanel pMapa;
    private PanelBase pFather;
    public PanelAcciones(PanelBase father){
        super();
        pFather= father;
        PanelCreator.Acciones.update(this);
        pVelocidad = new PanelVelocidad();
        this.add(pVelocidad);
        pInvententario = new PanelInventario();
        this.add(pInvententario);

        pMapa = PanelCreator.PanMap.crear();
        this.add(pMapa);
        JButton mapa = new JButton("Revisar Mapa");
        mapa.addActionListener(new MapaListener());
        mapa.setFont(new Font("Comic Sans MS",Font.PLAIN,16));
        mapa.setPreferredSize(new Dimension(250,50));
        pMapa.add(mapa);
    }
    private class MapaListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            pFather.cambiarSala();
        }
    }
}
