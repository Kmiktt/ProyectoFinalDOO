package org.example.Logica;

import java.util.Random;

abstract public class Mascota {
    public String nombre;
    public Stat hambre;
    public Stat higiene;
    public Stat salud;
    public Stat felicidad;
    public String ubicacion;
    public int aspecto;
    public Mascota(String s, String ubi, int skin){
        hambre = new Stat(80,50,100,1);
        higiene = new Stat(80,30,100,5);
        salud = new Stat(80,70,100,3);
        felicidad = new Stat(80,100,100,3);
        nombre = s;
        ubicacion = ubi;
        aspecto = skin;

    }
    public void jugar(){
        felicidad.aumentarStat();
    }
    public void alimentar(){
        hambre.aumentarStat();
    }
    public void sanar(){
        salud.aumentarStat();
    }
    public void limpiar(){
        higiene.aumentarStat();
    }
    public void update(){
        double x = Math.random();
        if (x>0.8) hambre.decrecer();
        x = Math.random();;
        if (x>0.4) higiene.decrecer();
        x = Math.random();;
        if (x>0.2) salud.decrecer();
        x = Math.random();;
        if (x>0.4) felicidad.decrecer();
    }
    @Override
    public String toString(){
        return (nombre+" || H: "+hambre+" - Hig: "+higiene + " - Sal:"+ salud + " - Fel: "+felicidad);
    }

}

class Gato extends Mascota{
    public Gato(String s, String u, int a){
        super(s,u,a);
        Atributos atri=Atributos.GATO;
        hambre = new Stat(80,50,90,1);
        higiene = new Stat(80,30,50,5);
        salud = new Stat(80,70,70,3);
        felicidad = new Stat(80,100,170,3);
    }
}