package br.edu.ifpe.paulista.sample.project.business;

import br.edu.ifpe.paulista.sample.project.data.MySQLRepository;
import br.edu.ifpe.paulista.sample.project.data.Repository;
import br.edu.ifpe.paulista.sample.project.ui.entities.User;
import br.edu.ifpe.paulista.sample.project.ui.exceptions.BusinessException;
import br.edu.ifpe.paulista.sample.project.ui.exceptions.SystemException;

public class UserController {

	public void createUser(String login, String password, String passwordConfirmation) throws BusinessException, SystemException {
		if (login.length() < 8) {
			throw new BusinessException("Invalid login, it must have at least 8 characters");
		}
		
		if (password.length() < 8) {
			throw new BusinessException("Invalid password, it must have at least 8 characters");
		}
		
		if (!password.equals(passwordConfirmation)) {
			throw new BusinessException("The password must be equal to the confirmation");
		}
		
		Repository repository = new MySQLRepository();
		
		if (repository.hasUser(login)) {
			throw new BusinessException("The user already exists");
		}
		
		User user = new User(1, login, password);
		repository.addUser(user);		
	}
	
}
