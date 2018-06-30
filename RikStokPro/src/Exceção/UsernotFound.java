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
public class UsernotFound extends Exception{
    
    public UsernotFound(){
        super();
    }
    
    @Override
    public String toString(){
        return "Usuário não encontrado!";
    }
    
}
