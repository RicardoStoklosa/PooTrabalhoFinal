package Negocio;


import DAO.*;
import java.util.ArrayList;
import EDA.*;

public class NegocioFacade {

	static final DAOFacade registros = DAOMemoria.get();
        
        private NegocioFacade(){}

	public static boolean login(String login, String senha){
            senha = Toolbox.encrypt( senha );
            boolean adm = registros.verificarCredenciais( login, senha );
            return adm;
        }
        
	public static Operacao addProduto(Produto produto) {
		Operacao status = new Operacao();
                if(produto.getQuantidade() < 0)
                    status.anexarErro("Quantidade Invalida");
                
                for(Produto aux : registros.getProdutos()){
                    if(produto.getId() == aux.getId()){
                        status.anexarErro("Código de produto já registrado");
                        break;
                    }
                }
                if( status.getStatus() ){
                    boolean res = registros.addProduto( produto );
                    if( res == false )
                        status.anexarErro("Erro ao registrar dados do Produto!");
                    }
                return status;
	}


	public static Operacao editProduto(Produto produto) {
            Operacao status = new Operacao();
            if(produto.getQuantidade() < 0)
                    status.anexarErro("Quantidade Invalida");
            
            return status;
	}
        public static void rmProduto(Produto produto) {
            registros.rmProduto(produto);
        }
        public static void init(){
            registros.init();
        }
        public static ArrayList<Produto> getProdutos(){  
            return registros.getProdutos();
        }
        public static Produto getProdutosId(int id){
            for( Produto produto : NegocioFacade.registros.getProdutos() ){
                if( produto.getId() == id )
                    return produto;   
            }
            return null;
        }
}
