package org.example.Logica;
import org.example.Logica.Mascotas.Mascota;

import java.util.ArrayList;
import java.util.Random;

public class ClienteMascota implements TomaMascota{
    private String tipo;
    private int ticks;
    private ArrayList<String> mascotas;
    /**Constructor de Objeto ClienteMascota
     */
    public ClienteMascota(){
        mascotas = new ArrayList<String>();
        ActualizarMascota();
    }
    /** Actualiza las especies de mascota que puede pedir el cliente
     */
    public void actualizarAnimales(){
        ArrayList<String> auxa= new ArrayList<String>();
        for (int i = 0; i < Habitat.getInstancias().size(); i++) {
            for (Atributos a:Atributos.values()){
                if (a.getHabitat().equals(Habitat.getInstancias().get(i).getTipo())){
                    auxa.add(a.getEspecie());
                }
            }
        }
        mascotas=auxa;
    }
    /** Recibe un animal para ver su precio
     * @param ma la mascota que quieres depositar
     * @return la mascota Rechazada
     */
    public Mascota agregarMascota(Mascota ma)
    {
        if (!(ma.getTipo().equals(tipo))) {
            return ma;
        }
        else {
            Usuario.getInstance().recibirDinero(cuantoPaga(ma));
            return null;
        }
    }
    /**Cambia la mascota que quiere y reinicia su paciencia
     * @throws NoHayHabitatsException cuando no tiene Habitat entonces no hay mascotas que puedas vender
     */
    public void ActualizarMascota() throws NoHayHabitatsException{
        actualizarAnimales();
        Random r = new Random();
        if (mascotas.isEmpty()){
            throw new NoHayHabitatsException();
        }
        else {
            tipo = mascotas.get(r.nextInt(mascotas.size()));
            ticks = 0;
        }
    }
    /** te retorna cuanto dinero te da el cliente por la mascota
     * @param ma la mascota que quieres ofrecer
     * @return la cantidad de dinero que te pagaria por la mascota
     */
    public int cuantoPaga(Mascota ma){
        double mon = 200 * ((100.0 - ticks) / 100.0);

        mon -= (1-(double) ma.getSalud() / ma.getAtri().getSalud()) * 20;
        mon -= (1-(double) ma.getFelicidad() / ma.getAtri().getFelicidad()) * 20;
        mon -= (1-(double) ma.getHigiene() / ma.getAtri().getHigiene()) * 20;
        mon -= (1-(double) ma.getHambre() / ma.getAtri().getHambre()) * 20;

        mon *= Math.max(20.0, ma.getFticks()) / 20.0;

        return (int) mon;
    }
    /**
     * actualiza el estado de el CLiente
     */
    public void update(){
        ticks+=1;
        if (ticks>=50){
            ActualizarMascota();
        }
    }
    /**Setter de la especie de mascota que el cliente quiere comprar
     * @param s la especie de la mascota que el cliente quiere comprar
     */
    public void setTipo(String s){
        tipo=s;
    }
    /**Getter de la especie de mascota que el cliente quiere comprar
     * @return la especie que la mascota quiere comprar
     */
    public String getTipo(){
        return tipo;
    }

    /**te retorna los ticks que a esperado el cliente
     * @return los ticks que ha esperado el cliente
     */
    public int getTicks(){
        return ticks;
    }
}
