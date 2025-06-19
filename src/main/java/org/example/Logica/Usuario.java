package org.example.Logica;
//singleton
public class Usuario {
    private static Usuario instancia;
    private Mascota manomascota;
    private int dinero;

    private Usuario() {}

    public static Usuario getInstance() {
        if (instancia == null) {
            instancia = new Usuario();
        }
        return instancia;
    }

    public void recibirDinero(int d){
        dinero+=d;
    }

    public void tomarMascota(Mascota a){
        manomascota=a;
    }

    public void colocarMascota(TomaMascota toma){
        manomascota=toma.agregarMascota(manomascota);
    }
}
