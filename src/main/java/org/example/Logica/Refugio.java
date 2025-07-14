package org.example.Logica;

import org.example.Logica.Mascotas.*;

import java.util.ArrayList;
import java.util.Random;

public class Refugio{
    private ArrayList<Mascota> stock;
    private ArrayList<String> mascotas;

    /**Constructor del Objeto Refugio
     */
    public Refugio(){
        stock=new ArrayList<Mascota>();
        mascotas=new ArrayList<String>();
    }
    /** Actualiza las especies de mascota que pueden aparecer en el refugio
     */
    public void actualizarAnimales(){
        ArrayList<String> auxa= new ArrayList<String>();
        for (int i = 0; i < Habitat.getInstancias().size(); i++) {
            for (Atributos a:Atributos.values()){
                if (a.getHabitat().equals(Habitat.getInstancias().get(i).getTipo())){
                    auxa.add(a.getEspecie());
                }
            }
        }
        mascotas=auxa;
    }
    /** Repone la cantidad de animales que aparecen en el refugio
     * @param size la cantidad de animales que van a haber en el restock
     */
    public void actualizarStock(int size) {
        actualizarAnimales();
        Random random = new Random();
        ArrayList<Mascota> auxa = new ArrayList<Mascota>();
        Mascota auxc;
        if(!mascotas.isEmpty()){
            for (int i = 0; i < size; i++) {
                int l=random.nextInt(mascotas.size());
                auxc = switch (mascotas.get(l)) {
                    //las mascotas son creadas con nombres placeholder
                    case "gato" -> new Gato("Kris", 0);
                    case "perro" -> new Perro("Susie", 0);
                    case "pterodáctilo" -> new Pterodactilo("Ralsei", 0);
                    case "ajolote" -> new Ajolote("Noelle", 0);
                    case "pez" -> new Pez("Undyne", 0);
                    case "pájaro" -> new Canario("Burghley", 0);
                    default -> new Gato("December", 0);
                };
                auxc.randomizarStat();
                auxa.add(auxc);
            }
        }
        stock=auxa;
    }

    /**Adopta una mascota y la coloca en las manos del usuario
     * @param i el índice de la mascota que se quiere adoptar
     * @param nomb el nombre que se le dara a la mascota
     */
    public void adoptarAnimal(int i,String nomb){
        if (Usuario.getInstance().getMascota()==null) {
            stock.get(i).setNombre(nomb);
            Usuario.getInstance().tomarMascota(stock.remove(i));
        }
    }

    /**Retorna el ArrayList del Stock de mascotas actual
     * @return el ArrayList del stock de mascotas
     */
    public ArrayList<Mascota> getStock(){
        return stock;
    }
}
