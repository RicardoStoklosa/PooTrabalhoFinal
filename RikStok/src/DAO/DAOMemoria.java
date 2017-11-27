package DAO;

import EDA.*;
import java.util.ArrayList;

public class DAOMemoria implements DAOFacade{
        private static DAOMemoria memoria;
        
        private Admin administrador;
	private ArrayList<Produto> produtos;
	private ArrayList<Admin> admin;

	

	public static DAOMemoria get() {
            if( memoria == null )
                memoria = new DAOMemoria();
            return memoria;
	}
        
        public void DAOMemoria() {
            init();     
	}
        
        private void init(){
            administrador = new Admin("udesc", "785b10a64d56af61e802913738e7d567");
        }
        @Override
	public Admin verificarCredenciais(String login, String senha) {
            if( administrador.getLogin().compareTo(login)==0  &&  administrador.getSenha().compareTo(senha)==0 ) {
                return administrador;
            }
            return null;
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
       

}
