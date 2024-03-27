package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for managing database connections.
 */
public class DatabaseContext {
	/**
	 * Attempts to establish a database connection.
	 * 
	 * @return A Connection object representing the database connection, or null if
	 *         the connection fails.
	 */
	public static Connection getConnection() {
		try {

			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payxpert", "root", "Karthik@123");
			if (connection != null) {
				return connection;
			} else {
				System.out.println("Failed to establish a database connection.");
				return null;
			}
		} catch (SQLException ex) {
			System.out.println("exception");

			return null;
		}
	}

	/**
	 * Closes the given database connection.
	 * 
	 * @param connection The Connection object to be closed.
	 */
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				System.out.println("exceptions");

			}
		}
	}
}
