package Negocio;

import DAO.*;
import java.util.ArrayList;
import EDA.*;
import java.io.IOException;
import Exceção.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NegocioFacade {

    static final DAOFacade registros = DAOMemoria.get();
    static final DAOArquivo arquivos = DAOArquivo.get();

    public NegocioFacade() {
    }

    public static boolean login(String login, String senha) {
        senha = Toolbox.encrypt(senha);
        try {
            boolean ok = registros.verifCredenciais(login, senha);
            if (ok == false) {
                throw new UsernotFound();
            }
            if (ok == true) {
                return true;
            }
        } catch (UsernotFound e) {
            System.out.println("Ocorreu um problema!");
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public static boolean addProduto(Produto produto) {
        //TODO
        boolean status = true;
        try {
            int q = produto.getQuantidade();
            if (q < 0) {
                throw new QuantInvalida();
            }
        } catch (QuantInvalida ex) {
            System.out.println("Ocorreu um problema!");
            ex.printStackTrace();
            status = false;
        }
        for (Produto aux : registros.getProdutos()) {
            try {
                if (produto.getId() == aux.getId()) {
                    throw new ProdjaRegistrado();
                }
            } catch (ProdjaRegistrado ex) {
                System.out.println("Ocorreu um problema!");
                ex.printStackTrace();
                status = false;
            }
        }
        if (status == true) {
            try {
                boolean res = registros.addProduto(produto);
                if (res == false) {
                    throw new ErroRegistrar();
                }
            } catch (ErroRegistrar ex) {
                System.out.println("Ocorreu um problema");
                ex.printStackTrace();
            }
        }
        return status;
    }

    /**
     *
     * @param produto
     * @return
     */
    public static boolean editProduto(Produto produto) {
        //TODO
        boolean status = true;
        boolean bol = registros.editProduto(produto);
        try{
            if(produto.getQuantidade() < 0)
                throw new QuantInvalida();
            else if(!bol){
                throw new ProdNaoExiste();
            }
        } catch (QuantInvalida | ProdNaoExiste ex) {
            System.out.println("Ocorreu um problema");
            ex.printStackTrace();
            status=false;
        }
        return status;
    }

    public static void rmProduto(Produto produto) {
        registros.rmProduto(produto);
    }

    public static void init() {
        registros.init();
    }

    public static ArrayList<Produto> getProdutos() {
        return registros.getProdutos();
    }

    public static Produto getProdutosId(int id) {
        for (Produto produto : NegocioFacade.registros.getProdutos()) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public static void exit() throws IOException {
        arquivos.saveProdutos();
    }
}
