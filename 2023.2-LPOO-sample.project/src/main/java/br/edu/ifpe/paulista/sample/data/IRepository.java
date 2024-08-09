package br.edu.ifpe.paulista.sample.data;

import br.edu.ifpe.paulista.model.User;

public interface IRepository {

	public boolean hasUser(String login);
	
	public void addUser(User user);
	
	public void removeUser(String login);
	
}
