package br.edu.ifpe.paulista.project.business;

import br.edu.ifpe.paulista.project.data.MySQLRepository;
import br.edu.ifpe.paulista.project.data.Repository;
import br.edu.ifpe.paulista.project.entities.User;
import br.edu.ifpe.paulista.project.exceptions.BusinessException;

public class UserController {

	public void registerUser(String login, String password, String passwordConnfirmation) {
		// Validacoes
		
		if (login.isBlank()) {
			throw new BusinessException("O login não pode ser vazio");
		}
		
		if (login.length() < 4) {
			throw new BusinessException("O login precisa ter ao menos 4 caracteres");
		}
		
		if (password.isBlank()) {
			throw new BusinessException("A senha não pode ser vazia");
		}
		
		if (password.length() < 8) {
			throw new BusinessException("A senha precisa ter ao menos 8 caracteres");
		}
		
		if (!password.equals(passwordConnfirmation)) {
			throw new BusinessException("A senha precisa ser igual a confirmação");
		}
		
		User user = new User(login, password);
		
		Repository repository = new MySQLRepository();
		
		// checar se ja existe usuario com o mesmo login
		boolean exists = repository.existsUser(login);
		
		if (exists) {
			throw new BusinessException("Já existe um usuário com esse login");
		}
		
		// chamar a camada de dados para persistir os dados
		repository.insertUser(user);
	}
	
}
