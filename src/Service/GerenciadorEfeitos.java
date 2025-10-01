package Service;

import model.Criatura;
import model.EfeitoStatus;

import java.util.Iterator;
import java.util.List;

public class GerenciadorEfeitos {
    public void aplicarEfeitos(Criatura criatura){
        if(criatura.estaDerrotado()){
            return;
        }

        List<EfeitoStatus> efeitos = criatura.getEfeitosAtivos();
        Iterator<EfeitoStatus> iterator = efeitos.iterator();

        while(iterator.hasNext()){
            EfeitoStatus efeito = iterator.next();

            switch (efeito){
                case QUEIMADO:
                    int danoQueimado = 4;
                    criatura.setHp(criatura.getHp() - danoQueimado);
                    System.out.println(criatura.getNome() + "sofre" + danoQueimado + "de dano por queimadura");
                    break;

                case ENVENENADO:
                    int danoEnvenenado = 6;
                    criatura.setHp(criatura.getHp() - danoEnvenenado);
                    System.out.println(criatura.getNome() + "sofre" + danoEnvenenado + "de dano por envenenamento");
                    break;

                case ENFRAQUECIDO:
                    System.out.println(criatura.getNome() + "esta enfraquecido e o ataque sera reduzido");
                    break;

                case FORTALECIDO:
                    System.out.println(criatura.getNome() + "esta fortalecido e o ataque sera aumentado");
                    break;

                case CONGELADO:
                    System.out.println(criatura.getNome() + "esta congelado e pode perder o turno");
                    break;

                case CURADO:
                    System.out.println(criatura.getNome() + "esta curado");
                    iterator.remove();// p remover o efeito de cura aqui - HUGO
                    break;
            }
            if(criatura.getHp() <= 0){
                //aqui é p mostar que foi derrotado - HUGO
                System.out.println(criatura.getNome() + "foi derrotado pelos efeitos de status");
                break;
            }
        }
    }
}
