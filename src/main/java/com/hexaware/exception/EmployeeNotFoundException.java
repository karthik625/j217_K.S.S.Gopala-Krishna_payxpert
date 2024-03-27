package com.hexaware.exception;
/**
 * Exception class representing an employee not found error.
 */
@SuppressWarnings("serial")
public class EmployeeNotFoundException extends Exception {
	/**
     * Constructs an EmployeeNotFoundException with the specified detail message.
     * 
     * @param message The detail message.
     */
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
