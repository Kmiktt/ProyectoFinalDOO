package org.example.Logica;

import org.example.Logica.Consumibles.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class TiendaTest {
    Usuario u;
    @BeforeEach
    void setUp() {
        Usuario.reset();
        u=Usuario.getInstance();
        Tienda<Consumible> ti=new Tienda<Consumible>();
    }

    @AfterEach
    void tearDown() {
    }
}