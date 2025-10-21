package service;

import service.CalculadoraElemental;
import model.TipoElemental;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraElementalTest {

    @Test
    void deveRetornarVantagem() {
        double multiplicador = CalculadoraElemental.calcularMultiplicador(TipoElemental.ÁGUA, TipoElemental.FOGO);
        assertEquals(2.0, multiplicador, "Vantagem deve ser 2.0x.");
    }

    @Test
    void deveRetornarDesvantagem() {
        double multiplicador = CalculadoraElemental.calcularMultiplicador(TipoElemental.FOGO, TipoElemental.ÁGUA);
        assertEquals(0.5, multiplicador, "Desvantagem deve ser 0.5x.");
    }

    @Test
    void deveRetornarNeutro() {
        double multiplicador = CalculadoraElemental.calcularMultiplicador(TipoElemental.LUZ, TipoElemental.TREVAS);
        assertEquals(1.0, multiplicador, "Neutro deve ser 1.0x.");
    }
}
