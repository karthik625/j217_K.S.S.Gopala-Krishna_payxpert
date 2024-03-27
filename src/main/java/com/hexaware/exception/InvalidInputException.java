package com.hexaware.exception;
/**
 * Exception class representing an invalid input error.
 */
@SuppressWarnings("serial")
public class InvalidInputException extends Exception{
	/**
     * Constructs an InvalidInputException with the specified detail message.
     * 
     * @param message The detail message.
     */
	public InvalidInputException(String message) {
		super(message);
	}
}