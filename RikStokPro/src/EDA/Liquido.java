package EDA;


public class Liquido extends Produto {

    private Double litros;

    /**
     *
     * @param litros
     * @param nome
     * @param id
     * @param quantidade
     * @param valor
     */
    public Liquido(Double litros, String nome, int id, int quantidade, double valor) {
        super(nome, id, quantidade, valor);
        this.litros = litros;
    }

    public Double getLitros() {
        return litros;
    }

    @Override
    public String toString() {
        return "L\u00edquido{" + "litros=" + litros + '}';
    }

}
