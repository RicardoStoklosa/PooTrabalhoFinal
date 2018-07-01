/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceção;

/**
 *
 * @author gustavo
 */
public class ProdNotExist extends Exception {

    public ProdNotExist() {
    super();
    }

    @Override
    public String toString() {
        return "o Produto não existe";
    }
    
    
    
}
