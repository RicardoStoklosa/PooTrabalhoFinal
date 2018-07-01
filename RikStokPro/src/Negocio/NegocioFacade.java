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

    public static int login(String login, String senha) {
        senha = Toolbox.encrypt(senha);
        return registros.verifCredenciais(login, senha);
        
    }

    public static boolean addProduto(Produto produto) throws QuantInvalida, ProdjaRegistrado, ErroRegistrar {
      

        int q = produto.getQuantidade();
        if (q < 0) {
            throw new QuantInvalida();
        }

        for (Produto aux : registros.getProdutos()) {

            if (produto.getId() == aux.getId()) {
                throw new ProdjaRegistrado();
            }

        }
         return registros.addProduto(produto);
           
    }

    /**
     *
     * @param produto
     * @return
     */
    public static void editProduto(Produto produto) throws ProdNotExist, QuantInvalida {

        if(! registros.editProduto(produto) ){
            throw new ProdNotExist();
        }
        if (produto.getQuantidade() < 0) {
            throw new QuantInvalida();
        }
        
        
    }

    public static void rmProduto(Produto produto) throws ProdNotExist {
        if(!registros.rmProduto(produto)) throw new ProdNotExist();
    }

    public static void init() {
        registros.init();
    }

    public static ArrayList<Produto> getProdutos() {
        return registros.getProdutos();
    }

    public static Produto getProdutosId(int id) throws ProdNotExist {
        for (Produto produto : NegocioFacade.registros.getProdutos()) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        throw new ProdNotExist();
    }
    
    public static void retiradaEstoque(int id, int quant) throws QuantInvalida, ProdNotExist{
        Produto d = getProdutosId(id);
        if(quant>d.getQuantidade())
            throw new QuantInvalida();
        d.setQuantidade(d.getQuantidade()-quant);
    }

    public static void exit() throws IOException {
        arquivos.saveProdutos();
    }
}
