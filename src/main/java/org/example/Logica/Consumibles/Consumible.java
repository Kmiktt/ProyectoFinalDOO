package org.example.Logica.Consumibles;

public abstract class Consumible implements Comparable<Consumible>{
    private final String tipo;
    /**Constructor de Objeto Consumible
     * @param t String del tipo de objeto
     */
    public Consumible(String t){
        tipo=t;
    }
    /**Getter del tipo de Objeto
     * @return String del tipo de objeto
     */
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

