package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class A {
	String url = "jdbc:mysql://localhost:3306/test";
	String user = "baya";
	String password = "root";

	// Load the Connector/J driver
	
	// Establish connection to MySQL
	
	
	public A() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("&");
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		A a = new A();
	}
}
