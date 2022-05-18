package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql//localhost:3306/courses_db", "root", "");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error: Could not connect to the database!");
			return null;
		}
	}
}
