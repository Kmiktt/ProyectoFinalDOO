package org.example.Logica.Mascotas;

import org.example.Logica.Atributos;

public class Perro extends Mascota {
    public Perro(String s, int a) {
        super(s, a, Atributos.PERRO);
        this.hambre = atri.getHambre();
        this.higiene = atri.getHigiene();
        this.salud = atri.getSalud();
        this.felicidad = atri.getFelicidad();
    }

    @Override
    public Mascota clonar() {
        return new Perro(this.nombre, this.aspecto);
    }
}
