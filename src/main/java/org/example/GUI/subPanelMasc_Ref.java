package org.example.GUI;

import org.example.Logica.Mascota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class subPanelMasc_Ref extends JPanel {
    private Mascota m;
    private JButton botonAdoptar;
    private PanelRefugio panelPadre;
    private int index;
    public subPanelMasc_Ref(Mascota mascota, int i, PanelRefugio p){
        super();
        panelPadre = p;
        index = i;
        PanelCreator.MascotaWrapper.update(this);
        m = mascota;
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx=0.9;
        c.weighty = 1;
        JPanel pmasc = new JPanel();
        pmasc.setBackground(new Color(0,0,0,0));
        this.add(pmasc,c);
        JPanel pstats = new JPanel(new GridBagLayout());
        pstats.setBorder(BorderFactory.createLineBorder(Color.black,3));
        c.weightx=0.2;
        this.add(pstats,c);
        c.gridx=0;
        c.gridy=0;
        c.gridheight=1;
        c.fill= GridBagConstraints.BOTH;
        c.weightx=0.1;
        c.weighty=0.1;
        c.gridwidth=1;
        JLabel stat1 = new JLabel("Hambre: "+mascota.hambre, new ImageIcon("src/main/resources/hambre.png"),JLabel.LEFT);
        stat1.setHorizontalAlignment(0);
        JLabel stat2 = new JLabel("Higiene: "+mascota.higiene, new ImageIcon("src/main/resources/higiene.png"),JLabel.LEFT);
        stat2.setHorizontalAlignment(0);
        JLabel stat3 = new JLabel("Salud: "+mascota.salud, new ImageIcon("src/main/resources/salud.png"),JLabel.LEFT);
        stat3.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel stat4 = new JLabel("Felicidad: "+mascota.felicidad, new ImageIcon("src/main/resources/felicidad.png"),JLabel.LEFT);
        stat4.setHorizontalAlignment(0);
        c.gridy=1;  pstats.add(stat1,c);
        c.gridy=2;  pstats.add(stat2,c);
        c.gridy=3;  pstats.add(stat4,c);
        c.gridy=4;  pstats.add(stat3,c);
        botonAdoptar = new JButton("Adoptar "+m.getTipo());
        botonAdoptar.addActionListener(e -> abrirVentanaAdopcion());
        c.gridy=5;
        pstats.add(botonAdoptar,c);
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(new ImageIcon(PMascInHabitat.escogerImagen(m)).getImage(),30,15,null);
        botonAdoptar.setEnabled(panelPadre.disponible);
    }
    private void abrirVentanaAdopcion() {
        // Crear una nueva ventana (JFrame)
        JFrame ventanaAdopcion = new JFrame("Elige su nombre");
        ventanaAdopcion.setSize(300, 130);
        ventanaAdopcion.setLocationRelativeTo(null); // Centrar la ventana
        ventanaAdopcion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana

        // Crear un panel para organizar los componentes
        JPanel panelAdopcion = new JPanel();
        panelAdopcion.setLayout(new BorderLayout(10, 10)); // Espaciado entre componentes

        // Crear un campo de texto para ingresar el nombre
        JTextField campoTexto = new JTextField();
        campoTexto.setPreferredSize(new Dimension(200, 30)); // Tamaño preferido del campo
        panelAdopcion.add(campoTexto, BorderLayout.CENTER); // Agregar el campo al panel

        // Crear un botón "Adoptar"
        JButton botonAdoptar = new JButton("Adoptar");
        botonAdoptar.addActionListener(e -> {
            String nombreIngresado = campoTexto.getText(); // Obtener el texto ingresado
            if (!nombreIngresado.trim().isEmpty()||nombreIngresado.length()<15) { // Verificar que no esté vacío
                panelPadre.adoptarMascota(nombreIngresado, index);
                ventanaAdopcion.dispose(); // Cierra la ventana
            } else {
                JOptionPane.showMessageDialog(ventanaAdopcion, "Por favor, ingresa un nombre de <15 caracteres.");
            }
        });

        // Crear un panel para centrar el botón
        JPanel panelInferior = new JPanel(new FlowLayout());
        panelInferior.add(botonAdoptar);
        panelAdopcion.add(panelInferior, BorderLayout.SOUTH); // Agregar el botón al panel

        // Agregar el panel principal a la ventana
        ventanaAdopcion.add(panelAdopcion);

        // Hacer visible la ventana
        ventanaAdopcion.setVisible(true);
    }


}
