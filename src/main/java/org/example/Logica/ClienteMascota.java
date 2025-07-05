package org.example.Logica;

public class ClienteMascota implements TomaMascota{
    private String Tipo;
    private int dinero;


    public Mascota agregarMascota(Mascota ma)
    {
        if (!(ma.getTipo().equals(Tipo))) {
            return ma;
        }
        else {
            Usuario.getInstance().recibirDinero(dinero);
            return null;
        }
    }
}
