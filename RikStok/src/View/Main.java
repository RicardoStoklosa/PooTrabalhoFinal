package View;

import EDA.Admin;

/**
 * @author UDESC
 */
public class Main {
    public static Admin adm;
    public static Menu tela_menu;
    
    private Main(){}
    
    public static void main(String args[]){
        Login tela = new Login();
        
        tela.setVisible( true );
    }
}