package org.example.Logica;

/** Es lanzado cuando no hay habitats y se quiere hacer una operacion que necesita la existencia de una
 */
public class NoHayHabitatsException extends RuntimeException {
    public NoHayHabitatsException() {
        super();
    }
}
