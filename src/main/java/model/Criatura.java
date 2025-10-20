package model;

import java.util.List;

public class Criatura {
    private String nome;
    private int hp;
    private int atk;
    private int def;
    private int velocidade;
    private TipoElemental tipo;
    private List<Habilidade> habilidades;
    private List<EfeitoStatus> efeitosAtivos;

    public Criatura(String nome, int hp, int atk, int def, int velocidade, TipoElemental tipo,
                    List<Habilidade> habilidades, List<EfeitoStatus> efeitosAtivos) {
        super();
        this.nome = nome;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.velocidade = velocidade;
        this.tipo = tipo;
        this.habilidades = habilidades;
        this.efeitosAtivos = efeitosAtivos;
    }

    public String getNome() {
        return nome;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public TipoElemental getTipo() {
        return tipo;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void adicionarHabilidade(Habilidade habilidade) {
        habilidades.add(habilidade);
    }

    public List<EfeitoStatus> getEfeitosAtivos() {
        return efeitosAtivos;
    }

    public void aplicarEfeito(EfeitoStatus efeito) {
        efeitosAtivos.add(efeito);
    }

    public void removerEfeito(EfeitoStatus efeito) {
        efeitosAtivos.remove(efeito);
    }

    public boolean estaDerrotado() {
        return hp <= 0;
    }
}
