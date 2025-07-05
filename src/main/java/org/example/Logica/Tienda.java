package org.example.Logica;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;

public class Tienda <T> {
    private ArrayList<T> stock;
    private ArrayList<T> productos;
    private ArrayList<Integer> preciosproductos;
    private ArrayList<Integer> precios;
    public Tienda(){
        productos=new ArrayList<T>();
        stock=new ArrayList<T>();
        preciosproductos=new ArrayList<Integer>();
        precios=new ArrayList<Integer>();
    }

    //cambia el stock disponible actualmente
    public void actualizarStock(int tamano) {
        Random random = new Random();
        ArrayList<T> auxa = new ArrayList<T>();
        ArrayList<Integer> auxb = new ArrayList<Integer>();
        //se asegura que los productos ingresables no son nulos
        if(!productos.isEmpty()){
            for (int i = 0; i < tamano; i++) {
                int l=random.nextInt(productos.size());
                auxa.add(productos.get(l));
                auxb.add(preciosproductos.get(l));
            }
        }
        stock=auxa;
        precios=auxb;
    }

    //agrega un producto a la lista de productos posibles
    public void agregarProducto(T a,int precio){
        productos.add(a);
        preciosproductos.add(precio);
    }

    //le agrega un objeto especifico a un stock
    public void agregarStock(T a,int precio){
        stock.add(a);
        precios.add(precio);
    }

    public ArrayList<T> getStock(){
        return stock;
    }
    public ArrayList<Integer> getPrecios(){
        return precios;
    }

    //aqui te lo retorna si te alcanza
    public T comprarProducto(int i){

        T a=null;
        if ((Usuario.getInstance().getDinero()-precios.get(i))>=0){
            Usuario.getInstance().restarDinero(getPrecios().get(i));
            getPrecios().remove(i);
            a=getStock().remove(i);
        }
        return a;
    }
    //aqui solo te lo retorna si el espacio T esta vacio
    public T comprarProducto(int i,T p){
        T a=null;
        if (p==null && (Usuario.getInstance().getDinero()-precios.get(i))>=0) {
            Usuario.getInstance().restarDinero(getPrecios().get(i));
            getPrecios().remove(i);
            a=getStock().remove(i);
        }
        return a;
    }

}
