package org.example.Logica.Mascotas;

import org.example.Logica.Atributos;

public class Pterodactilo extends Mascota {
    public Pterodactilo(String s, int a) {
        super(s, a, Atributos.PTERODACTILO);
        this.hambre = atri.getHambre();
        this.higiene = atri.getHigiene();
        this.salud = atri.getSalud();
        this.felicidad = atri.getFelicidad();
    }
}
