package model;

public class Habilidade {
    private String nome;
    private int poder;
    private TipoElemental tipo;

    public Habilidade(String nome, int poder, TipoElemental tipo) {
        this.nome = nome;
        this.poder = poder;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public int getPoder() {
        return poder;
    }

    public TipoElemental getTipo() {
        return tipo;
    }
}
