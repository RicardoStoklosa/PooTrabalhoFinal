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
public class ProdjaRegistrado extends Exception{
    
    public ProdjaRegistrado(){
        super();
    }

    @Override
    public String toString() {
        return "Código de Produto já registrado";
    }
    
    
    
}
