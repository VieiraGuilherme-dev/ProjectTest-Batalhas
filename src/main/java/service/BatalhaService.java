// BatalhaService.java
package Service;

import model.Criatura;
import model.EfeitoStatus;
import model.Habilidade;

public class BatalhaService {
    public static void iniciarBatalha(Criatura atacante, Criatura defensor, Habilidade habilidade) {
        if (atacante.estaDerrotado()) {
            System.out.println(atacante.getNome() + " está derrotado.");
            return;
        }
        if (defensor.estaDerrotado()) {
            System.out.println(defensor.getNome() + " já está derrotado");
            return;
        }

        double multiplicador = CalculadoraElemental.calcularMultiplicador(habilidade.getTipo(), defensor.getTipo());

        int danoBase = atacante.getAtk() + habilidade.getPoder() - defensor.getDef();
        if (danoBase < 0) danoBase = 0;

        int danoFinal = (int) Math.round(danoBase * multiplicador);
        int novoHp = defensor.getHp() - danoFinal;
        defensor.setHp(novoHp);

        System.out.println(atacante.getNome() + " usou " + habilidade.getNome() + " causando " + danoFinal + " de dano em " + defensor.getNome() + ".");

        if (multiplicador > 1.0) {
            System.out.println("É muito bom!");
        } else if (multiplicador < 1.0) {
            System.out.println("Não é tão bom!");
        }
        if (defensor.estaDerrotado()) {
            System.out.println("Defensor " + defensor.getNome() + " está derrotado!");
        }

        EfeitoStatus efeito = habilidade.getEfeito();
        if (efeito != null && efeito != EfeitoStatus.CURADO) {
            defensor.aplicarEfeito(efeito);
            System.out.println(defensor.getNome() + " foi atingido por " + efeito);
        }

        if (efeito == EfeitoStatus.CURADO) {
            int cura = habilidade.getPoder();
            int hpCurado = atacante.getHp() + cura;
            atacante.setHp(hpCurado);
            System.out.println(atacante.getNome() + " restaurou " + cura + " de HP.");
        }
    }

    public void aplicarEfeitosStatus(Criatura criatura) {
        if (criatura.estaDerrotado()) {
            System.out.println("A criatura está derrotada");
            return;
        }
        for (EfeitoStatus efeito : criatura.getEfeitosAtivos()) {
            switch (efeito) {
                case QUEIMADO:
                    int danoQueimado = 4;
                    criatura.setHp(criatura.getHp() - danoQueimado);
                    System.out.println(criatura.getNome() + " sofre " + danoQueimado);
                    break;

                case ENVENENADO:
                    int danoVeneno = 6;
                    criatura.setHp(criatura.getHp() - danoVeneno);
                    System.out.println(criatura.getNome() + " sofre " + danoVeneno);
                    break;

                case ENFRAQUECIDO:
                    System.out.println(criatura.getNome() + " está enfraquecido e o ataque será reduzido");
                    break;

                case FORTALECIDO:
                    System.out.println(criatura.getNome() + " está fortalecido e o ataque será aumentado");
                    break;

                case CONGELADO:
                    System.out.println(criatura.getNome() + " pode perder o turno pois está congelado");
                    break;

                case CURADO:
                    break; // efeito de cura instantâneo
            }
        }
        if (criatura.getHp() <= 0) {
            System.out.println(criatura.getNome() + " foi derrotado pelo efeito de status");
        }
    }
}
