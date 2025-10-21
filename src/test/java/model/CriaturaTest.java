package model;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class CriaturaTest {

    @Test
    void deveAplicarERemoverEfeitosCorretamente() {
        Criatura criatura = new Criatura("Dragão", 100, 20, 10, 15, TipoElemental.FOGO, new ArrayList<>(), new ArrayList<>());
        criatura.aplicarEfeito(EfeitoStatus.QUEIMADO);
        assertTrue(criatura.getEfeitosAtivos().contains(EfeitoStatus.QUEIMADO));
        criatura.removerEfeito(EfeitoStatus.QUEIMADO);
        assertFalse(criatura.getEfeitosAtivos().contains(EfeitoStatus.QUEIMADO));
    }

    @Test
    void deveReduzirHpSemFicarNegativo() {
        Criatura criatura = new Criatura("Golem", 50, 15, 20, 8, TipoElemental.TERRA, new ArrayList<>(), new ArrayList<>());
        criatura.setHp(-10);
        assertEquals(0, criatura.getHp(), "HP não pode ser negativo.");
        assertTrue(criatura.estaDerrotado());
    }

    @Test
    void deveAdicionarHabilidade() {
        Criatura criatura = new Criatura("Fênix", 120, 25, 15, 20, TipoElemental.FOGO, new ArrayList<>(), new ArrayList<>());
        Habilidade habilidade = new Habilidade("Chama Viva", "Ataque flamejante", 40, TipoElemental.FOGO, EfeitoStatus.QUEIMADO);
        criatura.adicionarHabilidade(habilidade);
        assertEquals(1, criatura.getHabilidades().size());
    }
}
