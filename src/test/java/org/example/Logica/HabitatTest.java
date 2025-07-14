package org.example.Logica;

import org.junit.jupiter.api.*;
import org.example.Logica.Mascotas.*;

import static org.junit.jupiter.api.Assertions.*;

class HabitatTest {
    private Usuario u;
    private Habitat hab;
    private Mascota mascota1;
    private Mascota mascota2;
    @BeforeEach
    void setUp() {
        Usuario.reset();
        u=Usuario.getInstance();
        hab=new Habitat("terrestre");
        mascota1=new Perro("Nokia",1);
        mascota2=new Gato("Calabaza",1);
    }
    @AfterEach
    void tearDown() {
        Habitat.resetInstancias();
    }
    @Test
    @DisplayName("Instancias de Habitat guardadas")
    public void testInstancias() {
        System.out.println(Habitat.getInstancias());
        assertEquals(hab,Habitat.getInstancias().getFirst());
    }
    @Test
    @DisplayName("Agregar mascota funciona como debe")
    public void testAgregarMascota() {
        Mascota p;
        hab.agregarMascota(mascota1);
        assertEquals(hab.getMascota(0),mascota1);
        for (int i = 0; i < 5; i++) {
            hab.agregarMascota(new Perro("ola",0));
        }
        //lo devuelve porque esta lleno
        p=hab.agregarMascota(mascota2);
        assertEquals(p,mascota2);
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