package br.edu.ifpe.paulista.sample.project.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ifpe.paulista.sample.project.ui.entities.User;
import br.edu.ifpe.paulista.sample.project.ui.exceptions.SystemException;

public class MySQLRepository implements Repository {

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/lpoo-2024.1-sample.project", "root", "12345");
	}
	
	@Override
	public void addUser(User user) throws SystemException {
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String sqlCommand = "INSERT INTO user(login, password) VALUES ('" + user.getLogin() + "', '"+ user.getPassword() +"')";
			statement.execute(sqlCommand);
			statement.close();
			connection.close();
		} catch (Exception e) {
			throw new SystemException("A system error has occurred, try again later", e);
		}
	}

	@Override
	public boolean hasUser(String login) throws SystemException {
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			String sqlCommand = "SELECT * FROM user u WHERE u.login = '" + login + "'";
			ResultSet resultSet = statement.executeQuery(sqlCommand);
			return resultSet.next();
		} catch (Exception e) {
			throw new SystemException("A system error has occurred, try again later", e);
		}
	}
	
}
