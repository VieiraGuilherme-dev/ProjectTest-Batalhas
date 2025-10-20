package model;

public class Item {
    private String nome;
    private String decricao;
    private TipoItem tipo;
    private int valor;

    public Item(String nome, String decricao, TipoItem tipo, int valor) {
        super();
        this.nome = nome;
        this.decricao = decricao;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public String getDecricao() {
        return decricao;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public int getValor() {
        return valor;
    }
}

