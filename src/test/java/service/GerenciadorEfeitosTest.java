package service;

import service.GerenciadorEfeitos;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class GerenciadorEfeitosTest {

    private Criatura criatura;
    private GerenciadorEfeitos gerenciador;

    @BeforeEach
    void setup() {
        criatura = new Criatura("Fera", 100, 20, 15, 10, TipoElemental.FOGO, new ArrayList<>(), new ArrayList<>());
        gerenciador = new GerenciadorEfeitos();
    }

    @Test
    void deveAplicarDanoDeStatusCorretamente() {
        criatura.aplicarEfeito(EfeitoStatus.ENVENENADO);
        gerenciador.aplicarEfeitos(criatura);
        assertEquals(94, criatura.getHp(), "HP deve ser 100 - 6 (dano de ENVENENADO).");
    }

    @Test
    void deveRemoverEfeitoCuradoAposAplicacao() {
        criatura.aplicarEfeito(EfeitoStatus.CURADO);
        gerenciador.aplicarEfeitos(criatura);
        assertFalse(criatura.getEfeitosAtivos().contains(EfeitoStatus.CURADO), "CURADO deve ser removido após aplicação.");
    }

    @Test
    void deveRemoverEfeitoEspecifico() {
        criatura.aplicarEfeito(EfeitoStatus.QUEIMADO);
        criatura.aplicarEfeito(EfeitoStatus.FORTALECIDO);
        gerenciador.removerEfeito(criatura, EfeitoStatus.QUEIMADO);
        assertFalse(criatura.getEfeitosAtivos().contains(EfeitoStatus.QUEIMADO), "O efeito QUEIMADO removido.");
        assertTrue(criatura.getEfeitosAtivos().contains(EfeitoStatus.FORTALECIDO), "Outros efeitos devem permanecer.");
    }

    @Test
    void deveDerrotarCriaturaPorDanoDeStatus() {
        criatura.aplicarEfeito(EfeitoStatus.QUEIMADO);
        criatura.setHp(3);
        gerenciador.aplicarEfeitos(criatura);
        assertTrue(criatura.estaDerrotado(), "A criatura deve ser marcada como derrotada se HP <= 0 após status.");
    }
}
