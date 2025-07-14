package org.example.Logica;

import org.example.Logica.Consumibles.*;
import org.example.Logica.Mascotas.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RefugioTest {
    private Mascota mascota1;
    private Mascota mascota2;
    private Consumible consumible1;
    private Consumible consumible2;
    private Refugio ref;
    private Usuario u;
    private Habitat hab;

    @BeforeEach
    void setUp() {
        Usuario.reset();
        u=Usuario.getInstance();
        ref=new Refugio();
        mascota1=new Perro("Ralsei",1);
        mascota2=new Gato("Spamton",1);
        consumible1=new Carne();
        consumible2=new Medicina();
    }
    @AfterEach
    void tearDown() {
        Habitat.resetInstancias();
    }

    @Test
    @DisplayName("Restock de mascotas Funcional")
    public void testInstancias() {
        hab=new Habitat("terrestre");
        ArrayList<Mascota> aux;
        ref.actualizarStock(10);
        //es igual antes de ejecutar restock
        aux=ref.getStock();
        assertSame(aux,ref.getStock());
        //es distinto después de ejecutar restock
        ref.actualizarStock(10);
        assertNotSame(aux,ref.getStock());
    }

    @Test
    @DisplayName("Excepcion de falta de Habitat funcional")
    public void testExcepcionHabitat() {
        assertThrows(NoHayHabitatsException.class, () -> {
            ref.actualizarStock(1);
        });
    }

    @Test
    @DisplayName("Puedes adoptar una mascota")
    public void testAdopcion() {
        //generas el stock y guardas la referencia de la mascota
        hab=new Habitat("terrestre");
        ref.actualizarStock(1);
        Mascota masc=ref.getStock().getFirst();
        //adoptas animal
        ref.adoptarAnimal(0,"pedro");
        assertEquals(0, ref.getStock().size());
        assertEquals(masc,u.getMascota());

    }

}