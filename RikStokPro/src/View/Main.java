/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import EDA.*;
import DAO.*;
import Negocio.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author stokl
 */
public class Main {
    public static NegocioFacade negocio = new NegocioFacade();
    public static void main(String args[]) throws IOException{
        negocio.init();
//        negocio.addProduto(new Frios(-30.00, "presunto", 75, 45, 1.20));
//        negocio.addProduto(new Liquido(1.00, "leite", 64, 12, 2.20));
//        negocio.addProduto(new Secos(10.00, "arroz", 15, 7, 4.00));
//        
                
        ArrayList<Produto> produt= NegocioFacade.getProdutos();
        for( Produto prod : produt){
            System.out.println(prod);
            
        }
       negocio.exit();
        
    }
    
}
