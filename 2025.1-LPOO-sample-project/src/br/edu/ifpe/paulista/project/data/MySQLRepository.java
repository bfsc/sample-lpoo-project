package br.edu.ifpe.paulista.project.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpe.paulista.project.entities.User;
import br.edu.ifpe.paulista.project.exceptions.SystemException;

public class MySQLRepository implements Repository {

	@Override
	public void insertUser(User user) {
		try {
			Connection conn = connect();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO user(login, password) VALUES (?,?)");
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getPassword());
			stmt.execute();		
		} catch (Exception exception) {
			throw new SystemException("Erro no sistema, tente mais tarde", exception);
		}
	}
	
	@Override
	public boolean existsUser(String login) {
		try {
			Connection conn = connect();
			PreparedStatement stmt = conn.prepareStatement("SELECT login FROM user WHERE login = ?;");
			stmt.setString(1, login);
			ResultSet result = stmt.executeQuery();
			return result.next();
		} catch (Exception exception) {
			throw new SystemException("Erro no sistema, tente mais tarde", exception);
		}
	}
	
	private Connection connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/lpoo-2025.1", "root", "12345");
	}

}
