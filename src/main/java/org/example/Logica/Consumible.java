package org.example.Logica;

public abstract class Consumible implements Comparable<Consumible>{
    private String tipo;

    public Consumible(String t){
        tipo=t;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
    public int compareTo(Consumible o) {
        return o.getTipo().compareTo(this.getTipo());
    }
}

