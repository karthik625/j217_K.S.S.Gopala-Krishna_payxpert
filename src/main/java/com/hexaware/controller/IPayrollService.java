package com.hexaware.controller;
/**
 * Interface defining operations related to payroll services.
 */
public interface IPayrollService {
	/**
     * Generates payroll.
     */
	public void GeneratePayroll();
	/**
     * Retrieves payroll by ID.
     */
	public void GetPayrollById();
	/**
     * Retrieves payrolls for an employee.
     */
	public void GetPayrollsForEmployee();
	/**
     * Retrieves payrolls for a specific period.
     */
	public void GetPayrollsForPeriod();
}
