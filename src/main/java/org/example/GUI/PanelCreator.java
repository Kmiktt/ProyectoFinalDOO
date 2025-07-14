package org.example.GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**Enum utlizado en algunas partes para simplificar la creación de nuevos paneles
 * Permite devolver nuevos paneles que sigan ciertas condiciones, o actualizar un panel ya existente*/
public enum PanelCreator {
    BaseAcc(null,new Color(176,122,86),BorderFactory.createLineBorder(new Color(44,14,3),3)),
    PanVel(new BorderLayout(),PanelCreator.BaseAcc.bgC(),PanelCreator.BaseAcc.bdr()),
    PanMap(new GridBagLayout(),PanelCreator.BaseAcc.bgC(),PanelCreator.BaseAcc.bdr()),
    VelTitle(new GridBagLayout(), new Color(224, 198, 99,255), null),
    Acciones(new GridLayout(1,3,100,0),null,(BorderFactory.createLineBorder(new Color(10,10,10),4))),
    VelBotones(new GridLayout(2,2,30,10),new Color(0,0,0,0),BorderFactory.createLineBorder(new Color(0,0,0,0),5)),
    MascotaWrapper(new GridBagLayout(), new Color(255,200,200,255),BorderFactory.createLineBorder(Color.BLACK,3)),
    Vacio(null, new Color(0,0,0,0),null);
    private final LayoutManager layout;
    private final Color bgColor;
    private final Border bord;
    PanelCreator(LayoutManager Layout, Color bg, Border border){
        layout = Layout;
        bgColor = bg;
        bord = border;
    }
    public void update(JPanel p){
        if (layout!=null) p.setLayout(layout);
        if(bgColor!=null)p.setBackground(bgColor);
        if (bord!=null) p.setBorder(bord);
    }
    public JPanel crear(){
        JPanel panel = new JPanel();
        if (layout!=null) panel.setLayout(layout);
        if(bgColor!=null)panel.setBackground(bgColor);
        if (bord!=null)panel.setBorder(bord);
        return panel;
    }

    public Color bgC(){
        return bgColor;
    }
    public Border bdr(){
        return bord;
    }
}
