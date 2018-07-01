package EDA;

public class Caixa extends User {

	private String login;

	private String senha;

    

	public  Caixa(String login, String senha) {
            this.login = login;
            this.senha = senha;
        
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

}
