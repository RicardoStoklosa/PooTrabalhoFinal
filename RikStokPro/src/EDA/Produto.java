package EDA;

public class Produto {

    private String nome;

    private int id;

    private int quantidade;

    private double valor;

    public Produto(String nome, int id, int quantidade, double valor) {
        this.nome = nome;
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValor() {
        return valor;
    }

}
