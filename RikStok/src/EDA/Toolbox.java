package EDA;
import java.security.MessageDigest;
import java.util.Scanner;

/**
 * @author UDESC
 */
public class Toolbox {
    
    /**
     * Criptografa um texto passado como parâmetro usando o algoritmo
     *      MD5 nativo do JAVA.
     * @param texto o texto a ser criptografado
     * @return texto criptografado
     */
    public static String encrypt(String texto){
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5"); // cria instancia de um encriptador MD5
            md.update( texto.getBytes() ); // adicionar o texto a ser encriptado
            byte[] bytes = md.digest(); // resgatar o texto criptografado em bytes
            
            // Converter o texto para hexadecimal
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));           
            result = sb.toString();
        } 
        catch (Exception e) {
            System.err.println("O algoritmo de criptografia não é válido");
            e.printStackTrace();
        }
        return result;
    }
    
    
  
}
