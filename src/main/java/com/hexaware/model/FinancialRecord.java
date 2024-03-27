package com.hexaware.model;

import java.util.Date;
/**
 * Represents a financial record for an employee in the system.
 */
public class FinancialRecord {
	private int RecordID, EmployeeID;
	private Date RecordDate;
	private String Description, RecordType;
	private double Amount;
	/**
     * Default constructor for the FinancialRecord class.
     */
	public FinancialRecord() {
		super();
	};
	/**
     * Constructs a FinancialRecord object with specified attributes.
     * 
     * @param recordID    The ID of the financial record.
     * @param employeeID  The ID of the employee associated with the financial record.
     * @param recordDate  The date of the financial record.
     * @param description The description or category of the financial record.
     * @param recordType  The type of financial record (income, expense, tax payment, etc.).
     * @param amount      The monetary amount of the financial record.
     */
	public FinancialRecord(int recordID, int employeeID, Date recordDate, String description, String recordType,
			double amount) {
		RecordID = recordID;
		EmployeeID = employeeID;
		RecordDate = recordDate;
		Description = description;
		RecordType = recordType;
		Amount = amount;
	}
	// Getters and setters for all attributes
	 /**
     * Retrieves the record ID of the financial record.
     * 
     * @return The record ID.
     */
	public int getRecordID() {
		return RecordID;
	}
	/**
     * Sets the record ID of the financial record.
     * 
     * @param recordID The record ID to set.
     */
	public void setRecordID(int recordID) {
		RecordID = recordID;
	}
	/**
     * Retrieves the employee ID associated with the financial record.
     * 
     * @return The employee ID.
     */
	public int getEmployeeID() {
		return EmployeeID;
	}
	/**
     * Sets the employee ID associated with the financial record.
     * 
     * @param employeeID The employee ID to set.
     */
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	/**
     * Retrieves the date of the financial record.
     * 
     * @return The date of the financial record.
     */
	public Date getRecordDate() {
		return RecordDate;
	}
	/**
     * Sets the date of the financial record.
     * 
     * @param recordDate The date to set.
     */
	public void setRecordDate(Date recordDate) {
		RecordDate = recordDate;
	}
	/**
     * Retrieves the description or category of the financial record.
     * 
     * @return The description of the financial record.
     */
	public String getDescription() {
		return Description;
	}
	/**
     * Sets the description or category of the financial record.
     * 
     * @param description The description to set.
     */
	public void setDescription(String description) {
		Description = description;
	}
	/**
     * Retrieves the type of financial record.
     * 
     * @return The type of financial record.
     */
	public String getRecordType() {
		return RecordType;
	}
	/**
     * Sets the type of financial record.
     * 
     * @param recordType The type to set.
     */
	public void setRecordType(String recordType) {
		RecordType = recordType;
	}
	/**
     * Retrieves the monetary amount of the financial record.
     * 
     * @return The amount of the financial record.
     */
	public double getAmount() {
		return Amount;
	}
	/**
     * Sets the monetary amount of the financial record.
     * 
     * @param amount The amount to set.
     */
	public void setAmount(double amount) {
		Amount = amount;
	}
	/**
     * Returns a string representation of the FinancialRecord object.
     */
	@Override
	public String toString() {
		return "FinancialRecord [RecordID=" + RecordID + ", EmployeeID=" + EmployeeID + ", RecordDate=" + RecordDate
				+ ", Description=" + Description + ", RecordType=" + RecordType + ", Amount=" + Amount + "]";
	}
}
