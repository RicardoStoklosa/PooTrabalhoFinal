package DAO;

import EDA.*;
import java.util.ArrayList;

public interface DAOFacade {

	public boolean verificarCredenciais(String login, String senha);
	public boolean addProduto(Produto produto);
	public boolean rmProduto(Produto produto);
	public boolean editProduto(Produto produto);
	public ArrayList<Produto> getProdutos();
        public ArrayList<Admin> getAdmin();

}
