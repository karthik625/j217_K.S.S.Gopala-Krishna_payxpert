package com.hexaware.exception;
/**
 * Exception class representing an error during tax calculation.
 */
@SuppressWarnings("serial")
public class TaxCalculationException extends Exception{
	 /**
     * Constructs a TaxCalculationException with the specified detail message.
     * 
     * @param message The detail message.
     */
	public TaxCalculationException(String message) {
		super(message);
	}
}