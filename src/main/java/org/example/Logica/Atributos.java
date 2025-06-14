package org.example.Logica;

public enum Atributos {
    GATO("pescado","cazar","terrestre","gato");


    private String comida;
    private String juego;
    private String habitat;
    private String especie;
    Atributos(String c, String j,String h,String e){
        this.comida = c;
        this.juego = j;
        this.habitat = h;
        this.especie = e;
    }

    public String getComida(){
        return comida;
    }
    public String getJuego(){
        return juego;
    }
    public String getHabitat(){
        return habitat;
    }
    public String getEspecia(){
        return especie;
    }
}
