package br.edu.ifpe.paulista.project.data;

import br.edu.ifpe.paulista.project.entities.User;

public interface Repository {

	public void insertUser(User user);
	
	public boolean existsUser(String login);
	
}
