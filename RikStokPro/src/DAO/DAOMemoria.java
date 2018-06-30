package DAO;

import EDA.*;
import java.io.IOException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;

public class DAOMemoria implements DAOFacade{
        private static DAOMemoria memoria;
        
        
	private ArrayList<Produto> produtos = new ArrayList();
	private ArrayList<User> usuarios  = new ArrayList();

	

	public static DAOMemoria get() {
            if( memoria == null )
                memoria = new DAOMemoria();
            return memoria;
	}
        
        private void DAOMemoria() {
            init();    
            
            
            
	}
        
        public void init(){
            DAOArquivo.lerProdutos();
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
        public ArrayList<User> getUser() {
            return usuarios;
        }

    
        
       

}
