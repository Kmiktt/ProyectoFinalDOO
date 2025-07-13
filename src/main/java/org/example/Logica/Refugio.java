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
            switch (Habitat.getInstancias().get(i).getTipo()) {
                case "terrestre" -> {
                    auxa.add("perro");
                    auxa.add("gato");
                    continue;
                }
                case "acuático" -> {
                    auxa.add("pez");
                    auxa.add("ajolote");
                    continue;
                }
                case "aereo" -> {
                    auxa.add("pájaro");
                    //no se mas animales de aire
                    auxa.add("pterodáctilo");
                }
            }
        }
        mascotas=auxa;
    }

    public void actualizarStock(int size) {
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
                    case "pájaro" -> new Pez("Burghley", 0);
                    default -> new Gato("December", 0);
                };
                randomizarStat(auxc);
                auxa.add(auxc);
            }
        }
        stock=auxa;
    }
    private void randomizarStat(Mascota m){
      Random random = new Random();
      m.hambre = random.nextInt(m.atri.getHambre());
      m.salud = random.nextInt(m.atri.getSalud());
      m.higiene = random.nextInt(m.atri.getHigiene());
      m.felicidad = random.nextInt(m.atri.getFelicidad());
    }

    public void adoptarAnimal(int i,String nomb){
        if (Usuario.getInstance().getMascota()==null) {
            stock.get(i).setNombre(nomb);
            Usuario.getInstance().tomarMascota(stock.remove(i));
        }
    }

    public ArrayList<Mascota> getStock(){
        return stock;
    }
}
