package service;

import Service.BatalhaService;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BatalhaServiceTest {

    private Criatura atacanteFogo;
    private Criatura defensorAgua;
    private Criatura defensorTerra;
    private Habilidade ataqueFogo;

    @BeforeEach
    void setup() {
        atacanteFogo = new Criatura("Fenix", 100, 30, 10, 15, TipoElemental.FOGO, new ArrayList<>(), new ArrayList<>());
        defensorAgua = new Criatura("Kraken", 100, 20, 10, 12, TipoElemental.ÁGUA, new ArrayList<>(), new ArrayList<>());
        defensorTerra = new Criatura("Golem", 100, 20, 10, 12, TipoElemental.TERRA, new ArrayList<>(), new ArrayList<>());
        ataqueFogo = new Habilidade("Chama", "Ataque base", 20, TipoElemental.FOGO, null);
    }

    @Test
    void deveAplicarDanoComDesvantagem() {
        BatalhaService.iniciarBatalha(atacanteFogo, defensorAgua, ataqueFogo);
        assertEquals(90, defensorAgua.getHp(), "HP deve ser 100 - 10 (0.5x).");
    }

    @Test
    void deveAplicarDanoComVantagem() {
        BatalhaService.iniciarBatalha(atacanteFogo, defensorTerra, ataqueFogo);
        assertEquals(60, defensorTerra.getHp(), "HP deve ser 100 - 40 (2x).");
    }

    @Test
    void deveAplicarEfeitoStatusAoDefensor() {
        Habilidade ataqueComStatus = new Habilidade("Queimar", "Causa queimadura", 10, TipoElemental.FOGO, EfeitoStatus.QUEIMADO);
        BatalhaService.iniciarBatalha(atacanteFogo, defensorAgua, ataqueComStatus);
        assertTrue(defensorAgua.getEfeitosAtivos().contains(EfeitoStatus.QUEIMADO), "O status QUEIMADO deve ser aplicado.");
    }

    @Test
    void deveAplicarCuraAoAtacante() {
        Habilidade cura = new Habilidade("Cura", "Restaura HP", 15, TipoElemental.LUZ, EfeitoStatus.CURADO);
        atacanteFogo.setHp(50);
        BatalhaService.iniciarBatalha(atacanteFogo, defensorAgua, cura);
        assertEquals(65, atacanteFogo.getHp(), "O HP deve ser restaurado em 15.");
    }

    @Test
    void naoPodeAtacarSeAtacanteEstiverDerrotado() {
        atacanteFogo.setHp(0);
        BatalhaService.iniciarBatalha(atacanteFogo, defensorAgua, ataqueFogo);
        assertEquals(100, defensorAgua.getHp(), "O HP do defensor não pode mudar se o atacante estiver derrotado.");
    }
}
