package org.example.GUI;

import org.example.Logica.TomaMascota;
import org.example.Logica.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

/**JPanel encargado de mostrar los objetos que se tienen en el inventarios, permitiendote
 * seleccionarlos según indicado*/
public class PanelInventario extends JPanel implements Refreshable {
    private final JLabel comida;
    private final JLabel medicina;
    private final JLabel animal;
    private final JButton botonEntregar;
    private final Usuario u;
    public PanelInventario(){
        super();
        u = Usuario.getInstance();
        PanelCreator.BaseAcc.update(this);
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel pBase = new JPanel(new GridBagLayout());
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.weightx = 1; gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        pBase.setBackground(new Color(79,39,11));
        JLabel uArrow = new JLabel("",new ImageIcon("src/main/resources/arrow0.png"),SwingConstants.CENTER);
        uArrow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                u.comidaIndex++;
                actualizar();
            }
        });
        pBase.add(uArrow,gbc);

        JPanel espacio = new JPanel();
        gbc.gridy = 1;
        espacio.setPreferredSize(new Dimension(100, 80)); // Ancho = tamaño del JFrame, alto = 80px
        espacio.setBackground(Color.LIGHT_GRAY); // (Opcional) Color para visualizar el espacio
        String auxTipo = intToComidaString(u.comidaIndex%3+1);
        comida = new JLabel("x"+u.cuantoObjeto(auxTipo),new ImageIcon("src/main/resources/"+auxTipo+"_1.png"),SwingConstants.CENTER);
        comida.setVerticalTextPosition(JLabel.CENTER);
        comida.setHorizontalTextPosition(JLabel.RIGHT);
        comida.setVerticalAlignment(JLabel.BOTTOM);
        espacio.add(comida);
        pBase.add(espacio,gbc);

        gbc.gridy = 2;
        JLabel dArrow = new JLabel("",new ImageIcon("src/main/resources/arrow1.png"),SwingConstants.CENTER);
        dArrow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                u.comidaIndex--;
                actualizar();
            }
        });
        pBase.add(dArrow,gbc);

        JPanel espacio2 = new JPanel();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight=3;
        medicina = new JLabel("x"+Usuario.getInstance().cuantoObjeto("medicina"),new ImageIcon("src/main/resources/iconmedicina_1.png"),SwingConstants.CENTER);
        medicina.setVerticalTextPosition(JLabel.BOTTOM);
        medicina.setHorizontalTextPosition(JLabel.CENTER);
        medicina.setVerticalAlignment(JLabel.BOTTOM);
        espacio2.setPreferredSize(new Dimension(100, 80));
        espacio2.setBackground(new Color(210,210,210));
        espacio2.setBorder(BorderFactory.createEmptyBorder(14,0,14,0));
        espacio2.add(medicina);
        pBase.add(espacio2,gbc);

        gbc.gridx = 2;
        gbc.gridheight=2;
        JPanel espacio3 = new JPanel();
        espacio3.setPreferredSize(new Dimension(100, 80));
        espacio3.setBackground(Color.LIGHT_GRAY);
        espacio3.setBorder(BorderFactory.createEmptyBorder(14,0,14,0));
        animal = new JLabel();
        animal.setHorizontalTextPosition(JLabel.CENTER);
        animal.setVerticalTextPosition(JLabel.TOP);
        animal.setVerticalAlignment(JLabel.TOP);
        espacio3.add(animal);
        pBase.add(espacio3,gbc);
        botonEntregar = new JButton("Entregar");
        botonEntregar.setFocusPainted(false);
        botonEntregar.addActionListener(_ -> entregarMascota());
        gbc.gridy=2;
        gbc.gridheight=1;
        pBase.add(botonEntregar,gbc);
        this.add(pBase);
        actualizarDatos();

    }
    /**Metodo utilizado para convertir de un entero al consumible correspondiente, es
     * estático para que lo puedan acceder otras partes del codigo si es correspondiente
     * @param i int que representa un Consumible
     * @return String que es el tipo del consumible correspondiente */
    public static String intToComidaString(int i){
        return switch (i) {
            case 0 -> "medicina";
            case 1 -> "comida_generica";
            case 2 -> "carne";
            case 3 -> "pescado";
            case 4 -> "krill";
            default -> "";
        };
    }
    public void actualizar() {
        actualizarDatos();
        PanelBase.actualizarPanelActual();
        revalidate();
        repaint();
    }
    /**Actualiza la cantidad de cada objeto mostrado en pantalla, y el nombre y especie de la mascota que se tiene
     *  en el inventario*/
    public void actualizarDatos(){
        String auxTipo = intToComidaString((u.comidaIndex%4)+1);
        comida.setText("x"+u.cuantoObjeto(auxTipo));
        comida.setIcon(new ImageIcon("src/main/resources/icon"+auxTipo+"_1.png"));
        medicina.setText("x"+u.cuantoObjeto("medicina"));
        if (u.getMascota()!=null){
            animal.setText(u.getMascota().getNombre());
            animal.setIcon(new ImageIcon("src/main/resources/icon"+u.getMascota().getTipo()+"_1.png"));
        } else {
            animal.setText("");
            animal.setIcon(null);
        }
        botonEntregar.setEnabled(PanelBase.getPanelActual() instanceof TomaMascota && u.getMascota() != null);
    }
    /**Metodo usado al hacer click al botón de entregar que tiene la mascota del inventario, se la entrega
     * al JPanel de TomaMascota si es que el panel actual tiene tal interfaz*/
    private void entregarMascota(){
        TomaMascota tm = (TomaMascota) PanelBase.getPanelActual();
        Usuario.getInstance().colocarMascota(tm);
        PanelBase.actualizarPanelActual();
        actualizar();
    }
}