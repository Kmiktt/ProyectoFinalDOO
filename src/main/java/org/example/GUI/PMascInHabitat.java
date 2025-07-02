package org.example.GUI;

import org.example.Logica.Mascota;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PMascInHabitat extends JPanel {
    Mascota mascota;
    JLabel nombre;
    JLabel stat1;
    JLabel stat2;
    JLabel stat3;
    JLabel stat4;

    public PMascInHabitat(Mascota m){
        super();
        PanelCreator.MascotaWrapper.update(this);
        mascota = m;
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipady=88;
        c.ipadx=120;
        c.weightx=1;
        JPanel pmasc = new JPanel();
        pmasc.setBorder(BorderFactory.createLineBorder(Color.green,2));
        this.add(pmasc,c);
        JPanel pstats = new JPanel(new GridBagLayout());
        pstats.setBorder(BorderFactory.createLineBorder(Color.red,2));
        c.weightx=0.0;
        c.ipadx=20;
        this.add(pstats,c);
        JLabel nombre = new JLabel(mascota.nombre);
        nombre.setVerticalAlignment(JLabel.CENTER);
        nombre.setHorizontalAlignment(JLabel.CENTER);
        nombre.setFont(new Font("Calisto MT",Font.BOLD,24));
        nombre.setBorder(BorderFactory.createLineBorder(Color.black));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=2;
        constraints.gridheight=1;
        constraints.fill= GridBagConstraints.BOTH;
        constraints.weightx=0.1;
        constraints.weighty=0.3;
        pstats.add(nombre,constraints);
        constraints.weighty=0.1;
        constraints.gridwidth=1;
        stat1 = new JLabel("Hambre: "+mascota.hambre, new ImageIcon("src/main/resources/hambre.png"),JLabel.LEFT);
        stat2 = new JLabel("Higiene: "+mascota.higiene, new ImageIcon("src/main/resources/higiene.png"),JLabel.LEFT);
        stat3 = new JLabel("Salud: "+mascota.salud, new ImageIcon("src/main/resources/salud.png"),JLabel.LEFT);
        stat3.setBorder(BorderFactory.createLineBorder(Color.black));
        stat4 = new JLabel("Felicidad: "+mascota.felicidad, new ImageIcon("src/main/resources/felicidad.png"),JLabel.LEFT);
        constraints.gridy=1;
        pstats.add(stat1,constraints);
        constraints.gridx=1;
        pstats.add(stat2,constraints);
        constraints.gridy=2;
        pstats.add(stat4,constraints);
        constraints.gridx=0;
        pstats.add(stat3,constraints);
        JButton test = new JButton("Alimentar");
        JButton test2 = new JButton("Limpiar");
        JButton test3 = new JButton("Dar Medicina");
        JButton test4 = new JButton("Jugar");
        constraints.gridy=3;
        pstats.add(test,constraints);
        constraints.gridx=1;
        pstats.add(test2,constraints);
        constraints.gridy=4;
        pstats.add(test3,constraints);
        constraints.gridx=0;
        pstats.add(test4,constraints);



    }
}
