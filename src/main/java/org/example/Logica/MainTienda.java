package org.example.Logica;

import java.util.ArrayList;

public class MainTienda {
    public static void main(String[] args) {
        Usuario u=Usuario.getInstance();
        u.recibirDinero(1000);
        //crear tienda
        Tienda<Consumible> tienda=new Tienda<Consumible>();
        //agregar productos
        tienda.agregarProducto(new Pescado(),100);
        tienda.agregarProducto(new Carne(),50);
        tienda.agregarProducto(new ComidaGenerica(),100);
        //restock
        tienda.actualizarStock(10);
        //si quieres que un objeto este siempre en la tienda
        tienda.agregarStock(new Medicina(),50);

        for (int i = 0; i < tienda.getStock().size(); i++) {
            System.out.print(tienda.getStock().get(i) + " ");
            System.out.println(tienda.getPrecios().get(i));
        }

        //compras el segundo objeto de la tienda de objetos
        u.agregarObjeto(tienda.comprarProducto(1));

        System.out.println(u.getInventario());
        System.out.println(u.getDinero());

        //tienda de mascotas (para demostrar la otra manera de comprar)
        Refugio tiendamasc=new Refugio();
        Habitat tierra=new Habitat("terrestre");
        //restock
        tiendamasc.actualizarAnimales();
        tiendamasc.actualizarStock(2);
        for (int i = 0; i < tiendamasc.getStock().size(); i++) {
            System.out.println(tiendamasc.getStock().get(i) + " ");
        }
        //2da forma de usar comprar producto con 2 argumentos
        tiendamasc.adoptarAnimal(0,"sigma skibidi II");

        System.out.println("\n"+u.getMascota());

    }
}
