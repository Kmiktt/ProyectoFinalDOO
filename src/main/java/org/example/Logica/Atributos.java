package org.example.Logica;

/** Enum que tiene los Atributos base y sus caracteristicas de cada especie
 */
public enum Atributos {
    GATO        ("pescado","cazar","terrestre","gato", 80, 30, 70, 100),
    PEZ         ("krill", "burbujas","acuatico", "pez",80, 40, 50, 80),
    PERRO       ("carne", "palo", "terrestre", "perro", 90, 40, 60, 100),
    PTERODACTILO("carne", "palo", "aereo", "pterodactilo", 100, 20, 20, 90),
    CANARIO("krill", "palo", "aereo", "canario", 50, 200, 50, 170),
    AJOLOTE     ("pescado", "palo", "acuatico", "ajolote", 40, 100, 70, 90);


    private final String comida;
    private final String j;
    private final String habitat;
    private final String especie;
    private final int hambre;
    private final int higiene;
    private final int salud;
    private final int felicidad;

    Atributos(String c, String j,String h,String e, int ha, int hi, int sa, int fe){
        this.comida = c;
        this.j = j;
        this.habitat = h;
        this.especie = e;
        this.hambre = ha;
        this.higiene = hi;
        this.salud = sa;
        this.felicidad = fe;
    }

    /**
     * @return la comida favorita del Animal
     */
    public String getComida(){
        return comida;
    }

    /**
     * @return el tipo de Habitat en donde vive
     */
    public String getHabitat(){
        return habitat;
    }
    /**
     * @return El nombre de la especie
     */
    public String getEspecie(){
        return especie;
    }
    /**
     * @return el Hambre maxima que puede tener la epecie
     */
    public int getHambre(){return hambre;}
    /**
     * @return el Higiene maxima que puede tener la epecie
     */
    public int getHigiene(){return higiene;}
    /**
     * @return la Salud maxima que puede tener la epecie
     */
    public int getSalud(){return salud;}
    /**
     * @return la Felicidad maxima que puede tener la epecie
     */
    public int getFelicidad(){return felicidad;}
}
