package EDA;

public class Secos extends Produto {

    private Double peso;

    public Secos(Double peso, String nome, int id, int quantidade, double valor) {
        super(nome, id, quantidade, valor);
        this.peso = peso;
    }

    public Double getPeso() {
        return peso;
    }

}
