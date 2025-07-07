package org.example.Logica;

import org.example.GUI.PanelHabitat;

import java.util.Objects;

abstract public class Mascota {
    public Consumible obj;
    public String nombre;
    public int hambre;
    public int higiene;
    public int salud;
    public int felicidad;
    public Habitat ubicacion;
    public int aspecto;
    public Atributos atri;
    public Mascota(String s, int skin, Atributos a){
        nombre = s;
        atri=a;
        aspecto = skin;
    }
    public String getNombre(){
        return nombre;
    }

    public String getHabitat(){
        return atri.getHabitat();
    }

    public String getTipo(){
        return atri.getEspecie();
    }

    public int getAspecto(){
        return aspecto;
    }
    //ACTIVIDADES
    public void jugar(String a){
        if(felicidad != this.atri.getFelicidad()) felicidad = felicidad + 20;
        if(Objects.equals(a, atri.getJuego())) felicidad = felicidad + 10;
        felicidad = Math.min(felicidad,atri.getFelicidad());}

    public void alimentar(String a){
        hambre = hambre + 20;
        if(Objects.equals(a, atri.getComida())) hambre = hambre + 10;
        hambre = Math.min(hambre,atri.getHambre());

    }

    public void sanar(){
        salud = salud + 20;
        salud = Math.min(salud,atri.getSalud());
    }

    public void limpiar(){
        higiene = higiene + 20;
        higiene = Math.min(higiene,atri.getHigiene());
    }
    //ACTUALIZAR ESTADO
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

    //DARLE OBJETO
    public Consumible tomarObjeto(Consumible o){
        //si es que es una medicina, si es usable entonces lo usa, sino se lo devuelve
        if (o.getTipo().equals("medicina")){
            //esta es la condicion para que se tome la medicina (puede cambiarse despues)
            if (salud<atri.getSalud()-10){
            sanar();
            }
            else {
                return o;
            }
        }
        else{
            //hasta ahora si no es medicina generica entonces es un alimento asi que se lo come
            alimentar(o.getTipo());
        }
        //si es que "absorbio" el objeto entonces no se lo devuelve
        return null;
    }

    public void setNombre(String s){
        nombre=s;
    }

    public abstract Mascota clonar();

    @Override
    public String toString() {
        return nombre+" "+atri.getEspecie()+" : Hambre: "+ hambre+" - Higiene: "+higiene+" - Salud: "+salud+" - Felicidad: "+felicidad;
    }
}

class Perro extends Mascota{
    public Perro(String s, int a){
        super(s,a,Atributos.PERRO);
        this.hambre = atri.getHambre();
        this.higiene = atri.getHigiene();
        this.salud = atri.getSalud();
        this.felicidad = atri.getFelicidad();
    }

    @Override
    public Mascota clonar() {
        return new Perro(this.nombre,this.aspecto);
    }
}

class Pez extends Mascota{
    public Pez(String s, int a){
        super(s,a,Atributos.PEZ);
        this.hambre = atri.getHambre();
        this.higiene = atri.getHigiene();
        this.salud = atri.getSalud();
        this.felicidad = atri.getFelicidad();
    }

    @Override
    public Mascota clonar() {
        return new Pez(this.nombre,this.aspecto);
    }
}

