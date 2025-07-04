package org.example.GUI;

import org.example.Logica.Mascota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class PMascInHabitat extends JPanel {
    Mascota mascota;
    JLabel stat1;
    JLabel stat2;
    JLabel stat3;
    JLabel stat4;
    JButton bAlimentar;
    JButton bLimpiar;
    JButton bCurar;
    JButton bJugar;

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
        this.add(pmasc,c);
        JPanel pstats = new JPanel(new GridBagLayout());
        pstats.setBorder(BorderFactory.createLineBorder(Color.black,3));
        c.weightx=0.0;
        c.ipadx=20;
        this.add(pstats,c);
        c.ipadx=0;
        c.ipady=0;
        JLabel nombre = new JLabel(mascota.nombre);
        nombre.setVerticalAlignment(JLabel.CENTER);
        nombre.setHorizontalAlignment(JLabel.CENTER);
        nombre.setFont(new Font("Calisto MT",Font.BOLD,24));
        c.gridx=0;
        c.gridy=0;
        c.gridwidth=2;
        c.gridheight=1;
        c.fill= GridBagConstraints.BOTH;
        c.weightx=0.1;
        c.weighty=0.3;
        pstats.add(nombre,c);
        c.weighty=0.1;
        c.gridwidth=1;
        stat1 = new JLabel("Hambre: "+mascota.hambre, new ImageIcon("src/main/resources/hambre.png"),JLabel.LEFT);
        stat2 = new JLabel("Higiene: "+mascota.higiene, new ImageIcon("src/main/resources/higiene.png"),JLabel.LEFT);
        stat3 = new JLabel("Salud: "+mascota.salud, new ImageIcon("src/main/resources/salud.png"),JLabel.LEFT);
        stat4 = new JLabel("Felicidad: "+mascota.felicidad, new ImageIcon("src/main/resources/felicidad.png"),JLabel.LEFT);
        c.gridy=1;  pstats.add(stat1,c);
        c.gridx=1;  pstats.add(stat2,c);
        c.gridy=2;  pstats.add(stat4,c);
        c.gridx=0;  pstats.add(stat3,c);
        bAlimentar = new JButton("Alimentar"); bAlimentar.setFocusPainted(false);
        bAlimentar.addActionListener(new AccionStatListener());
        bLimpiar = new JButton("Limpiar"); bLimpiar.setFocusPainted(false);
        bLimpiar.addActionListener(new AccionStatListener());
        bCurar = new JButton("Dar Medicina"); bCurar.setFocusPainted(false);
        bCurar.addActionListener(new AccionStatListener());
        bJugar = new JButton("Jugar"); bJugar.setFocusPainted(false);
        bJugar.addActionListener(new AccionStatListener());
        c.gridy=3; pstats.add(bAlimentar,c);
        c.gridx=1; pstats.add(bLimpiar,c);
        c.gridy=4; c.gridx=0; pstats.add(bCurar,c);
        c.gridx=1; pstats.add(bJugar,c);



    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(new ImageIcon(escogerImagen()).getImage(),30,15,null);
        actualizarLabels();
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
    private void actualizarLabels(){
        stat1.setText("Hambre: "+mascota.hambre);
        stat2.setText("Higiene: "+mascota.higiene);
        stat3.setText("Salud: "+mascota.salud);
        stat4.setText("Felicidad: "+mascota.felicidad);
    }
    /**Listener para los botones de acciones que tiene cada mascota*/
    private class AccionStatListener implements ActionListener {
        /**Utiliza el texto del botón del que proviene el ActionEvent
         * para determinar que acción realizar. Bloquea los botones
         * por un tiempo determinado por un Timer*/
        public void actionPerformed(ActionEvent ae){
            String ref = ((JButton) ae.getSource()).getText();
            bAlimentar.setEnabled(false);
            bCurar.setEnabled(false);
            bJugar.setEnabled(false);
            bLimpiar.setEnabled(false);
            if (Objects.equals(ref, "Alimentar")) mascota.alimentar(mascota.atri.getComida());
            if (Objects.equals(ref, "Limpiar")) mascota.limpiar();
            if (Objects.equals(ref,"Dar Medicina")) mascota.sanar();
            if (Objects.equals(ref,"Jugar")) mascota.jugar(mascota.atri.getJuego());
            Timer t = new Timer(1200,null);
            t.addActionListener(new TimerAccionesListener());
            t.start();
        }
    }
    /**Listener para el timer al presionar un botón, es una private class dentro
     * de esta clase para poder acceder a los botones sin problemas, y también
     * para hacer repaint a todo el panel al actualizar los datos*/
    private class TimerAccionesListener implements ActionListener {
        /**Vuelve a dejar disponible los botones y hace repaint a todo
         * el panel al terminar el timer*/
        public void actionPerformed(ActionEvent ae) {
            bAlimentar.setEnabled(true);
            bCurar.setEnabled(true);
            bJugar.setEnabled(true);
            bLimpiar.setEnabled(true);
            repaint();
        }
    }
}
