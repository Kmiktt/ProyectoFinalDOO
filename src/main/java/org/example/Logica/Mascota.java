package org.example.Logica;

import org.example.GUI.PanelHabitat;

import java.util.Objects;
import java.util.Random;

abstract public class Mascota {
    public String nombre;
    public int hambre;
    public int higiene;
    public int salud;
    public int felicidad;
    public int Fticks;
    public Habitat ubicacion;
    public int aspecto;
    public Atributos atri;

    public Mascota(String s, int skin, Atributos a){
        nombre = s;
        atri=a;
        aspecto = skin;
        Fticks=0;
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

    //getters de stats
    public int getHambre(){
        return hambre;
    }
    public int getFelicidad() {
        return felicidad;
    }
    public int getSalud() {
        return salud;
    }
    public int getHigiene() {
        return higiene;
    }

    public Atributos getAtri() {
        return atri;
    }


    //ACTIVIDADES
    public void jugar(){
        felicidad = felicidad + 30;
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
        Random r = new Random();
        felicidad = Math.max(felicidad-r.nextInt(1,r.nextInt(5)+2),0);
        hambre = Math.max(hambre-r.nextInt(0,r.nextInt(10)+1),0);
        if (r.nextInt(5)==4) salud = Math.max(salud-r.nextInt(5,15),0);
        if(r.nextInt(3)==2) higiene = Math.max(higiene-r.nextInt(2,r.nextInt(3,10)),0);
        if (felicidad/atri.getFelicidad()>=0.6){
            Fticks+=1;
        }
        else{
            if (Fticks!=0){
                Fticks-=1;
            }
        }
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
    public int getFticks(){
        return Fticks;
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

class Ajolote extends Mascota{
    public Ajolote(String s, int a){
        super(s,a,Atributos.AJOLOTE);
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

class Pterodactilo extends Mascota{
    public Pterodactilo(String s, int a){
        super(s,a,Atributos.PTERODACTILO);
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

