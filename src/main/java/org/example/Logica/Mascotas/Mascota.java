package org.example.Logica.Mascotas;

import org.example.Logica.Atributos;
import org.example.Logica.ConsumibleNuloException;
import org.example.Logica.Consumibles.Consumible;
import org.example.Logica.Habitat;

import java.util.Objects;
import java.util.Random;

abstract public class Mascota {
    private String nombre;
    public int hambre;
    public int higiene;
    public int salud;
    public int felicidad;
    public int Fticks;
    public Habitat ubicacion;
    public int aspecto;
    public Atributos atri;

    /**Constructor del Objeto Mascota
     * @param s Nombre de la mascota
     * @param skin numero de apariencia
     * @param a Atributos de la especie
     */
    public Mascota(String s, int skin, Atributos a){
        nombre = s;
        atri=a;
        aspecto = skin;
        Fticks=0;
    }
    /**Getter del Nombre
     * @return String del Nombre
     */
    public String getNombre(){
        return nombre;
    }
    /**Getter del tipo Habitat
     * @return String del tipo de Habitat
     */
    public String getHabitat(){
        return atri.getHabitat();
    }
    /**Getter de Especie
     * @return String de la especie
     */
    public String getTipo(){
        return atri.getEspecie();
    }
    /**Getter del Aspecto
     * @return numero de Apariencia
     */
    public int getAspecto(){
        return aspecto;
    }
    /**Getter de la stat de Hambre
     * @return valor de Hambre
     */
    public int getHambre(){
        return hambre;
    }
    /**Getter de la stat de felicidad
     * @return valor de felicidad
     */
    public int getFelicidad() {
        return felicidad;
    }
    /**Getter de la stat de salud
     * @return valor de salud
     */
    public int getSalud() {
        return salud;
    }
    /**Getter de la stat de Higiene
     * @return valor de Higiene
     */
    public int getHigiene() {
        return higiene;
    }
    /**Getter de los Atributos de la especie
     * @return Atributos de la Especie en forma de Enum
     */
    public Atributos getAtri() {
        return atri;
    }
    //estos dos métodos son llamados internamente por tomarObjeto, ya que asi procesa los consumibles
    private void alimentar(String a){
        hambre = hambre + 20;
        if(Objects.equals(a, atri.getComida())) hambre = hambre + 10;
        hambre = Math.min(hambre,atri.getHambre());
    }
    private void sanar(){
        salud = salud + 20;
        salud = Math.min(salud,atri.getSalud());
    }

    /**Aumenta la estadística de felicidad
     */
    public void jugar(){
        felicidad = felicidad + 30;
        felicidad = Math.min(felicidad,atri.getFelicidad());}
    /**Aumenta la estadística de Higiene
     */
    public void limpiar(){
        higiene = higiene + 20;
        higiene = Math.min(higiene,atri.getHigiene());
    }
    /**Actualiza el estado al del siguiente ciclo
     */
    public void update(){
        Random r = new Random();
        felicidad = Math.max(felicidad-r.nextInt(1,r.nextInt(5)+2),0);
        hambre = Math.max(hambre-r.nextInt(0,r.nextInt(10)+1),0);
        if (r.nextInt(5)==4) salud = Math.max(salud-r.nextInt(5,15),0);
        if(r.nextInt(3)==2) higiene = Math.max(higiene-r.nextInt(2,r.nextInt(3,10)),0);
        if ((float)felicidad/(float)atri.getFelicidad()>=0.6){
            Fticks+=1;
        }
        else{
            if (Fticks!=0){
                Fticks-=1;
            }
        }
    }
    /**La mascota recibe un objeto y lo procesa
     * si es que no lo puede procesar entonces lo devuelve
     * @param o El consumible que procesara
     * @return  El consumible rechazado
     */
    public Consumible tomarObjeto(Consumible o) throws ConsumibleNuloException {
        if (o==null) throw new ConsumibleNuloException();
        //si es que es una medicina, si es usable entonces lo usa, sino se lo devuelve
        if (o.getTipo().equals("medicina")){
            //esta es la condicion para que se tome la medicina (puede cambiarse despues)
            if (salud<atri.getSalud()-10){
            sanar();
            }
            else {
                return o;
            }
        }
        else{
            //hasta ahora si no es medicina generica entonces es un alimento asi que se lo come
            alimentar(o.getTipo());
        }
        //si es que "absorbio" el objeto entonces no se lo devuelve
        return null;
    }

    /**Retorna la cantidad de ciclos que ha estado con una felicidad alta
     * @return la cantidad de ciclos que ha estado con una felicidad alta
     */
    public int getFticks(){
        return Fticks;
    }
    /**Asigna Nombre a la mascota
     * @param s String del nombre
     */
    public void setNombre(String s){
        nombre=s;
    }
    /** Vuelve cada atributo de la mascota un valor al azar en el rango del maximo
     */
    public void randomizarStat(){
        Random random = new Random();
        hambre = random.nextInt(atri.getHambre());
        salud = random.nextInt(atri.getSalud());
        higiene = random.nextInt(atri.getHigiene());
        felicidad = random.nextInt(atri.getFelicidad());
    }

    @Override
    public String toString() {
        return nombre+" "+atri.getEspecie()+" : Hambre: "+ hambre+" - Higiene: "+higiene+" - Salud: "+salud+" - Felicidad: "+felicidad;
    }
}

