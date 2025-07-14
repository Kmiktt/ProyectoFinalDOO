package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**Panel encargado de almacenar los botones que se encuentran abajo de pantalla
 * en todo momento.
 * Te permite cambiar la velocidad del juego, ver y seleccionar objetos y mascotas
 * de tu inventario, y cambiar entre las distintas habitaciones del juego*/
public class PanelAcciones extends JPanel implements Refreshable {
    private final PanelVelocidad pVelocidad;
    private final PanelInventario pInvententario;
    private final PanelBase pFather;
    public PanelAcciones(PanelBase father){
        super();
        pFather= father;
        PanelCreator.Acciones.update(this);
        pVelocidad = new PanelVelocidad();
        this.add(pVelocidad);
        pInvententario = new PanelInventario();
        this.add(pInvententario);

        JPanel pMapa = PanelCreator.PanMap.crear();
        this.add(pMapa);
        JButton mapa = new JButton("Cambiar Sala");
        mapa.addActionListener(new MapaListener());
        mapa.setFont(new Font("Comic Sans MS",Font.PLAIN,16));
        mapa.setPreferredSize(new Dimension(250,50));
        mapa.setFocusPainted(false);
        pMapa.add(mapa);
    }
    private class MapaListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            pFather.cambiarSala(); actualizar();
        }
    }

    public void actualizar(){
        pVelocidad.actualizar();
        pInvententario.actualizar();
    }
}
