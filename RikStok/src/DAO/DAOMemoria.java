package DAO;

import EDA.*;
import java.util.ArrayList;

public class DAOMemoria implements DAOFacade{
        private static DAOMemoria memoria;
        
        private Admin administrador;
	private ArrayList<Produto> produtos = new ArrayList();
	private ArrayList<Admin> admin  = new ArrayList();

	

	public static DAOMemoria get() {
            if( memoria == null )
                memoria = new DAOMemoria();
            return memoria;
	}
        
        private void DAOMemoria() {
            init();    
            
	}
        
        public void init(){
            produtos.add( new Produto(1, "Teclado Gamer", 10) );
            produtos.add( new Produto(2, "Teclado asd", 10) );
            produtos.add( new Produto(3, "Teclado asd", 10) );
            System.out.println("oiadsa");
        }
        @Override
	public boolean verificarCredenciais(String login, String senha) {
            String log = "udesc";
            String pass = "785b10a64d56af61e802913738e7d567";
            if( log.compareTo(login)==0  &&  pass.compareTo(senha)==0 ) {
                
                return true;
            }
            return false;
	}
        @Override
	public boolean addProduto(Produto produto) {
            for( Produto aux : produtos){
                if( aux.getId() == produto.getId() )
                    return false;
            }
            return produtos.add( produto );
            
	}
        @Override
	public boolean rmProduto(Produto produto) {
            return produtos.remove( produto );
	}
        @Override
	public boolean editProduto(Produto produto) {
            for( Produto aux : produtos ){
                if( aux.getId() == produto.getId() ){
                    produtos.remove( aux );
                    produtos.add( produto );
                    return true;
            }
        }
        return false;
	}
        @Override
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

    @Override
    public ArrayList<Admin> getAdmin() {
        return admin;
    }
    
        
       

}
