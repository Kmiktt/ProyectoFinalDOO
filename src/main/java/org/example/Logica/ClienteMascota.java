package org.example.Logica;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.min;

public class ClienteMascota implements TomaMascota{
    private String tipo;
    private int ticks;
    private ArrayList<String> mascotas;
    public ClienteMascota(){
        mascotas = new ArrayList<String>();
        ActualizarMascota();
    }
    //version que necesita menos mantención de el método que esta en refugio
    public void actualizarAnimales(){
        ArrayList<String> auxa= new ArrayList<String>();
        for (int i = 0; i < Habitat.getInstancias().size(); i++) {
            for (Atributos a:Atributos.values()){
                if (a.getHabitat().equals(Habitat.getInstancias().get(i).getTipo())){
                    auxa.add(a.getEspecie());
                }
            }
        }
        mascotas=auxa;
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
    public void ActualizarMascota() throws NoHayHabitatsException{
        actualizarAnimales();
        Random r = new Random();
        if (mascotas.isEmpty()){
            throw new NoHayHabitatsException();
        }
        else {
            tipo = mascotas.get(r.nextInt(mascotas.size()));
            ticks = 0;
        }

        }
    public int cuantoPaga(Mascota ma){
        double mon = 1000 * ((100.0 - ticks) / 100.0);

        mon -= (1-(double) ma.getSalud() / ma.getAtri().getSalud()) * 100;
        mon -= (1-(double) ma.getFelicidad() / ma.getAtri().getFelicidad()) * 100;
        mon -= (1-(double) ma.getHigiene() / ma.getAtri().getHigiene()) * 100;
        mon -= (1-(double) ma.getHambre() / ma.getAtri().getHambre()) * 100;

        mon *= Math.max(25.0, ma.getFticks()) / 25.0;

        return (int) mon;
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
