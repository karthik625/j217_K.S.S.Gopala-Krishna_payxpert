   package com.hexaware.model;

import java.time.Year;
import java.util.Date;
/**
 * Represents tax information for an employee in the system.
 */
public class Tax {
	int TaxID, EmployeeID;
	Year TaxYear;
	double TaxableIncome, TaxAmount;
	/**
     * Default constructor for the Tax class.
     */
	public Tax() {
		super();
	};
	/**
     * Constructs a Tax object with specified attributes.
     * 
     * @param taxID         The ID of the tax record.
     * @param employeeID    The ID of the employee associated with the tax record.
     * @param taxYear       The year to which the tax information applies.
     * @param taxableIncome The income subject to taxation.
     * @param taxAmount     The amount of tax to be paid.
     */
	public Tax(int taxID, int employeeID, Year taxYear, double taxableIncome, double taxAmount) {
		super();
		TaxID = taxID;
		EmployeeID = employeeID;
		TaxYear = taxYear;
		TaxableIncome = taxableIncome;
		TaxAmount = taxAmount;
	}
	// Getters and setters for all attributes
	/**
     * Retrieves the tax ID.
     * 
     * @return The tax ID.
     */
	public int getTaxID() {
		return TaxID;
	}
	/**
     * Sets the tax ID.
     * 
     * @param taxID The tax ID to set.
     */
	public void setTaxID(int taxID) {
		TaxID = taxID;
	}
	 /**
     * Retrieves the employee ID associated with the tax record.
     * 
     * @return The employee ID.
     */
	public int getEmployeeID() {
		return EmployeeID;
	}
	/**
     * Sets the employee ID associated with the tax record.
     * 
     * @param employeeID The employee ID to set.
     */
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	/**
     * Retrieves the tax year.
     * 
     * @return The tax year.
     */
	public Year getTaxYear() {
		return TaxYear;
	}
	/**
     * Sets the tax year.
     * 
     * @param taxYear The tax year to set.
     */
	public void setTaxYear(Year taxYear) {
		TaxYear = taxYear;
	}
	/**
     * Retrieves the taxable income.
     * 
     * @return The taxable income.
     */
	public double getTaxableIncome() {
		return TaxableIncome;
	}
	/**
     * Sets the taxable income.
     * 
     * @param taxableIncome The taxable income to set.
     */
	public void setTaxableIncome(double taxableIncome) {
		TaxableIncome = taxableIncome;
	}
	/**
     * Retrieves the tax amount.
     * 
     * @return The tax amount.
     */
	public double getTaxAmount() {
		return TaxAmount;
	}
	/**
     * Sets the tax amount.
     * 
     * @param taxAmount The tax amount to set.
     */
	public void setTaxAmount(double taxAmount) {
		TaxAmount = taxAmount;
	}
	/**
     * Returns a string representation of the Tax object.
     */
	@Override
	public String toString() {
		return "Tax [TaxID=" + TaxID + ", EmployeeID=" + EmployeeID + ", TaxYear=" + TaxYear + ", TaxableIncome="
				+ TaxableIncome + ", TaxAmount=" + TaxAmount + "]";
	}
	
}
