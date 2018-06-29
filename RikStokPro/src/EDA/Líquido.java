package EDA;

public class Líquido extends Produto {

    private Double litros;

    public Líquido(Double litros, String nome, int id, int quantidade, double valor) {
        super(nome, id, quantidade, valor);
        this.litros = litros;
    }

    public Double getLitros() {
        return litros;
    }

}
