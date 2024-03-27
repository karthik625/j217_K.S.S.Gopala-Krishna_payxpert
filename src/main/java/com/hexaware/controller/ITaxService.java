package com.hexaware.controller;

/**
 * Interface defining operations related to tax services.
 */
public interface ITaxService {
	/**
     * Calculates tax.
     */
	public void CalculateTax();
	/**
     * Retrieves tax by ID.
     */
	public void GetTaxById();
	/**
     * Retrieves taxes for an employee.
     */
	public void GetTaxesForEmployee();
	/**
     * Retrieves taxes for a specific year.
     */
	public void GetTaxesForYear();
}
