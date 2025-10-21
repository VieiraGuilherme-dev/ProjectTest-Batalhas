package model;

public class Habilidade {
    private String nome;
    private String descricao;
    private int poder;
    private TipoElemental tipo;
    private EfeitoStatus efeito;

    public Habilidade(String nome, String descricao, int poder, TipoElemental tipo, EfeitoStatus efeito) {
        super();
        this.nome = nome;
        this.descricao = descricao;
        this.poder = poder;
        this.tipo = tipo;
        this.efeito = efeito;
    }

    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public int getPoder() {
        return poder;
    }
    public TipoElemental getTipo() {
        return tipo;
    }
    public EfeitoStatus getEfeito() {
        return efeito;
    }
}
