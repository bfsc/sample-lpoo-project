package br.edu.ifpe.paulista.model;

public class User {

	private long id;
	private String login;
	private String password;
	
	public User() {
		
	}
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String senha) {
		this.password = senha;
	}
	
}
