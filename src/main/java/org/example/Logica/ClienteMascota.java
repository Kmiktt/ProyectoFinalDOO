package org.example.Logica;
import java.util.Random;

import static java.lang.Math.min;

public class ClienteMascota implements TomaMascota{
    private String tipo;
    private int ticks;
    public ClienteMascota(){
        ActualizarMascota();
    }
    public Mascota agregarMascota(Mascota ma)
    {
        if (!(ma.getTipo().equals(tipo))) {
            return ma;
        }
        else {
            Usuario.getInstance().recibirDinero(cuantoPaga(ma));
            return null;
        }
    }
    //este metodo cambiara la mascota que quiere y reinicia su paciencia
    public void ActualizarMascota(){
        Random r = new Random();
        Atributos[] atr=Atributos.values();
        tipo=atr[r.nextInt(atr.length)].getEspecie();
        ticks=0;
    }

    public int cuantoPaga(Mascota ma){
        //lo de los ticks hace que pueda perder hasta la mitad de el precio si es que el
        //cliente pierde la paciencia
        int mon=1000*((100-ticks)/100);
        //le resta de 0 a 400 pesos a la cantidad de dinero que ganara el usuario dependiendo
        //de que tan bien cuidada es la mascota
        mon-=(1-ma.getSalud()/ma.getAtri().getSalud())*100;
        mon-=(1-ma.getFelicidad()/ma.getAtri().getFelicidad())*100;
        mon-=(1-ma.getHigiene()/ma.getAtri().getHigiene())*100;
        mon-=(1-ma.getHambre()/ma.getAtri().getHambre())*100;
        //multiplicador dependiendo de por cuantos ticks a estado feliz
        mon=mon*((min(25,ma.getFticks())))/25;
        return mon;
    }

    public void update(){
        ticks+=1;
        if (ticks>=50){
            ActualizarMascota();
        }
    }

    public void setTipo(String s){
        tipo=s;
    }

    public String getTipo(){
        return tipo;
    }
    public int getTicks(){
        return ticks;
    }
}
