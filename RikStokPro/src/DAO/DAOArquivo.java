/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import EDA.Produto;
import EDA.User;
import Negocio.NegocioFacade;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author stokl
 */
public class DAOArquivo implements DAOFacade{
    private static DAOArquivo arquivo;
    
   public static DAOArquivo get() {
            if( arquivo == null )
                arquivo = new DAOArquivo();
            return arquivo;
    }
    public static void saveProdutos() throws IOException{
        
        JSONObject js = new JSONObject();
        File arquivo = new File("products.json");
        FileOutputStream out = new FileOutputStream(arquivo,false);
        out.write("".getBytes());
        out = new FileOutputStream(arquivo,false);
        ArrayList<Produto> products = NegocioFacade.getProdutos();
        for(Produto current : products){
            
            js.put("id", current.getId());
            js.put("nome", current.getNome());
            try{
                System.out.println(js.toJSONString());
                out.write( (js.toJSONString()+"\n").getBytes() );
                
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        out.close();
        
    }
    
    public static void lerProdutos(){
        JSONObject jobj;
        JSONParser parser = new JSONParser();
        String line;
        try{
            FileReader file = new FileReader("products.json");
            BufferedReader buffer = new BufferedReader(file);
            while((line = buffer.readLine()) != null){
                jobj = (JSONObject) parser.parse(line);
                NegocioFacade.addProduto(new Produto((String) jobj.get("nome"),  ((Long)jobj.get("id")).intValue(), 0, 0));
            }
 
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addProduto(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean rmProduto(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editProduto(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Produto> getProdutos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> getUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
