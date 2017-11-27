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
    
    /**
     * Limpa o buffer de leitura em uma linha, caso exista.
     * @param teclado o Scanner a ser utilizado na verificação
     */
    public static void clearBuffer( Scanner teclado ){
        teclado.skip("\n");
    }
    
    /**
     * Este método limpa o buffer e aguarda até o usuário pressionar enter.
     * Se algum texto for digitado junto, este será ignorado.
     * @param teclado o Scanner a ser utilizado na operação
     */
    public static void pressEnter( Scanner teclado ){
        System.out.print("Pressione ENTER para continuar...");
        clearBuffer( teclado );
        teclado.nextLine();
    }
  
}
