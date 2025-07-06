package org.example.Logica;

import java.util.ArrayList;
import java.util.Random;

public class Refugio{
    private ArrayList<Mascota> stock;
    private ArrayList<String> mascotas;
    public Refugio(){
        stock=new ArrayList<Mascota>();
        mascotas=new ArrayList<String>();
    }

    public void actualizarAnimales(){
        ArrayList<String> auxa= new ArrayList<String>();
        for (int i = 0; i < Habitat.getInstancias().size(); i++) {
            if (Habitat.getInstancias().get(i).getTipo().equals("terrestre")){
                auxa.add("perro");
                auxa.add("gato");
                continue;
            }
            if (Habitat.getInstancias().get(i).getTipo().equals("acuático")){
                auxa.add("pez");
                auxa.add("ajolote");
                continue;
            }
            if (Habitat.getInstancias().get(i).getTipo().equals("aereo")){
                auxa.add("pájaro");
                //no se mas animales de aire
                auxa.add("pterodáctilo");
            }
        }
        mascotas=auxa;
    }

    public void actualizarStock(int tamano) {
        Random random = new Random();
        ArrayList<Mascota> auxa = new ArrayList<Mascota>();
        Mascota auxc;
        if(!mascotas.isEmpty()){
            for (int i = 0; i < tamano; i++) {
                int l=random.nextInt(mascotas.size());
                auxc = switch (mascotas.get(l)) {
                    //las mascotas son creadas con nombres placeholder
                    case "gato" -> new Gato("kris", 1);
                    case "perro" -> new Perro("susie", 1);
                    case "pez" -> new Pez("ralsei", 1);
                    default -> new Gato("noelle", 1);
                };
                auxa.add(auxc);
            }
        }
        stock=auxa;
    }
    public void adoptarAnimal(int i,String nomb){
        Mascota a=null;
        if (Usuario.getInstance().getMascota()==null) {
            stock.get(i).setNombre(nomb);
            Usuario.getInstance().tomarMascota(stock.remove(i));
        }
    }

    public ArrayList<Mascota> getStock(){
        return stock;
    }
}
