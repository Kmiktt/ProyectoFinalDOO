package org.example.Logica;

/** Es lanzado cuando el usuario no tiene suficiente dinero para hacer una compra
 */
public class SinSuficienteDineroException extends RuntimeException {
    public SinSuficienteDineroException() {
        super();
    }
}
