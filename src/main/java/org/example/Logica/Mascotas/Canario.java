package org.example.Logica.Mascotas;

import org.example.Logica.Atributos;

public class Canario extends Mascota {
    public Canario(String s, int a) {
        super(s, a, Atributos.CANARIO);
        this.hambre = atri.getHambre();
        this.higiene = atri.getHigiene();
        this.salud = atri.getSalud();
        this.felicidad = atri.getFelicidad();
    }
}
