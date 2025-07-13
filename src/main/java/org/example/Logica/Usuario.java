package org.example.Logica;

import org.example.Logica.Consumibles.Consumible;
import org.example.Logica.Mascotas.Mascota;

import java.util.ArrayList;
import java.util.Objects;

/**Objeto que tiene todos los datos del Usuario, estos incluye dinero, inventario, objeto y mascota agarrados
 * este objeto puede hacer distintas operaciones con los objetos en su inventario y en su mano
 */
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
    /** Esto resetea el singleton a uno nulo
     */
    public static void reset() {
        instancia=null;
    }
    /** Este método hace que el usuario agarre el objeto especificado por el parameter
     *  si es que ya tenia un objeto en mano este se guarda en el inventario y el objeto seleccionado lo reemplaza
     * @param o el objeto el cual quieres tener en la mano
     */
    public void tomarObjeto(Consumible o){
            Consumible a=manoobjeto;
            manoobjeto=o;
            agregarObjeto(a);
    }
    /** Agarra un objeto que ya tenías guardado en tu inventario
     * si es que ya tenías un objeto en la mano, estos objetos son intercambiados
     * resultando en que el objeto que seleccionaste sea el objeto que agarres finalmente
     * @param i el String asociado del objeto que quieres tomar del inventario
     */
    public void sacarInventario(String i){
        Consumible c=null;
        for (Consumible consumible : inventario) {
            if (consumible.getTipo().equals(i)) {
                c=consumible;
                inventario.remove(consumible);
                break;
            }
        }
        tomarObjeto(c);
    }
    /** Le da el objeto que tienes en la mano a la mascota que quieras
     *
     * @param masc la mascota a la cual quieres darle el objeto
     */
    public void darObjeto(Mascota masc){
        manoobjeto=masc.tomarObjeto(manoobjeto);
    }
    /** Agrega un objeto a el inventario
     * @param a El objeto que quieres agregar
     */
    public void agregarObjeto(Consumible a){
        inventario.add(a);
        inventario.removeIf(Objects::isNull);
        inventario.sort(null);
    }
    /**Cuenta cuantos objetos de un tipo tienes en el inventario
     * @param s El tipo de objeto que quieres contar
     * @return  la cantidad del objeto que tienes en el inventario
     */
    public int cuantoObjeto(String s){
        int num=0;
        for (Consumible consumible : inventario) {
            if (consumible.getTipo().equals(s)) {
                num++;
            }
            else if (num>0){
                break;
            }
        }
        return num;
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
     * @param d la cantidad que quieres sumar a el dinero
     */
    public void recibirDinero(int d){
        dinero+=d;
    }
    /** El usuario agarra una mascota para moverla a algun otro lugar
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

    /**Retorna el dinero que le queda al usuario
     * @return Dinero del Usuario
     */
    public int getDinero(){
        return dinero;
    }
    /**Retorna la mascota que el usuario tiene agarrada
     * @return la mascota agarrada
     */
    public Mascota getMascota(){
        return manomascota;
    }
    /** Retorna la referencia a el Inventario del Usuario
     * @return El ArrayList del inventario
     */
    public ArrayList<Consumible> getInventario() {
        return inventario;
    }
    /**Retorna el objeto que el usuario tiene en la mano
     * @return el objeto agarrado
     */
    public Consumible getMano(){
        return manoobjeto;
    }
}
