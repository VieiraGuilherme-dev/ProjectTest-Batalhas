// Service/GerenciadorEfeitos.java
package service;

import model.Criatura;
import model.EfeitoStatus;

import java.util.Iterator;
import java.util.List;

public class GerenciadorEfeitos {

    public void aplicarEfeitos(Criatura criatura) {
        if (criatura.estaDerrotado()) return;

        List<EfeitoStatus> efeitos = criatura.getEfeitosAtivos();
        Iterator<EfeitoStatus> iterator = efeitos.iterator();

        while (iterator.hasNext()) {
            EfeitoStatus efeito = iterator.next();

            switch (efeito) {
                case QUEIMADO:
                    int danoQueimado = 4;
                    criatura.setHp(criatura.getHp() - danoQueimado);
                    System.out.println(criatura.getNome() + " sofre " + danoQueimado + " de dano por queimadura.");
                    break;

                case ENVENENADO:
                    int danoVeneno = 6;
                    criatura.setHp(criatura.getHp() - danoVeneno);
                    System.out.println(criatura.getNome() + " sofre " + danoVeneno + " de dano por envenenamento.");
                    break;

                case ENFRAQUECIDO:
                    System.out.println(criatura.getNome() + " está enfraquecido; ataque reduzido.");
                    break;

                case FORTALECIDO:
                    System.out.println(criatura.getNome() + " está fortalecido; ataque aumentado.");
                    break;

                case CONGELADO:
                    System.out.println(criatura.getNome() + " está congelado e pode perder o turno.");
                    break;

                case CURADO:
                    System.out.println(criatura.getNome() + " está curado.");
                    iterator.remove();
                    break;
            }

            if (criatura.getHp() <= 0) {
                System.out.println(criatura.getNome() + " foi derrotado pelos efeitos de status.");
                break;
            }
        }
    }

    public void removerEfeito(Criatura criatura, EfeitoStatus efeito) {
        if (criatura.getEfeitosAtivos().contains(efeito)) {
            criatura.removerEfeito(efeito);
            System.out.println("Efeito " + efeito + " removido de " + criatura.getNome());
        }
    }

}
