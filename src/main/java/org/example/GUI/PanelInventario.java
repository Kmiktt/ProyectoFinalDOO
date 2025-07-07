package org.example.GUI;

import org.example.Logica.Mascota;
import org.example.Logica.Medicina;
import org.example.Logica.Usuario;

import javax.swing.*;
import java.awt.*;

public class PanelInventario extends JPanel implements Actualizable{
    private JButton invent;
    private static int indexComida;
    static private JLabel comida;
    private JLabel medicina;
    private JLabel animal;
    public PanelInventario(){
        super();
        PanelCreator.BaseAcc.update(this);
        JPanel test = new JPanel(new GridBagLayout());
        test.setBackground(new Color(79,39,11));
        GridBagConstraints gbc = new GridBagConstraints();
        indexComida=0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        test.add(new JLabel("",new ImageIcon("src/main/resources/arrow0.png"),SwingConstants.CENTER),gbc);
        JPanel espacio = new JPanel();
        gbc.gridy = 1;
        espacio.setPreferredSize(new Dimension(100, 80)); // Ancho = tamaño del JFrame, alto = 80px
        espacio.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80)); // Limitar su tamaño máximo de alto
        espacio.setBackground(Color.LIGHT_GRAY); // (Opcional) Color para visualizar el espacio
        String auxTipo = intToComidaString((indexComida)%3+1);
        comida = new JLabel("x"+Usuario.getInstance().cuantoObjeto(auxTipo),new ImageIcon("src/main/resources/"+auxTipo+"_1.png"),SwingConstants.CENTER);
        espacio.add(comida);
        test.add(espacio,gbc);


        gbc.gridy = 2;
        test.add(new JLabel("",new ImageIcon("src/main/resources/arrow1.png"),SwingConstants.CENTER),gbc);
        JPanel espacio2 = new JPanel();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight=3;
        espacio2.setPreferredSize(new Dimension(100, 80)); // Ancho = tamaño del JFrame, alto = 80px
        espacio2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80)); // Limitar su tamaño máximo de alto
        espacio2.setBackground(Color.LIGHT_GRAY); // (Opcional) Color para visualizar el espacio
        test.add(espacio2,gbc);
        this.add(test);

    }
    private void checkearMascota(){
        System.out.println(Usuario.getInstance().getMascota().toString());
    }
    private static String intToComidaString(int i){
        return switch (i) {
            case 0 -> "medicina";
            case 1 -> "comida_generica";
            case 2 -> "carne";
            case 3 -> "pescado";
            default -> "";
        };
    }
    public void actualizar() {
        actualizarDatos();
        revalidate();
        repaint();
    }
    static public void actualizarDatos(){
        String auxTipo = intToComidaString((indexComida)%3+1);
        comida = new JLabel("x"+Usuario.getInstance().cuantoObjeto(auxTipo),new ImageIcon("src/main/resources/"+auxTipo+"_1.png"),SwingConstants.CENTER);
    }
}