package org.example.Logica;

import java.util.ArrayList;
import java.util.Random;

public class Tienda <T> {
    private ArrayList<T> stock;
    private ArrayList<T> productos;
    private ArrayList<Integer> preciosproductos;
    private ArrayList<Integer> precios;
    /**Constructor del Objeto tienda
     */
    public Tienda(){
        productos=new ArrayList<T>();
        stock=new ArrayList<T>();
        preciosproductos=new ArrayList<Integer>();
        precios=new ArrayList<Integer>();
    }

    /**Repone los objetos que están en el stock de la tiendaa
     * @param tamano la cantidad de objetos que seran repuestos
     */
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

    /** Agrega un Objeto a la lista de productos que pueden aparecer en la tienda
     * @param a el objeto que quieres agregar a la lista de productos
     * @param precio el precio de el producto que vas a agregar
     */
    public void agregarProducto(T a,int precio){
        productos.add(a);
        preciosproductos.add(precio);
    }

    /** Agrega un producto específico al stock actual de objetos en la tienda
     * @param a Objeto que quieres agregar
     * @param precio Precio del Objeto
     */
    public void agregarStock(T a,int precio){
        stock.add(a);
        precios.add(precio);
    }

    /**Getter del Stock en la tienda
     * @return ArrayList del Stock actual
     */
    public ArrayList<T> getStock(){
        return stock;
    }
    /**Getter de los Productos que se pueden vender
     * @return ArrayList de los Productos que puede vender
     */
    public ArrayList<T> getProductos(){
        return productos;
    }
    /**Getter de los Precios del Stock actual
     * @return Los precios del Stock actual
     */
    public ArrayList<Integer> getPrecios(){
        return precios;
    }

    /**Comprar un producto especificado
     * @param i el indice del producto elegido
     * @return el producto que elegiste
     */
    public T comprarProducto(int i){

        T a=null;
        if ((Usuario.getInstance().getDinero()-precios.get(i))>=0){
            Usuario.getInstance().restarDinero(getPrecios().get(i));
            getPrecios().remove(i);
            a=getStock().remove(i);
        }
        return a;
    }
}
