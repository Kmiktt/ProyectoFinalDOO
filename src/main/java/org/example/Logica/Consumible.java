package org.example.Logica;

public abstract class Consumible {
    private String tipo;

    public Consumible(String t){
        tipo=t;
    }

    public String getTipo() {
        return tipo;
    }
}

