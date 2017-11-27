package Negocio;


import DAO.*;
import java.util.ArrayList;
import EDA.*;

public class NegocioFacade {

	static final DAOFacade registros = DAOMemoria.get();
        
        private NegocioFacade(){}

	public static Admin login(String login, String senha){
            senha = Toolbox.encrypt( senha );
            Admin adm = registros.verificarCredenciais( login, senha );
            return adm;
        }
        
	public boolean addProduto(Produto produto) {
		return true;
	}

	public boolean rmProduto(Produto produto) {
		return true;
	}

	public boolean editProduto(Produto produto) {
		return true;
	}

	public ArrayList<Produto> getProdutos() {
		return null;
	}

	public ArrayList<Admin> getAdmin(Admin adm) {
		return null;
	}

}
