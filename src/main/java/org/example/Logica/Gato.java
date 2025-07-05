package org.example.Logica;

public class Gato extends Mascota{
    public Gato(String nombre, String ubicacion, int aspecto){
        super(nombre,ubicacion,aspecto,Atributos.GATO);
        this.hambre = atri.getHambre();
        this.higiene = atri.getHigiene();
        this.salud = atri.getSalud();
        this.felicidad = atri.getFelicidad();
    }
    @Override
    public Mascota clonar() {
        return new Gato(this.nombre,"test",this.aspecto);
    }
}
