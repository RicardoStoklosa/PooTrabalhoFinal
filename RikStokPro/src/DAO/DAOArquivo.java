/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import EDA.*;
import Negocio.NegocioFacade;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            js.put("quantidade", current.getQuantidade());
            js.put("valor", current.getValor());
            js.put("litros", current instanceof Liquido ? ((Liquido)current).getLitros() : null);
            js.put("temperatura", current instanceof Frios ? ((Frios)current).getTemp() : null);
            js.put("peso", current instanceof Secos ? ((Secos)current).getPeso() : null);
            
            
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
               
                if(jobj.get("litros")!=null)
                    NegocioFacade.addProduto(new Liquido((Double) jobj.get("litros"), (String)jobj.get("nome"), ((Long)jobj.get("id")).intValue(), ((Long)jobj.get("quantidade")).intValue(), (Double)jobj.get("valor")));
                if(jobj.get("peso")!=null)
                    NegocioFacade.addProduto(new Secos(((Double)jobj.get("peso")), (String) jobj.get("nome"), ((Long)jobj.get("id")).intValue(), ((Long)jobj.get("quantidade")).intValue(), (Double)jobj.get("valor")));
                if(jobj.get("temperatura")!=null)
                    NegocioFacade.addProduto(new Frios((Double)jobj.get("temperatura"), (String) jobj.get("nome"), ((Long)jobj.get("id")).intValue(), ((Long)jobj.get("quantidade")).intValue(), (Double)jobj.get("valor")));
                
                
                
                
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
        throw new UnsupportedOperationException("Not supported yet."); 
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

    @Override
    public boolean verifCredenciais(String login, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
