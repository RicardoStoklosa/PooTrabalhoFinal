package EDA;

public class Estoque extends User {

	private String login;

	private String senha;

	public void Admin(String login, String senha) {
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
