package org.example.GUI;

import org.example.Logica.Mascota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class subPanelMasc_Ref extends JPanel {
    private Mascota m;
    public subPanelMasc_Ref(Mascota mascota){
        super();
        PanelCreator.MascotaWrapper.update(this);
        m = mascota;
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx=0.9;
        c.weighty = 1;
        JPanel pmasc = new JPanel();
        pmasc.setBackground(new Color(0,0,0,0));
        this.add(pmasc,c);
        JPanel pstats = new JPanel(new GridBagLayout());
        pstats.setBorder(BorderFactory.createLineBorder(Color.black,3));
        c.weightx=0.2;
        this.add(pstats,c);
        c.gridx=0;
        c.gridy=0;
        c.gridheight=1;
        c.fill= GridBagConstraints.BOTH;
        c.weightx=0.1;
        c.weighty=0.1;
        c.gridwidth=1;
        JLabel stat1 = new JLabel("Hambre: "+mascota.hambre, new ImageIcon("src/main/resources/hambre.png"),JLabel.LEFT);
        stat1.setHorizontalAlignment(0);
        JLabel stat2 = new JLabel("Higiene: "+mascota.higiene, new ImageIcon("src/main/resources/higiene.png"),JLabel.LEFT);
        stat2.setHorizontalAlignment(0);
        JLabel stat3 = new JLabel("Salud: "+mascota.salud, new ImageIcon("src/main/resources/salud.png"),JLabel.LEFT);
        stat3.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel stat4 = new JLabel("Felicidad: "+mascota.felicidad, new ImageIcon("src/main/resources/felicidad.png"),JLabel.LEFT);
        stat4.setHorizontalAlignment(0);
        c.gridy=1;  pstats.add(stat1,c);
        c.gridy=2;  pstats.add(stat2,c);
        c.gridy=3;  pstats.add(stat4,c);
        c.gridy=4;  pstats.add(stat3,c);
        JButton botonAdoptar = new JButton("Adoptar "+m.getTipo());
        botonAdoptar.addActionListener(e -> abrirVentanaAdopcion());
        c.gridy=5;
        pstats.add(botonAdoptar,c);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(new ImageIcon(PMascInHabitat.escogerImagen(m)).getImage(),30,15,null);
        System.out.println(m);
    }
    private void abrirVentanaAdopcion() {
        // Crear una nueva ventana (JFrame)
        JFrame ventanaAdopcion = new JFrame("Adopción");
        ventanaAdopcion.setSize(300, 150);
        ventanaAdopcion.setLocationRelativeTo(null); // Centrar la ventana
        ventanaAdopcion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana

        // Crear un panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        // Crear el botón 1
        JButton boton1 = new JButton("Adoptar Gato");
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(boton1.getText()); // Imprime el texto del botón
                ventanaAdopcion.dispose(); // Cierra la ventana
            }
        });

        // Crear el botón 2
        JButton boton2 = new JButton("Adoptar Perro");
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(boton2.getText()); // Imprime el texto del botón
                ventanaAdopcion.dispose(); // Cierra la ventana
            }
        });

        // Agregar los botones al panel
        panelBotones.add(boton1);
        panelBotones.add(boton2);

        // Agregar el panel de botones a la nueva ventana
        ventanaAdopcion.add(panelBotones);

        // Hacer visible la ventana
        ventanaAdopcion.setVisible(true);
    }

}
