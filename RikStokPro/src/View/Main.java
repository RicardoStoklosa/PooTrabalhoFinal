/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import EDA.*;
import DAO.*;
import Negocio.*;
import java.util.ArrayList;

/**
 *
 * @author stokl
 */
public class Main {
    
    public static void main(String args[]){
        NegocioFacade.init();
        System.out.println(Toolbox.encrypt("oi"));
        ArrayList<Produto> produt= NegocioFacade.getProdutos();
        for( Produto prod : produt){
            System.out.println(prod);
            
        }
    }
    
}
