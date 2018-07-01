package EDA;
//TODO import javax.persistence.*;

import Exceção.QuantInvalida;

public class Produto {
    
    private String nome;

    private int id;

    private int quantidade;

    private Double valor;

    public Produto(String nome, int id, int quantidade, Double valor) {
        this.nome = nome;
        this.id = id;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Produto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public int getQuantidade(){
        
        return quantidade;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", id=" + id + ", quantidade=" + quantidade + ", valor=" + valor + '}';
    }
    
}
