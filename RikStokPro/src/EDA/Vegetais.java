package EDA;

import java.util.Date;

public class Vegetais extends Produto {

    private int peso;

    private Date validade;

    public Vegetais(int peso, Date validade, String nome, int id, int quantidade, double valor) {
        super(nome, id, quantidade, valor);
        this.peso = peso;
        this.validade = validade;
    }

    public int getPeso() {
        return peso;
    }

    public Date getVal() {
        return validade;
    }

}
