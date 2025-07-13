package org.example.Logica.Mascotas;

import org.example.Logica.Atributos;
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

    public Mascota(String s, int skin, Atributos a){
        nombre = s;
        atri=a;
        aspecto = skin;
        Fticks=0;
    }
    public String getNombre(){
        return nombre;
    }

    public String getHabitat(){
        return atri.getHabitat();
    }

    public String getTipo(){
        return atri.getEspecie();
    }

    public int getAspecto(){
        return aspecto;
    }

    //getters de stats
    public int getHambre(){
        return hambre;
    }
    public int getFelicidad() {
        return felicidad;
    }
    public int getSalud() {
        return salud;
    }
    public int getHigiene() {
        return higiene;
    }

    public Atributos getAtri() {
        return atri;
    }


    //ACTIVIDADES
    public void jugar(){
        felicidad = felicidad + 30;
        felicidad = Math.min(felicidad,atri.getFelicidad());}

    public void alimentar(String a){
        hambre = hambre + 20;
        if(Objects.equals(a, atri.getComida())) hambre = hambre + 10;
        hambre = Math.min(hambre,atri.getHambre());
    }

    public void sanar(){
        salud = salud + 20;
        salud = Math.min(salud,atri.getSalud());
    }

    public void limpiar(){
        higiene = higiene + 20;
        higiene = Math.min(higiene,atri.getHigiene());
    }

    /**Actualiza el estado a el siguiente siclo)
     *
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
    public Consumible tomarObjeto(Consumible o){
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

