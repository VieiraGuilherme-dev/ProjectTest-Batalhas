package Service;

import model.TipoElemental;

public class CalculadoraElemental {

    // ** Valores de multiplicador:
    //2.0: representa "super efetivo" — o ataque é muito eficaz contra o tipo do defensor,
    //causando dano dobrado.
    //0.5: representa "não muito efetivo" — o ataque é pouco eficaz, causando metade do dano.
    //1.0: representa "neutro" — o ataque não tem vantagem nem desvantagem, dano normal.
    //**


    public static double calcularMultiplicador(TipoElemental atacante, TipoElemental defensor){
        if(atacante == null || defensor == null){
            return 1.0;
        }
        switch (atacante){
            case FOGO:
                if(defensor == TipoElemental.TERRA) return 2.0;
                if(defensor == TipoElemental.ÁGUA) return 0.5;
                break;

            case ÁGUA:
                if(defensor == TipoElemental.FOGO) return 2.0;
                if(defensor == TipoElemental.AR) return 0.5;
                break;

            case TERRA:
                if(defensor == TipoElemental.AR) return 2.0;
                if(defensor == TipoElemental.FOGO) return 0.5;

            case AR:
                if(defensor == TipoElemental.ÁGUA) return 2.0;
                if(defensor == TipoElemental.TERRA) return 0.5;
                break;

            case LUZ:
            case TREVAS:
                return 1.0;
        }
        return 1.0;
    }
}
