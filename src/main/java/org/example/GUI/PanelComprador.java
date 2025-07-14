package org.example.GUI;

import org.example.Logica.ClienteMascota;
import org.example.Logica.Mascotas.*;
import org.example.Logica.TomaMascota;
import org.example.Logica.Usuario;

import javax.swing.*;
import java.awt.*;

/**JPanel utilizado para vender mascotas a un cliente y conseguir dinero de vuelta
 * El cliente esperará una cantidad de tiempo maxima hasta cambiar la mascota que busca
 * Utiliza TomaMascota para permitir que el jugador le entregue al cliente la mascota
 * que tiene en el inventario*/
public class PanelComprador extends JPanel implements TimeUpdatable, Refreshable, TomaMascota {
    private final ClienteMascota cliente;
    private final JLabel saludo;
    private final JLabel precio;
    public PanelComprador() {
        super();
        cliente = new ClienteMascota();
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.setBorder(BorderFactory.createEmptyBorder(80,80,100,80));
        JPanel panelImagen = new JPanel();
        panelImagen.setBackground(new Color(255,255,255,0));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 3;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.9;
        c.weighty =1;
        this.add(panelImagen, c);
        c.weightx = 1-c.weightx;
        c.gridx = 1;
        c.gridwidth = 2;
        c.gridheight = 1;
        saludo = new JLabel();
        saludo.setFont(new Font("Rockwell", Font.PLAIN, 36));
        saludo.setHorizontalAlignment(JLabel.CENTER);
        this.add(saludo,c);
        c.gridy = 1;
        c.gridheight = 2;
        precio = new JLabel();
        precio.setFont(new Font("Rockwell", Font.PLAIN, 24));
        precio.setHorizontalTextPosition(JLabel.CENTER);
        precio.setVerticalTextPosition(JLabel.BOTTOM);
        precio.setHorizontalAlignment(JLabel.CENTER);
        precio.setVerticalAlignment(JLabel.TOP);
        this.add(precio,c);
    }
    /**Actualiza visualmente el texto del JPanel para acomodarse a la mascota que busca el cliente
     * Se utiliza tambien para mostrar el precio que el cliente pagaria por la mascota.*/
    public void actualizar() {
        if (cliente.getTipo()==null) {
            saludo.setText("Muy buenas, actualmente no busco ningún animal!");
            precio.setText("");
            precio.setIcon(null);
        } else{
            saludo.setText("Muy buenas, ando buscando un "+cliente.getTipo()+" para comprar!");
            precio.setIcon(new ImageIcon("src/main/resources/icon"+cliente.getTipo()+"_2.png"));
            if (Usuario.getInstance().getMascota()==null) {precio.setText("No tienes lo que busco? No estoy muy interesado"); return;}
            if (!Usuario.getInstance().getMascota().getTipo().equals(cliente.getTipo())) {precio.setText("No tienes el animal que busco? Que mal..."); return;}
            precio.setText("Por ese "+cliente.getTipo()+" que tienes en la mano, te podria pagar $"+cliente.cuantoPaga(Usuario.getInstance().getMascota()));
        }
        revalidate();
        repaint();
    }
    /**Actualiza el tiempo que el cliente ha estado esperando por una unidad y realiza los metodos correspondientes*/
    public void timeUpdate() {
        cliente.update();
        actualizar();
    }
    /**Metodo de TomaMascota, le entrega la mascota a cliente para que realize su propio metodo de agregarMascota
     * @return La misma mascota si es que no se pudo realizar la operación, o null si es que si se realizó*/
    @Override
    public Mascota agregarMascota(Mascota ma) {
        return cliente.agregarMascota(ma);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(new ImageIcon("src/main/resources/fondoclientecon.png").getImage(),0,0,null);
    }
}
