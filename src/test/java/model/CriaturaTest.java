package model;

import model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class CriaturaTest {
    @Test
    public void testCriaturaRecebeEDiminuiHp() {
        List<Habilidade> habilidades = new ArrayList<>();
        List<EfeitoStatus> efeitos = new ArrayList<>();
        Criatura c = new Criatura("Fenix", 100, 20, 10, 5, TipoElemental.FOGO, habilidades, efeitos);

        c.setHp(50);
        assertEquals(50, c.getHp());
        assertFalse(c.estaDerrotado());

        c.setHp(0);
        assertTrue(c.estaDerrotado());
    }
}
