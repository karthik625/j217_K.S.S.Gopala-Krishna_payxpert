package com.hexaware.exception;
/**
 * Exception class representing a financial record-related error.
 */
@SuppressWarnings("serial")
public class FinancialRecordException extends Exception{
	 /**
     * Constructs a FinancialRecordException with the specified detail message.
     * 
     * @param message The detail message.
     */
	public FinancialRecordException(String message) {
		super(message);
	}
}
