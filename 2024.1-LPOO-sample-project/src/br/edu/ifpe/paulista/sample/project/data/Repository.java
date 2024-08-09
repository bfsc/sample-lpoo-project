package br.edu.ifpe.paulista.sample.project.data;

import br.edu.ifpe.paulista.sample.project.ui.entities.User;
import br.edu.ifpe.paulista.sample.project.ui.exceptions.SystemException;

public interface Repository {

	public void addUser(User user) throws SystemException;
	
	public boolean hasUser(String login)throws SystemException;
	
}
