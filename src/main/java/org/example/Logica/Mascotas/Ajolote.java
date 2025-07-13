package org.example.Logica.Mascotas;

import org.example.Logica.Atributos;

public class Ajolote extends Mascota {
    public Ajolote(String s, int a) {
        super(s, a, Atributos.AJOLOTE);
        this.hambre = atri.getHambre();
        this.higiene = atri.getHigiene();
        this.salud = atri.getSalud();
        this.felicidad = atri.getFelicidad();
    }

    @Override
    public Mascota clonar() {
        return new Ajolote(this.nombre, this.aspecto);
    }
}
