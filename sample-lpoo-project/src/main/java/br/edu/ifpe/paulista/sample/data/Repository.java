package br.edu.ifpe.paulista.sample.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifpe.paulista.model.User;

public class Repository {

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/lpoo-2023.2", "root", "12345");
	}
	
	public boolean hasUser(String login) {
		try {
			Connection conn = getConnection();
			PreparedStatement stmt =  conn.prepareStatement("SELECT * FROM user u WHERE u.login = ?");
			stmt.setString(1, login);
			ResultSet result = stmt.executeQuery();
			return result.next();
		} catch (Exception e) {
			throw new DataException("Error trying to access database.", e);
		}
	}
	
	public void addUser(User user) {
		try {
			Connection conn = getConnection();
			PreparedStatement stmt =  conn.prepareStatement("INSERT INTO user (login, password) VALUES(?, ?)");
			stmt.setString(1, user.getLogin());
			stmt.setString(2, user.getPassword());
			stmt.execute();
		} catch (Exception e) {
			throw new DataException("Error trying to access database.", e);
		}
	}
	
	public User searchUserByLogin(String login) {
		try {
			Connection conn = getConnection();
			PreparedStatement stmt =  conn.prepareStatement("SELECT * FROM user u WHERE u.login = ?");
			stmt.setString(1, login);
			ResultSet result = stmt.executeQuery();
			
			User user = null;
			if (result.next()) {
				user = new User();
				user.setLogin(result.getString("login"));
				user.setPassword(result.getString("password"));
			}
			return user;
		} catch (Exception e) {
			throw new DataException("Error trying to access database.", e);
		}
	}

	public void removeUser(String login) {
		try {
			Connection conn = getConnection();
			PreparedStatement stmt =  conn.prepareStatement("DELETE FROM user u WHERE u.login = ?");
			stmt.setString(1, login);
			stmt.execute();
		} catch (Exception e) {
			throw new DataException("Error trying to access database.", e);
		}
	}
	
}
