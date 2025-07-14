package org.example.Logica;

public enum Atributos {
    GATO        ("pescado","cazar","terrestre","gato", 80, 30, 70, 100),
    PEZ         ("krill", "burbujas","acuatico", "pez",80, 40, 50, 80),
    PERRO       ("carne", "palo", "terrestre", "perro", 90, 40, 60, 100),
    PTERODACTILO("carne", "palo", "aereo", "pterodáctilo", 100, 20, 20, 90),
    CANARIO("krill", "palo", "aereo", "canario", 50, 200, 50, 170),
    AJOLOTE     ("pescado", "palo", "acuatico", "ajolote", 40, 100, 70, 90);


    private String comida;
    private String juego;
    private String habitat;
    private String especie;
    private int hambre;
    private int higiene;
    private int salud;
    private int felicidad;

    Atributos(String c, String j,String h,String e, int ha, int hi, int sa, int fe){
        this.comida = c;
        this.juego = j;
        this.habitat = h;
        this.especie = e;
        this.hambre = ha;
        this.higiene = hi;
        this.salud = sa;
        this.felicidad = fe;
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
    public String getEspecie(){
        return especie;
    }
    public int getHambre(){return hambre;}
    public int getHigiene(){return higiene;}
    public int getSalud(){return salud;}
    public int getFelicidad(){return felicidad;}
}
