package com.hexaware.model;

import java.util.Date;

/**
 * Represents payroll information for an employee in the system.
 */
public class Payroll {
	int PayrollID, EmployeeID;
	Date PayPeriodStartDate, PayPeriodEndDate;
	Double BasicSalary, OvertimePay, Deductions, NetSalary;

	/**
	 * Default constructor for the Payroll class.
	 */
	public Payroll() {
		super();
	};

	/**
	 * Constructs a Payroll object with specified attributes.
	 * 
	 * @param payrollID          The ID of the payroll record.
	 * @param employeeID         The ID of the employee associated with the payroll
	 *                           record.
	 * @param payPeriodStartDate The start date of the pay period.
	 * @param payPeriodEndDate   The end date of the pay period.
	 * @param basicSalary        The base salary for the pay period.
	 * @param overtimePay        The additional pay for overtime hours.
	 * @param deductions         The total deductions for the pay period.
	 * @param netSalary          The net salary after deductions.
	 */
	public Payroll(int payrollID, int employeeID, Date payPeriodStartDate, Date payPeriodEndDate, Double basicSalary,
			Double overtimePay, Double deductions, Double netSalary) {

		PayrollID = payrollID;
		EmployeeID = employeeID;
		PayPeriodStartDate = payPeriodStartDate;
		PayPeriodEndDate = payPeriodEndDate;
		BasicSalary = basicSalary;
		OvertimePay = overtimePay;
		Deductions = deductions;
		NetSalary = netSalary;
	}
	/**
     * Constructs a Payroll object with specified attributes.
     * 
     * @param employeeID         The ID of the employee associated with the payroll
     *                           record.
     * @param payPeriodStartDate The start date of the pay period.
     * @param payPeriodEndDate   The end date of the pay period.
     * @param basicSalary        The base salary for the pay period.
     * @param overtimePay        The additional pay for overtime hours.
     * @param deductions         The total deductions for the pay period.
     */
	public Payroll(int employeeID, Date payPeriodStartDate, Date payPeriodEndDate, double basicSalary,
			double overtimePay, double deductions) {
		EmployeeID = employeeID;
		PayPeriodStartDate = payPeriodStartDate;
		PayPeriodEndDate = payPeriodEndDate;
		BasicSalary = basicSalary;
		OvertimePay = overtimePay;
		Deductions = deductions;

	}
	// Getters and setters for all attributes
	/**
     * Retrieves the payroll ID.
     * 
     * @return The payroll ID.
     */
	public int getPayrollID() {
		return PayrollID;
	}
	/**
     * Sets the payroll ID.
     * 
     * @param payrollID The payroll ID to set.
     */
	public void setPayrollID(int payrollID) {
		PayrollID = payrollID;
	}
	 /**
     * Retrieves the employee ID.
     * 
     * @return The employee ID.
     */
	public int getEmployeeID() {
		return EmployeeID;
	}
	 /**
     * Sets the employee ID.
     * 
     * @param employeeID The employee ID to set.
     */
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	/**
     * Retrieves the start date of the pay period.
     * 
     * @return The start date of the pay period.
     */
	public Date getPayPeriodStartDate() {
		return PayPeriodStartDate;
	}
	/**
     * Sets the start date of the pay period.
     * 
     * @param payPeriodStartDate The start date of the pay period to set.
     */
	public void setPayPeriodStartDate(Date payPeriodStartDate) {
		PayPeriodStartDate = payPeriodStartDate;
	}
	 /**
     * Retrieves the end date of the pay period.
     * 
     * @return The end date of the pay period.
     */
	public Date getPayPeriodEndDate() {
		return PayPeriodEndDate;
	}
	 /**
     * Sets the end date of the pay period.
     * 
     * @param payPeriodEndDate The end date of the pay period to set.
     */
	public void setPayPeriodEndDate(Date payPeriodEndDate) {
		PayPeriodEndDate = payPeriodEndDate;
	}
	 /**
     * Retrieves the basic salary for the pay period.
     * 
     * @return The basic salary for the pay period.
     */
	public Double getBasicSalary() {
		return BasicSalary;
	}
	/**
     * Sets the basic salary for the pay period.
     * 
     * @param basicSalary The basic salary for the pay period to set.
     */
	public void setBasicSalary(Double basicSalary) {
		BasicSalary = basicSalary;
	}
	/**
     * Retrieves the overtime pay for the pay period.
     * 
     * @return The overtime pay for the pay period.
     */
	public Double getOvertimePay() {
		return OvertimePay;
	}
	/**
     * Sets the overtime pay for the pay period.
     * 
     * @param overtimePay The overtime pay for the pay period to set.
     */
	public void setOvertimePay(Double overtimePay) {
		OvertimePay = overtimePay;
	}
	 /**
     * Retrieves the deductions for the pay period.
     * 
     * @return The deductions for the pay period.
     */
	public Double getDeductions() {
		return Deductions;
	}
	/**
     * Sets the deductions for the pay period.
     * 
     * @param deductions The deductions for the pay period to set.
     */
	public void setDeductions(Double deductions) {
		Deductions = deductions;
	}
	 /**
     * Retrieves the net salary after deductions.
     * 
     * @return The net salary after deductions.
     */
	public Double getNetSalary() {
		return NetSalary;
	}
	/**
     * Sets the net salary after deductions.
     * 
     * @param netSalary The net salary after deductions to set.
     */
	public void setNetSalary(Double netSalary) {
		NetSalary = netSalary;
	}
	/**
     * Returns a string representation of the Payroll object.
     */
	public String toString() {
		return "Payroll {" + "payrollID=" + PayrollID + ", employeeID=" + EmployeeID + ", payPeriodStartDate="
				+ PayPeriodStartDate + ", payPeriodEndDate=" + PayPeriodEndDate + ", basicSalary=" + BasicSalary
				+ ", overtimePay=" + OvertimePay + ", deductions=" + Deductions + ", netSalary=" + NetSalary + " }";
	}
}
