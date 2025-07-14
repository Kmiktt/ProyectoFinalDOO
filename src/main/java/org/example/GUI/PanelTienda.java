package org.example.GUI;

import org.example.Logica.*;
import org.example.Logica.Consumibles.*;
import org.example.Logica.Tienda;

import javax.swing.*;
import java.awt.*;

/**JPanel encargado de mostrar la selección de productos que tiene disponibles la tienda asociada.
 * Permite tambien comprar productos, restando al usuario la cantidad de dinero correspondiente*/
public class PanelTienda extends JPanel implements Refreshable,TimeUpdatable{
    private final Tienda<Consumible> tienda;
    private final JPanel panelContenido;
    private final JLabel labelDinero;
    private int tiempo;
    public PanelTienda(){
        super();
        tiempo = 0;
        //Inicializar cosas de Tienda
        tienda=new Tienda<>();
        tienda.agregarProducto(new Carne(),25);
        tienda.agregarProducto(new ComidaGenerica(),5);
        tienda.agregarProducto(new Pescado(),25);
        tienda.agregarProducto(new Medicina(), 30);
        tienda.agregarProducto(new Krill(), 20);
        tienda.actualizarStock(6);
        //Aspectos Visuales de paneles
        this.setBorder(BorderFactory.createEmptyBorder(80,80,100,80));
        this.setBackground(new Color(100,100,255,70));
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JPanel panelVacio = new JPanel(new BorderLayout());
        panelVacio.setBackground(new Color(220,220,220,90));
        panelVacio.setBorder(BorderFactory.createLineBorder(Color.black));
        c.gridx = 0; // Primera columna
        c.gridy = 0; // Primera fila
        c.weightx = 0.12; // 30% del ancho
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH; // Expandir en ambas direcciones
        this.add(panelVacio, c);
        labelDinero = new JLabel("Dinero disponible: $"+Usuario.getInstance().getDinero());
        labelDinero.setFont(new Font("Rockwell",Font.PLAIN,20));
        labelDinero.setHorizontalAlignment(JLabel.CENTER);
        panelVacio.add(labelDinero,BorderLayout.SOUTH);

        panelContenido = new JPanel();
        panelContenido.setBackground(new Color(0,180,255,100));
        panelContenido.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        panelContenido.setLayout(new GridLayout(2,3,10,10));
        c.gridx = 1;
        c.weightx = 1-c.weightx; // 70% del ancho
        this.add(panelContenido, c);

        crearPanelesDeProductos();
    }
    private void crearPanelesDeProductos(){
        for (int i = 0; i<6; i++){
            if (tienda.getStock().size()<=i) {panelContenido.add(PanelCreator.Vacio.crear()); continue;}
            Consumible c = tienda.getStock().get(i);
            JPanel panel = new JPanel(new GridLayout(1,2));
            JPanel panelProducto = new JPanel();
            panelProducto.setBackground(Color.LIGHT_GRAY);
            panel.add(panelProducto);
            JPanel panelInfo = new JPanel(new BorderLayout());
            panelInfo.setBackground(Color.ORANGE);
            panel.add(panelInfo);

            JLabel imagen = new JLabel(new ImageIcon("src/main/resources/icon"+c.getTipo()+"_2.png"));
            imagen.setVerticalAlignment(JLabel.CENTER);
            imagen.setHorizontalAlignment(JLabel.CENTER);
            panelProducto.add(imagen);

            JLabel name = new JLabel(c.toString().substring(0,1).toUpperCase()+c.toString().substring(1).replace("_"," "));
            name.setFont(new Font("Comic Sans MS",Font.PLAIN,20));
            name.setBorder(BorderFactory.createLineBorder(Color.black,2));
            name.setHorizontalAlignment(JLabel.CENTER);
            panelInfo.add(name,BorderLayout.NORTH);

            JLabel precio = new JLabel(String.format("<html><b>Precio:</b><br><br>  $%s </html>", tienda.getPrecios().get(i)));
            precio.setFont(new Font("Arial",Font.PLAIN,28));
            precio.setHorizontalAlignment(JLabel.CENTER);
            precio.setVerticalAlignment(JLabel.CENTER);
            panelInfo.add(precio,BorderLayout.CENTER);

            JButton comprar = new JButton("Comprar");
            comprar.setPreferredSize(new Dimension(60,70));
            comprar.setFont(new Font("Rockwell",Font.PLAIN,24));
            comprar.setFocusPainted(false);
            int finalI = i;
            comprar.addActionListener(_ -> comprarProducto(finalI));
            panelInfo.add(comprar,BorderLayout.SOUTH);

            panelContenido.add(panel);
        }
    }
    private void comprarProducto(int index){
        Consumible con = tienda.comprarProducto(index);
        if(con!=null){
            Usuario.getInstance().agregarObjeto(con);
            System.out.println(con);
            panelContenido.removeAll();
            crearPanelesDeProductos();
        }
        actualizar();
        PanelBase.actualizarPanelAcciones();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(new ImageIcon("src/main/resources/fondotienda.png").getImage(),0,0,null);
        revalidate();
    }
    public void updatearTienda(){
        tienda.actualizarStock(6);
        panelContenido.removeAll();
        crearPanelesDeProductos();
        actualizar();
    }

    public void actualizar() {
        labelDinero.setText("Dinero disponible: $"+Usuario.getInstance().getDinero());
        revalidate();
        repaint();
    }
    public void timeUpdate() {
        if ((tiempo>10 && tienda.getStock().isEmpty()) || (tiempo>20)) {
            updatearTienda(); tiempo=0;
        }
        tiempo++;
    }
}
