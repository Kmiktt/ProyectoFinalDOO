package org.example.Logica;

import org.example.Logica.Mascotas.Perro;

public class MainCliente {
    public static void main(String[] args) {
        Usuario u=Usuario.getInstance();
        //es obligatorio que haya un habitat antes de que el cliente se genere, para que pueda sacar de la lista de habitats
        //que mascotas puede adoptar
        Habitat a=new Habitat("terrestre");
        ClienteMascota cm = new ClienteMascota();
        u.tomarMascota(new Perro("john perro",1));
        //este metodo es basicamente para testear pero le asigna forzosamente cual es la mascota que quiere
        cm.setTipo("perro");

        //aqui solo lo actualiza
        for (int i = 0; i < 10; i++) {
            u.getMascota().update();
            System.out.println(u.getMascota().getSalud());
        }
        //aqui te dice que tipo de animal quiere el cliente
        System.out.println(cm.getTipo());
        //aqui te dice cuanto te pagara por la mascota en tu mano
        System.out.println(cm.cuantoPaga(u.getMascota()));
        //con esto le vendes la mascota a el cliente
        u.colocarMascota(cm);
        //aqui muestra el dinero que ganaste por vender la mascota y revisa que no tiene la mascota en la mano
        System.out.println(u.getDinero());
        System.out.println(u.getMascota());

    }
}
