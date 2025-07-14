package org.example.Logica;

import org.example.Logica.Mascotas.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ClienteMascotaTest {
    private Usuario u;
    private ClienteMascota cm;
    private Habitat hab;
    private Mascota mascota1;
    @BeforeEach
    void setUp() {
        Usuario.reset();
        u=Usuario.getInstance();
        mascota1=new Perro("Nokia",1);
    }
    @AfterEach
    void tearDown() {
        Habitat.resetInstancias();
    }

    @Test
    @DisplayName("Excepcion de falta de Habitat funcional")
    public void testExcepcionHabitat() {
        assertThrows(NoHayHabitatsException.class, () -> cm=new ClienteMascota());
    }

    @Test
    @DisplayName("Recibir dinero funciona correctamente")
    public void testRecibirDinero() {
        hab=new Habitat("terrestre");
        cm=new ClienteMascota();
        cm.setTipo("perro");
        cm.agregarMascota(mascota1);
        assertEquals(cm.cuantoPaga(mascota1),u.getDinero());
    }

}