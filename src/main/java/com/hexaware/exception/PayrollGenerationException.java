package com.hexaware.exception;
/**
 * Exception class representing an error during payroll generation.
 */
@SuppressWarnings("serial")
public class PayrollGenerationException extends Exception {
	/**
     * Constructs a PayrollGenerationException with the specified detail message.
     * 
     * @param message The detail message.
     */
	public PayrollGenerationException(String message) {
		super(message);
	}
}