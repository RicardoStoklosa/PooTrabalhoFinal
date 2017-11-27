package EDA;

public class Operacao {
    private boolean status;
    private StringBuilder erro;
    
    public Operacao( ){
        status = true;
    }

    /**
     * @return the status
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * @return the erro
     */
    public StringBuilder getErro() {
        return erro;
    }

    /**
     * Limpa o texto de erro.
     */
    public void limparErro(){
        status = true;
        erro = new StringBuilder();
    }
    
    /**
     * Anexa erro na string de erro(s).
     * @param err define um novo erro
     */
    public void anexarErro(String err) {
        status = false;
        if( erro == null )
            erro = new StringBuilder();
        else
            erro.append("\n");
        erro.append( err );
    }
    
    
    
    
    
    
}