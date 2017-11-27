package View;

import DAO.DAOMemoria;
import EDA.Admin;
import Negocio.NegocioFacade;

/**
 * @author UDESC
 */
public class Main {
    public static Admin adm;
    public static Menu tela_menu;
    
    
    private Main(){}
    
    public static void main(String args[]){
        NegocioFacade.init();
        Login tela = new Login();
        
        tela.setVisible( true );
    }
}