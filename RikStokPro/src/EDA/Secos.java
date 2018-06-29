package EDA;

public class Secos extends Produto {

    private int peso;

    public Secos(int peso, String nome, int id, int quantidade, double valor) {
        super(nome, id, quantidade, valor);
        this.peso = peso;
    }

    public int getPeso() {
        return peso;
    }

}
