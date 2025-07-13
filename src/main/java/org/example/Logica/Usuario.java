package org.example.Logica;

import java.util.ArrayList;

//singleton
public class Usuario {
    private static Usuario instancia;
    private Mascota manomascota;
    private Consumible manoobjeto;
    private int dinero;
    public int velocidad;
    public int comidaIndex=1;
    private ArrayList<Consumible> inventario;
    private Usuario() {
        inventario= new ArrayList<Consumible>();
        velocidad = 1;
    }

    /**Esta es una implementation del patron de diseño SINGLETON
     * lo vimos util para este proyecto, ya que siempre se espera que haya un solo usuario activo a la vez
     * */
    public static Usuario getInstance() {
        if (instancia == null) {
            instancia = new Usuario();
        }
        return instancia;
    }

    /** Este metodo hace que el usuario agarre el objeto especificado por el parametro
     *
     * @param o el objeto el cual quieres tener en la mano
     * @return el objeto que tenia en la mano
     */
    public Consumible tomarObjeto(Consumible o){
            Consumible a=manoobjeto;
            manoobjeto=o;
            return a;
    }

    /** Agarra un objeto que ya tenías guardado en tu inventario
     * si es que ya tenías un objeto en la mano, estos objetos son intercambiados
     * resultando en que el objeto que seleccionaste sea el objeto que agarres finalmente
     * @param i el índice del objeto que quieres tomar del inventario
     */
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

    /** Le da el objeto que tienes en la mano a la mascota que quieras
     *
     * @param masc la mascota a la cual quieres darle el objeto
     */
    public void darObjeto(Mascota masc){
        manoobjeto=masc.tomarObjeto(manoobjeto);
    }
    /** Agrega un objeto a el inventario
     *
     * @param a El objeto que quieres agregar
     */
    public void agregarObjeto(Consumible a){
        inventario.add(a);
        inventario.sort(null);
    }

    //cuenta cuantos de un objeto tienes con el string de su tipo
    public int cuantoObjeto(String s){
        int num=0;
        for (Consumible consumible : inventario) {
            if (consumible.getTipo().equals(s)) {
                num++;
            }
        }
        return num;
    }

    /**
     *
     * @param g el tipo de objeto que quieres sacar del inventario
     */
    public void quitarObjeto(String g){
        for (Consumible consumible : inventario) {
            if (consumible.getTipo().equals(g)) {
                inventario.remove(consumible);
                break;
            }
        }
    }

    /** Retorna la referencia a el Inventario del Usuario
     *
     * @return El ArrayList del inventario
     */
    public ArrayList<Consumible> getInventario() {
        return inventario;
    }

    /** Restas dinero del Usuario
     * @param d la cantidad que quieres descontar a el dinero
     */
    public void restarDinero(int d) throws SinSuficienteDineroException{
        if (dinero<d) {
            throw new SinSuficienteDineroException();
        }
        else {
            dinero -= d;
        }
    }
    /** Suma dinero a el Usuario
     */
    public void recibirDinero(int d){
        dinero+=d;
    }

    /**Retorna el dinero que le queda al usuario
     * @return Dinero del Usuario
     */
    public int getDinero(){
        return dinero;
    }

    /** El usuario agarra una mascota para moverla a algun otro lugar
     *
     * @param a la mascota la cual quieres agarrar
     * @return  la misma mascota si es que esta fue rechazada por la mano
     */
    public Mascota tomarMascota(Mascota a){
        if (manomascota==null) {
            manomascota = a;
            return null;
        }
        else {
            return a;
        }
    }

    /** Le da la mascota en mano al objeto que puede recibir una mascota
     *  si es que el objeto se lo rechaza entonces esta mascota se devuelve a la mano
     * @param toma El objeto que recibirá la mascota
     */
    public void colocarMascota(TomaMascota toma){
        manomascota=toma.agregarMascota(manomascota);
    }

    /**Retorna la mascota que el usuario tiene agarrada
     * @return la mascota agarrada
     */
    public Mascota getMascota(){
        return manomascota;
    }

}
