package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSetMetaData;

public class A {
	String url = "jdbc:mysql://192.168.43.177:3306/trans";
	String user = "admin";
	String password = "root";

	private Connection connection;
	
	public A() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("bd ok");
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("bd pas ok");
		}
	}
	
	public ResultSet executeQuery(String query) {
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insertValues(String query) {
		try {
			Statement statement = connection.createStatement();
			statement.execute(query);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
