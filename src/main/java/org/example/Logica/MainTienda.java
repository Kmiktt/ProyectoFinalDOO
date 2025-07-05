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

        //compras el primer objeto de la tienda de objetos
        u.agregarObjeto(tienda.comprarProducto(1));

        System.out.println(u.getInventario());
        System.out.println(u.getDinero());

        //tienda de mascotas (para demostrar la otra manera de comprar)
        Tienda<Mascota> tiendamasc=new Tienda<Mascota>();
        //agregar productos
        tiendamasc.agregarProducto(new Gato("Pedro","nose",1),10);
        tiendamasc.agregarProducto(new Perro("Juan","nose",1),10);
        tiendamasc.agregarProducto(new Pez("Diego","nose",1),10);
        tiendamasc.agregarProducto(new Gato("wiwi","nose",1),10);
        //restock
        tiendamasc.actualizarStock(2);

        for (int i = 0; i < tiendamasc.getStock().size(); i++) {
            System.out.print(tiendamasc.getStock().get(i) + " ");
            System.out.println(tiendamasc.getPrecios().get(i));
        }
        //2da forma de usar comprar producto con 2 argumentos
        u.tomarMascota(tiendamasc.comprarProducto(1,u.getMascota()));

        System.out.println("\n"+u.getMascota());
        System.out.println(u.getDinero());

        //no gasta plata ni reemplaza la mascota a intentar comprar denuevo
        u.tomarMascota(tiendamasc.comprarProducto(2,u.getMascota()));
        System.out.println("\n"+u.getMascota());
        System.out.println(u.getDinero());
    }
}
