package DAO;

import EDA.*;

import java.util.ArrayList;

public interface DAOFacade {
        public void init();
	public boolean addProduto(Produto produto);
	public boolean rmProduto(Produto produto);
	public boolean editProduto(Produto produto);
	public ArrayList<Produto> getProdutos();
        public ArrayList<User>getUser();
        public boolean verifCredenciais(String login, String senha);
        

}
