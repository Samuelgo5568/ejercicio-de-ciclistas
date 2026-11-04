package com.carrera.ciclismo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CarreraTest {

    @Test
    void ciclistaIniciaConTiempoCero() {
        Velocista velocista = new Velocista(1, "Ana", 400, 60);

        assertEquals(1, velocista.getIdentificador());
        assertEquals("Ana", velocista.getNombre());
        assertEquals(0.0, velocista.getTiempoAcumulado());
    }

    @Test
    void cadaEspecialidadDevuelveSuTipo() {
        Velocista velocista = new Velocista(1, "Ana", 400, 60);
        Escalador escalador = new Escalador(2, "Luis", 3.5f, 10f);
        Contrarrelojista contrarrelojista = new Contrarrelojista(3, "Marta", 50);

        assertEquals("Es un Velocista", velocista.imprimirTipo());
        assertEquals("Es un Escalador", escalador.imprimirTipo());
        assertEquals("Es un Contrarrelojista", contrarrelojista.imprimirTipo());
    }

    @Test
    void equipoGuardaSusCiclistas() {
        Equipo equipo = new Equipo("Equipo Colombia", "Colombia");

        equipo.anadirCiclista(new Velocista(1, "Ana", 400, 60));
        equipo.anadirCiclista(new Escalador(2, "Luis", 3.5f, 10f));

        assertEquals(2, equipo.getCiclistas().size());
        assertEquals(2, equipo.listarNombres().size());
    }

    @Test
    void equipoCalculaElTotalDeTiempos() {
        Equipo equipo = new Equipo("Equipo Colombia", "Colombia");

        Velocista velocista = new Velocista(1, "Ana", 400, 60);
        velocista.setTiempoAcumulado(100);

        Escalador escalador = new Escalador(2, "Luis", 3.5f, 10f);
        escalador.setTiempoAcumulado(120.5);

        equipo.anadirCiclista(velocista);
        equipo.anadirCiclista(escalador);

        assertEquals(220.5, equipo.calcularTotalTiempos(), 0.001);
    }

    @Test
    void buscarCiclistaPorIdentificador() {
        Equipo equipo = new Equipo("Equipo Colombia", "Colombia");
        equipo.anadirCiclista(new Contrarrelojista(10, "Marta", 50));

        assertTrue(equipo.buscarCiclista(10).isPresent());
        assertFalse(equipo.buscarCiclista(99).isPresent());
    }
}
