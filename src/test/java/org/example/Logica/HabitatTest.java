package org.example.Logica;

import org.example.Logica.Consumibles.Carne;
import org.example.Logica.Consumibles.Consumible;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.example.Logica.Mascotas.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HabitatTest {
    private Usuario u;
    private Habitat hab;
    private Habitat hab1;
    private Mascota mascota1;
    @BeforeEach
    void setUp() {
        Usuario.reset();
        u=Usuario.getInstance();
        hab=new Habitat("terrestre");
        hab1=new Habitat("pop");
        mascota1=new Perro("Nokia",1);
    }
    @AfterEach
    void tearDown() {
    }
    @Test
    @DisplayName("Intancias de Habitat guardadas")
    public void testInstancias() {
        assertEquals(hab,Habitat.getInstancias().get(0));
        assertEquals(hab1,Habitat.getInstancias().get(1));
    }
    @Test
    @DisplayName("DarMascota funciona como debe")
    public void testDarMascota() {
        Mascota p;
        hab.agregarMascota(mascota1);
        p=hab.darMascota(0);
        assertNull(hab.getMascota(0));
        assertEquals(p,mascota1);

    }
}