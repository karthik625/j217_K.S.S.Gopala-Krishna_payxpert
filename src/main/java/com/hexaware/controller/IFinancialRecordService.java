package com.hexaware.controller;
/**
 * Interface defining operations related to financial record services.
 */
public interface IFinancialRecordService {
	/**
     * Adds a financial record.
     */
	public void AddFinancialRecord();
	/**
     * Retrieves a financial record by ID.
     */
	public void GetFinancialRecordById();
	/**
     * Retrieves financial records for an employee.
     */
	public void GetFinancialRecordsForEmployee();
	/**
     * Retrieves financial records for a specific date.
     */
	public void GetFinancialRecordsForDate();
	}
