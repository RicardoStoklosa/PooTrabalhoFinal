package EDA;

public class Produto {

	private final String nome;

	private final int id;

	private final int quantidade;
        
        public Produto (int cod,String name,int quant){
            id = cod;
            nome = name;
            quantidade = quant;
        }
        
        public int getId(){
            return id;
        }
        
        public String getNome(){
            return nome;
        }
        
        public int getQuantidade(){
            return quantidade;
        }

}
