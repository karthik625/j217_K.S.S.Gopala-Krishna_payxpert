package com.hexaware.exception;

import java.sql.SQLException;
/**
 * Exception class representing a database connection error.
 */
@SuppressWarnings("serial")
public class DatabaseConnectionException extends SQLException {	
	/**
     * Constructs a DatabaseConnectionException with the specified detail message.
     * 
     * @param message The detail message.
     */
	public DatabaseConnectionException(String message) {
		super(message);
	};
	
}