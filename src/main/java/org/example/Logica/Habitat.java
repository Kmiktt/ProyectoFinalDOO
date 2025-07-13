package org.example.Logica;
import org.example.Logica.Mascotas.Mascota;

import java.util.ArrayList;
public class Habitat implements TomaMascota {
    private ArrayList<Mascota> animales;
    private String tipo;
    private final int tamano = 6;
    private static final ArrayList<Habitat> instancias = new ArrayList<Habitat>();

    public Habitat(String ti){
        animales = new ArrayList<Mascota>();
        tipo=ti;
        instancias.add(this);
    }

    public Mascota getMascota(int i)
    {
         try{
             return animales.get(i);
         }
         catch (ArrayIndexOutOfBoundsException e){
             return null;
         }
    }

    public Mascota darMascota(int i){
        Mascota a;
        try{
            a=animales.remove(i);
        }
        catch (ArrayIndexOutOfBoundsException e){
            a=null;
        }
        return a;
    }

    public int size(){
        return animales.size();
    }

    public Mascota agregarMascota(Mascota ma)
    {
        if (animales.size()+1>tamano || !(ma.getHabitat().equals(tipo))) {
            return ma;
        }
        else {
            animales.add(ma);
            return null;
        }
    }

    public static ArrayList<Habitat> getInstancias() {
        return instancias;
    }

    public String getTipo() {
        return tipo;
    }
}