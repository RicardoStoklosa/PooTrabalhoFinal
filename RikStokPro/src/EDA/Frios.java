package EDA;

import EDA.Produto;

public class Frios extends Produto {

    private Double temperatura;

    public Frios(Double temperatura, String nome, int id, int quantidade, Double valor) {
        super(nome, id, quantidade, valor);
        this.temperatura = temperatura;
    }

    public Double getTemp() {
        return temperatura;
    }

}
