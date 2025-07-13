package org.example.Logica.Mascotas;

import org.example.Logica.Atributos;

public class Pez extends Mascota {
    public Pez(String s, int a) {
        super(s, a, Atributos.PEZ);
        this.hambre = atri.getHambre();
        this.higiene = atri.getHigiene();
        this.salud = atri.getSalud();
        this.felicidad = atri.getFelicidad();
    }

    @Override
    public Mascota clonar() {
        return new Pez(this.nombre, this.aspecto);
    }
}
