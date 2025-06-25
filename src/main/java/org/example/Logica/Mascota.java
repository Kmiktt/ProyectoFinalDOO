package org.example.Logica;

import java.util.Objects;
import java.util.Random;

abstract public class Mascota {
    public String nombre;
    public int hambre;
    public int higiene;
    public int salud;
    public int felicidad;
    public String ubicacion;
    public int aspecto;
    public Atributos atri;
    public Mascota(String s, String ubi, int skin, Atributos atri){
        nombre = s;
    }
    public void jugar(String a){
        if(felicidad != this.atri.getFelicidad()) felicidad = felicidad + 20;
        if(Objects.equals(a, atri.getJuego())) felicidad = felicidad + 10;}
    public void alimentar(String a){
        hambre = hambre + 20;
        if(Objects.equals(a, atri.getComida())) hambre = hambre + 10;
        if(hambre >= this.atri.getHambre()) hambre = this.atri.getHambre();
    }
    public void sanar(){
        salud = salud + 20;
        if(salud != this.atri.getSalud()) salud = this.atri.getSalud();
    }
    public void limpiar(){
        higiene = higiene + 20;
        if(higiene != this.atri.getHigiene()) higiene = this.atri.getHigiene();
    }
    public void update(){
        //nota: esta parte podría ser mejor, ESP
        if(felicidad != 0) felicidad = felicidad - 3;
        else felicidad = 0;
        if(hambre != 0) hambre = hambre - 3;
        else hambre = 0;
        if(salud != 0) salud = salud - 3;
        else salud = 0;
        if(higiene != 0) higiene = higiene - 3;
        else higiene = 0;
    }
    @Override
    public String toString(){
        return (nombre+" || H: "+hambre+" - Hig: "+higiene + " - Sal:"+ salud + " - Fel: "+felicidad);
    }
}

class Gato extends Mascota{
    public Gato(String s, String u, int a, Atributos atri){
        super(s,u,a,atri);
        this.atri = Atributos.GATO;
        this.hambre = atri.getHambre();
        this.higiene = atri.getHigiene();
        this.salud = atri.getSalud();
        this.felicidad = atri.getFelicidad();
    }
}

class Perro extends Mascota{
    public Perro(String s, String u, int a,Atributos atri){
        super(s,u,a,atri);
        this.atri = Atributos.PERRO;
        this.hambre = atri.getHambre();
        this.higiene = atri.getHigiene();
        this.salud = atri.getSalud();
        this.felicidad = atri.getFelicidad();
    }
}

