package org.example.GUI;

import org.example.Logica.Usuario;

import javax.swing.*;
import java.awt.*;

/**Panel encargado de dar acceso a nuevos Habitat a cambio de dinero, pidiendo mas dinero por cada habitat
 * que ya se ha comprado.*/
public class PanelDesbloqueable extends JPanel implements Refreshable {
    private int precio;
    private final JButton b1;
    private final JButton b2;
    private final JButton b3;
    private final JLabel lb2;
    private final PanelBase pb;
    public PanelDesbloqueable(PanelBase padre) {
        super();
        precio = 100;
        pb = padre;
        this.setLayout(new GridLayout(2,1,20,20));
        this.setBackground(new Color (150,150,150));
        this.setBorder(BorderFactory.createEmptyBorder(60,100,100,100));
        JPanel pl = new JPanel(new GridLayout(2,1,20,20));
        JLabel lb=new JLabel("Desbloquear Paneles:", new ImageIcon("src/main/resources/iconlock.png"),SwingConstants.CENTER);
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
        b1 = new JButton("Desbloquear Habitat Terrestre",new ImageIcon("src/main/resources/iconterrestre.png"));
        b1.setFont(new Font("Arial",Font.PLAIN,20));
        b1.addActionListener(_ -> desbloquear("terrestre"));
        b2 = new JButton("Desbloquear Habitat Acuatico",new ImageIcon("src/main/resources/iconacuatico.png"));
        b2.setFont(new Font("Arial",Font.PLAIN,20));
        b2.addActionListener(_ -> desbloquear("acuatico"));
        b3 = new JButton("Desbloquear Habitat Aereo",new ImageIcon("src/main/resources/iconaereo.png"));
        b3.setFont(new Font("Arial",Font.PLAIN,20));
        b3.addActionListener(_ -> desbloquear("aereo"));
        pl2.add(b1);
        pl2.add(b2);
        pl2.add(b3);
        this.add(pl2);
    }
    /**Agrega un nuevo panel de Habitat de acuerdo al botón que se presionó, y resta el dinero correspondiente
     * @param tipo El tipo de habitat que se va a crear, de acuerdo al botón de compra presionado*/
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

    @Override
    public void actualizar() {

    }
}
