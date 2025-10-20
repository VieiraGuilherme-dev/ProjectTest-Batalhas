package service;

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
    }