package br.edu.ifpe.paulista.sample.business;

import br.edu.ifpe.paulista.model.User;
import br.edu.ifpe.paulista.sample.data.IRepository;
import br.edu.ifpe.paulista.sample.data.Repository;

public class UserController {

	private IRepository repository;
	
	public UserController() {
		this.repository = new Repository();
	}
	
	public void createUser(String login, String password, String passwordConfirmation) {
		if (login.isBlank()) {
			throw new BusinessException("The login cannot be blank.");
		}
		
		if (password.isBlank()) {
			throw new BusinessException("The password cannot be blank.");
		}
		
		if (!password.equals(passwordConfirmation)) {
			throw new BusinessException("The password and confirmation must be the same.");
		}
		
		if (password.length() < 8) {
			throw new BusinessException("The password must have at least 8 characters");
		}
		
		boolean hasUser = repository.hasUser(login);
		if (hasUser) {
			throw new BusinessException("There is a user with the given login");
		}
		
		User user = new User(login, password);
		repository.addUser(user);
	}
	
	public User searchUserByLogin(String login) {
		if (login.isBlank()) {
			throw new BusinessException("The login cannot be blank.");
		}
		
		Repository repo = new Repository();
		return repo.searchUserByLogin(login);
	}
	
	public void deleteUser(String login) {
		Repository repo = new Repository();
		repo.removeUser(login);
	}

	public IRepository getRepository() {
		return repository;
	}

	public void setRepository(IRepository repository) {
		this.repository = repository;
	}
	
	
	
}
