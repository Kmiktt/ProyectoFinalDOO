package org.example.Logica;

import java.util.ArrayList;

//singleton
public class Usuario {
    private static Usuario instancia;
    private Mascota manomascota;
    private Consumible manoobjeto;
    private int dinero;
    private ArrayList<Consumible> inventario;
    private Usuario() {
        inventario= new ArrayList<Consumible>();
    }

    public static Usuario getInstance() {
        if (instancia == null) {
            instancia = new Usuario();
        }
        return instancia;
    }

    public Consumible tomarObjeto(Consumible o){
        if (manoobjeto==null){
            manoobjeto=o;
            return null;
        }
        else {
            Consumible a=manoobjeto;
            manoobjeto=o;
            return a;
        }
    }
    public void sacarInventario(int i){
        Consumible a;
        try{
            a=inventario.remove(i);
        }
        catch (ArrayIndexOutOfBoundsException e){
            a=null;
        }
        inventario.add(tomarObjeto(a));
    }

    public void darObjeto(Mascota masc){
        manoobjeto=masc.tomarObjeto(manoobjeto);
    }


    public void recibirDinero(int d){
        dinero+=d;
    }

    public Mascota tomarMascota(Mascota a){
        if (manomascota==null) {
            manomascota = a;
            return null;
        }
        else return a;
    }

    public void colocarMascota(TomaMascota toma){
        manomascota=toma.agregarMascota(manomascota);
    }
}
