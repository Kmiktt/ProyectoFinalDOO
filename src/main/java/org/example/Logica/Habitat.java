package org.example.Logica;
import java.util.ArrayList;
public class Habitat implements TomaMascota {
    private ArrayList<Mascota> animales;
    private String tipo;
    private int tamano;
    public Habitat(String ti,int tamano){
        tipo=ti;
    }
    public Mascota getmascota(int i)
    {
         try{
             return animales.get(i);
         }
         catch (ArrayIndexOutOfBoundsException e){
             return null;
         }
    }

    //aqui no se si es mejor tomar por index o tomar por objeto
    public void darMascota(int i){
        Mascota a;
        try{
            a=animales.remove(i);
        }
        catch (ArrayIndexOutOfBoundsException e){
            a=null;
        }
        //aqui depende de que el Habitat haya sido creado despues de el usuario
        Usuario.getInstance().tomarMascota(a);
    }
    public Mascota agregarMascota(Mascota ma)
    {
        if (animales.size()+1>tamano) {
            return ma;
        }
        else {
            return null;
        }
    }

}