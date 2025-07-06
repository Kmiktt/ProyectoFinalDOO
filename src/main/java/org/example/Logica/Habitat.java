package org.example.Logica;
import java.util.ArrayList;
public class Habitat implements TomaMascota {
    private ArrayList<Mascota> animales;
    private String tipo;
    private final int tamano = 6;
    public Habitat(String ti){
        animales = new ArrayList<>();
        tipo=ti;
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
        if (animales.size()+1>tamano) {
            return ma;
        }
        else {
            animales.add(ma);
            return null;
        }
    }

}