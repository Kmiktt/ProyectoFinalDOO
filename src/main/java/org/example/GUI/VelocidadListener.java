package org.example.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class VelocidadListener implements ActionListener {
    JLabel title;
    public VelocidadListener(JLabel t){
        title = t;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton clicked){
            title.setText("Elegir Velocidad de Juego: "+clicked.getText());
        }
    }
}
