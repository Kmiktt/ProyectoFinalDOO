package org.example.Logica;

import org.example.Logica.Mascotas.Mascota;

/** Esta interfaz es para los objetos que pueden recibir una mascota
 */
public interface TomaMascota {
    /** Esta funcion debe implementarse de la siguiente manera
     * 1. tiene que hacer algo con la mascota tomada (ya sea procesarla o guardarla)
     * 2. tiene que tener una manera de retornar la mascota en caso de que no pueda hacer ninguna accion con esta
     * @param ma la mascota que quieres depositar
     * @return la mascota rechazada
     */
    public Mascota agregarMascota(Mascota ma);
}
