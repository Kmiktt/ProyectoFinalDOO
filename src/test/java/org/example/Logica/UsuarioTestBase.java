package org.example.Logica;

import org.example.Logica.Consumibles.Carne;
import org.example.Logica.Consumibles.Consumible;
import org.example.Logica.Consumibles.Pescado;
import org.example.Logica.Mascotas.Gato;
import org.example.Logica.Mascotas.Mascota;
import org.example.Logica.Mascotas.Perro;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class UsuarioTestBase {
    private Mascota mascota1;
    private Mascota mascota2;
    private Consumible consumible1;
    private Consumible consumible2;
    private Usuario u;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Usuario.reset();
        u=Usuario.getInstance();
        mascota1=new Perro("Ralsei",1);
        mascota2=new Gato("Spamton",1);
        consumible1=new Carne();
        consumible2=new Pescado();
    }
    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        mascota1=null;
        mascota2=null;
        consumible1=null;
        consumible2=null;
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
    @Test
    @DisplayName("Verifica que dejar un objeto en el inventario funcione como debe")
    public void testInventario() {
        Consumible consumible1 =new Carne();
        u.agregarObjeto(consumible1);
        assertEquals(consumible1,u.getInventario().getFirst());
    }
    @Test
    @DisplayName("Verifica que el Objeto en mano sea reemplazado y enviado a el inventario")
    public void testTomarObjeto() {
        u.tomarObjeto(consumible1);
        u.tomarObjeto(consumible2);
        //el primer objeto es reemplazado por el segundo
        assertEquals(consumible2,u.getMano());
        //el primer objeto es enviado a el inventario
        assertEquals(consumible1,u.getInventario().getFirst());
    }
}