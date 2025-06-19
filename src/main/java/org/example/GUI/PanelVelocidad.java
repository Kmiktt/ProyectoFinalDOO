package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelVelocidad extends JPanel {
    private JButton v1;
    private JButton v2;
    private JButton v4;
    private JButton v8;
    public PanelVelocidad() {
        super();
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        JPanel panelTitulo = PanelCreator.VelTitle.crear();
        JPanel panelDeBotones = PanelCreator.VelBotones.crear();
        JLabel titulo = new JLabel("Elegir Velocidad de Juego");
        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        this.add(panelDeBotones,BorderLayout.CENTER);
        this.add(panelTitulo,BorderLayout.NORTH);
        panelTitulo.add(titulo);
        ActionListener vl = new VelocidadListener(titulo);
        v1 = new ButtonVel("x1");
        v2 = new ButtonVel("x2");
        v4 = new ButtonVel("x4");
        v8 = new ButtonVel("x8");
        panelDeBotones.add(v1);
        panelDeBotones.add(v2);
        panelDeBotones.add(v4);
        panelDeBotones.add(v8);
        for (Component b : panelDeBotones.getComponents()){
            if (b instanceof JButton){((JButton) b).addActionListener(vl);}
        }
    }
}
class TitleProxy{
    JLabel title;
    public TitleProxy(JLabel t){
        title=t;
    }
    public void updatear(String s){
        title.setText("Elegir Velocidad de Juego: "+s);
    }
}