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
            usuarios.add(new Caixa("caixa","a3cb966624ac67ed7d8e77c0f39ba36f"));
            usuarios.add(new Estoque("estoque","6cfb561ab73cea537cdb793c22c1aa6f"));
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
        
        @Override
        public int verifCredenciais(String login, String senha){
            for(User usr: usuarios){
                
                    
                
                if(usr instanceof Caixa){
                    if( (((Caixa) usr).getLogin() ).compareTo(login)==0  &&  (((Caixa) usr).getSenha()).compareTo(senha)==0 ) 
                        return 1;
                }
                if(usr instanceof Estoque){
                    if( (((Estoque) usr).getLogin() ).compareTo(login)==0  &&  (((Estoque) usr).getSenha()).compareTo(senha)==0 ) 
                        return 0;
                }
            }
            return -1;
        }

    
        
       

}
