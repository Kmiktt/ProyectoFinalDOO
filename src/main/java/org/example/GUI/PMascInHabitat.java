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
        pmasc.setBackground(new Color(0,0,0,0));
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
        JButton test = new JButton("Alimentar"); test.setFocusPainted(false);
        JButton test2 = new JButton("Limpiar"); test2.setFocusPainted(false);
        JButton test3 = new JButton("Dar Medicina"); test3.setFocusPainted(false);
        JButton test4 = new JButton("Jugar"); test4.setFocusPainted(false);
        constraints.gridy=3;
        pstats.add(test,constraints);
        constraints.gridx=1;
        pstats.add(test2,constraints);
        constraints.gridy=4;
        pstats.add(test3,constraints);
        constraints.gridx=0;
        pstats.add(test4,constraints);



    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(new ImageIcon(escogerImagen()).getImage(),30,15,null);
    }
    private String escogerImagen(){
        String base = "src/main/resources/";
        base += mascota.getTipo() + "_" + mascota.getAspecto()+"_";
        float sumaMax = mascota.atri.getFelicidad()+mascota.atri.getHambre()+mascota.atri.getHigiene()+mascota.atri.getSalud();
        float sumaActual = mascota.salud+mascota.higiene+mascota.felicidad+mascota.hambre;
        if (sumaActual/sumaMax>0.7) base+="feliz";
        else if (sumaActual/sumaMax>0.5) base+="normal";
        else {
            String aux = "enfermo";
            int min = mascota.salud;
            if (min>mascota.hambre){min=mascota.hambre; aux= "hambriento";}
            if (min>mascota.felicidad){min=mascota.felicidad; aux= "triste";}
            if (min>mascota.higiene){aux= "sucio";}
            base+=aux;
        }
        base+=".png";
        return base;
    }
}
