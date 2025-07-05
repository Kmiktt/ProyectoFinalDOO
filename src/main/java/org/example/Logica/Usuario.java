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
    //TOMA UN OBJETO Y LO DEJA EN SU MANO
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
    //TOMA UN OBJETO DEL INVENTARIO Y LO DEJA EN SU MANO
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
    //LE DA UN OBJETO A UNA MASCOTA
    public void darObjeto(Mascota masc){
        manoobjeto=masc.tomarObjeto(manoobjeto);
    }

    public void agregarObjeto(Consumible a){
        inventario.add(a);
    }

    public ArrayList<Consumible> getInventario() {
        return inventario;
    }

    //aqui podria haber un assert de (noSuficienteDinero) o algo asi
    public void restarDinero(int d){
        dinero-=d;
    }

    public void recibirDinero(int d){
        dinero+=d;
    }

    public int getDinero(){
        return dinero;
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
    public Mascota getMascota(){
        return manomascota;
    }
}
