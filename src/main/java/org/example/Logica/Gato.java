package org.example.Logica;

public class Gato extends Mascota{
    public Gato(String s, String u, int a){
        super(s,u,a,Atributos.GATO);
        this.hambre = atri.getHambre();
        this.higiene = atri.getHigiene();
        this.salud = atri.getSalud();
        this.felicidad = atri.getFelicidad();
    }
}
