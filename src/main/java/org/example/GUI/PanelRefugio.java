package org.example.GUI;

import org.example.Logica.Mascotas.Mascota;
import org.example.Logica.Refugio;
import org.example.Logica.Usuario;

import javax.swing.*;
import java.awt.*;

/**JPanel encargado de mostrar la selección de mascotas que se pueden adoptar del refugio asociado.*/
public class PanelRefugio extends JPanel implements Refreshable,TimeUpdatable{
    private final JPanel panelContenido;
    private final Refugio refugio;
    private int tiempo;
    public boolean disponible;
    public boolean adoptado;
    public PanelRefugio(){
        super();
        adoptado = false;
        refugio = new Refugio();
        refugio.actualizarAnimales();
        refugio.actualizarStock(4);
        this.setBorder(BorderFactory.createEmptyBorder(80,80,100,80));
        this.setBackground(new Color(100,100,255,0));
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JPanel panelVacio = new JPanel();
        panelVacio.setBackground(new Color(255,255,255,0));
        c.gridx = 0; // Primera columna
        c.gridy = 0; // Primera fila
        c.weightx = 0.5; // 30% del ancho
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH; // Expandir en ambas direcciones
        this.add(panelVacio, c);

        // Panel de contenido (70% del espacio)
        panelContenido = new JPanel();
        panelContenido.setBackground(Color.BLUE);
        panelContenido.setLayout(new GridLayout(2,2,10,10));
        c.gridx = 1;
        c.weightx = 0.5; // 70% del ancho
        this.add(panelContenido, c);
        updatearVisual();

    }
    public void updatearVisual(){
        panelContenido.removeAll();
        for (int i = 0; i<4; i++){
            if(refugio.getStock().size()<=i){
                panelContenido.add(PanelCreator.Vacio.crear());
                continue;
            }
            Mascota m = refugio.getStock().get(i);
            panelContenido.add(new subPanelMasc_Ref(m,i,this));
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(new ImageIcon("src/main/resources/fondorefugio.png").getImage(),0,0,null);
        disponible= Usuario.getInstance().getMascota()==null;
        disponible = (disponible&&!adoptado);
    }

    public void adoptarMascota(String nombre,int index){
        refugio.adoptarAnimal(index, nombre);
        adoptado=true;
        actualizar();
        PanelBase.actualizarPanelAcciones();
    }

    public void actualizarStock(){
        refugio.actualizarStock(4);
        actualizar();
    }

    public void actualizar() {
        updatearVisual();
        revalidate();
        repaint();
    }

    public void timeUpdate() {
        tiempo++;
        if (tiempo>2 && !disponible){
            tiempo=0;
            actualizarStock();
            adoptado=false;
        }
    }
}
