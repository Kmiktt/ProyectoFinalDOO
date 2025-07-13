package org.example.Logica.Mascotas;

import org.example.Logica.Atributos;

public class Gato extends Mascota {
    public Gato(String s, int a){
        super(s,a, Atributos.GATO);
        this.hambre = atri.getHambre();
        this.higiene = atri.getHigiene();
        this.salud = atri.getSalud();
        this.felicidad = atri.getFelicidad();
    }
    @Override
    public Mascota clonar() {
        return new Gato(this.nombre,this.aspecto);
    }
}
