package org.example.Logica;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTestBase {
    private Mascota mascota1;
    private Mascota mascota2;
    private Usuario u=Usuario.getInstance();;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        u=Usuario.getInstance();
        mascota1=new Perro("Ralsei",1);
        mascota2=new Gato("Spamton",1);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        Usuario.reset();
        mascota1=null;
        mascota2=null;
    }

    @Test
    @DisplayName("Verifica que la mascota agarrada no sea sobreescrita")
    public void testTomarMascota() {
        //toma la primera mascota
        u.tomarMascota(mascota1);
        //intenta tomar la segunda mascota
        u.tomarMascota(mascota2);
        //verifica que la mascota no fue sobreescrita
        assertEquals(u.getMascota(),mascota1);
    }

    @Test
    @DisplayName("Verifica que el singleton funciona como debería")
    public void testSingleton() {
        //intenta crear nueva instancia de singleton
        Usuario a=Usuario.getInstance();
        //verifica que sean la misma instancia
        assertEquals(a,u);
    }

    @Test
    @DisplayName("Verifica que SinSuficienteDineroException sea lanzado cuando se deba")
    public void testDinero() {
        // agrega dinero
        u.recibirDinero(1);
        // debería funcionar sin lanzar excepción
        assertDoesNotThrow(() -> u.restarDinero(1));
        //debe lanzar la exception
        assertThrows(SinSuficienteDineroException.class, () -> {
            u.restarDinero(1);
        });
    }

    @Test
    @DisplayName("Verifica Contador de objetos")
    public void testContador() {
        // agrega dinero
        for (int i = 0; i < 10; i++) {
            u.agregarObjeto(new Carne());
        }
        //el resultado debe ser 10
        assertEquals(10, u.cuantoObjeto("carne"));
    }
}