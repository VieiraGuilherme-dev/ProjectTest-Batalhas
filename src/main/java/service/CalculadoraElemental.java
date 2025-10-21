
package service;

import model.TipoElemental;

public class CalculadoraElemental {

    public static double calcularMultiplicador(TipoElemental atacante, TipoElemental defensor) {
        if (atacante == null || defensor == null) return 1.0;

        switch (atacante) {
            case FOGO:
                if (defensor == TipoElemental.TERRA) return 2.0;
                if (defensor == TipoElemental.ÁGUA) return 0.5;
                break;

            case ÁGUA:
                if (defensor == TipoElemental.FOGO) return 2.0;
                if (defensor == TipoElemental.AR) return 0.5;
                break;

            case TERRA:
                if (defensor == TipoElemental.AR) return 2.0;
                if (defensor == TipoElemental.FOGO) return 0.5;
                break;

            case AR:
                if (defensor == TipoElemental.ÁGUA) return 2.0;
                if (defensor == TipoElemental.TERRA) return 0.5;
                break;

            case LUZ:
            case TREVAS:
                return 1.0;
        }

        return 1.0;
    }

}
