package com.hexaware.controller;
/**
 * Interface defining operations related to employee services.
 */
public  interface IEmployeeService {
	 /**
     * Retrieves an employee by their ID.
     */
	public void GetEmployeeById();
	/**
     * Retrieves all employees.
     */
	public void GetAllEmployees();
	/**
     * Adds a new employee.
     */
	public void AddEmployee();
	/**
     * Updates an existing employee.
     */
	public void UpdateEmployee();
	 /**
     * Removes an employee.
     */
	public void RemoveEmployee();
}
