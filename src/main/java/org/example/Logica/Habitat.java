package org.example.Logica;
import org.example.Logica.Mascotas.*;

import java.util.ArrayList;
public class Habitat implements TomaMascota {
    private ArrayList<Mascota> animales;
    private String tipo;
    private final int tamano = 6;
    private static final ArrayList<Habitat> instancias = new ArrayList<Habitat>();
    /** Constructor de la clase Habitat
     * @param ti el tipo de Habitat que quieres que sea
     */
    public Habitat(String ti){
        animales = new ArrayList<Mascota>();
        tipo=ti;
        instancias.add(this);
    }
    /** retorna referencia de una mascota en el Habitat sin sacarla
     * @param i el indice de la mascota
     * @return  Mascota seleccionada
     */
    public Mascota getMascota(int i)
    {
         try{
             return animales.get(i);
         }
         catch (IndexOutOfBoundsException e){
             return null;
         }
    }
    /**Sacas una mascota del Habitat
     * @param i el indice de la mascota
     * @return la mascota seleccionada
     */
    public Mascota darMascota(int i){
        Mascota a;
        try{
            a=animales.remove(i);
        }
        catch (IndexOutOfBoundsException e){
            a=null;
        }
        return a;
    }
    /**Retorna cuantos animales puede recibir el habitat
     * @return la cantidad de animales que puede tener
     */
    public int size(){
        return animales.size();
    }
    /** Agregas una mascota al habitat, te devuelve la mascota si es que esta fue rechazada
     *
     * @param ma la mascota que quieres depositar
     * @return La mascota rechazada
     */
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
    /**te da una lista de todas las instancais de Habitat que fueron creadas
     * @return Arraylist con las instancias de habitat
     */
    public static ArrayList<Habitat> getInstancias() {
        return instancias;
    }
    /**Este método está por motivos de Prueba, reinicia la variable instancias
     */
    public static void resetInstancias() {
        instancias.removeAll(instancias);
    }
    /**Retorna que tipo de mascota recibe el habitat
     * @return string del tipo de habitat
     */
    public String getTipo() {
        return tipo;
    }
}