package org.example.Logica;
import java.util.ArrayList;
public class Fila <T>{
    private ArrayList<T> fi;
    public  Fila(){
        fi = new ArrayList<T>();
    }
    /**
     * @param b objeto tipo T que sera agregado al final del arraylist
     */
    public void add(T b){
        fi.add(b);
    }
    /**
     * @return El primer objeto ingresado (FIFO)
     */
    public T get(){
        if ((!fi.isEmpty())) return fi.removeFirst();
        else return null;
    }
    public T indGet(int i){
        return fi.get(i);
    }
    public int getSize(){
        return fi.size();
    }
}
