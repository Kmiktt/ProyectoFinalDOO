package org.example.GUI;

import org.example.Logica.Usuario;

import javax.swing.*;
import java.awt.*;

public class PanelDesbloqueable extends JPanel {
    private int precio;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JLabel lb2;
    private PanelBase pb;
    public PanelDesbloqueable(PanelBase padre) {
        super();
        precio = 100;
        pb = padre;
        this.setLayout(new GridLayout(2,1,20,20));
        this.setBackground(new Color (150,150,150));
        this.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        JPanel pl = new JPanel(new GridLayout(2,1,20,20));
        JLabel lb=new JLabel("Desbloquear Paneles:", new ImageIcon("src/main/resources/felicidad.png"),SwingConstants.CENTER);
        lb.setVerticalTextPosition(SwingConstants.BOTTOM);
        lb.setHorizontalTextPosition(SwingConstants.CENTER);
        lb.setFont(new Font("Arial",Font.BOLD,54));
        lb2=new JLabel("",SwingConstants.CENTER);
        lb2.setFont(new Font("Arial",Font.PLAIN,30));
        pl.add(lb);
        pl.add(lb2);
        this.add(pl);
        JPanel pl2 = new JPanel(new GridLayout(1,3,30,30));
        pl2.setBackground(null);
        pl2.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        b1 = new JButton("Desbloquear Habitat Terrestre");
        b1.setFont(new Font("Arial",Font.PLAIN,20));
        b1.addActionListener(e -> desbloquear("terrestre"));
        b2 = new JButton("Desbloquear Habitat Acuatico");
        b2.setFont(new Font("Arial",Font.PLAIN,20));
        b2.addActionListener(e -> desbloquear("acuatico"));
        b3 = new JButton("Desbloquear Habitat Aereo");
        b3.setFont(new Font("Arial",Font.PLAIN,20));
        b3.addActionListener(e -> desbloquear("aereo"));
        pl2.add(b1);
        pl2.add(b2);
        pl2.add(b3);
        this.add(pl2);
    }
    public void desbloquear(String tipo){
        if(Usuario.getInstance().getDinero()>=precio){
            pb.agregarPanel(new PanelHabitat(tipo));
            Usuario.getInstance().restarDinero(precio);
            precio*=4;
        }
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        boolean b = Usuario.getInstance().getDinero()>=precio;
        b1.setEnabled(b);
        b2.setEnabled(b);
        b3.setEnabled(b);
        lb2.setText("Selecciona que panel desbloquear: (Precio: $"+precio+" / $"+Usuario.getInstance().getDinero()+" disponibles)");
    }
}
