package EDA;

public class Admin {

    private String login;

    private String senha;

    public Admin(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

}
