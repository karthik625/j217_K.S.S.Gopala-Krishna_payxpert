package com.hexaware.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.hexaware.dao.PayrollServiceDao;
import com.hexaware.model.Payroll;

/**
 * Implementation of the IPayrollService interface providing methods for managing payroll.
 */
public class PayrollService implements IPayrollService {
	static ArrayList<Payroll> payrollList = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);

	private static Date parseDate(String dateString) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			System.err.println("Error parsing date. Using current date instead.");
			return new Date();
		}
	}
	/**
     * Generates payroll for an employee.
     */
	public void GeneratePayroll() {
		// Implementation to generate payroll for an employee
		System.out.print("Enter Employee ID: ");
		int employeeID = scanner.nextInt();

		System.out.print("Enter Pay Period Start Date (YYYY-MM-DD): ");
		Date payPeriodStartDate = parseDate(scanner.next());

		System.out.print("Enter Pay Period End Date (YYYY-MM-DD): ");
		Date payPeriodEndDate = parseDate(scanner.next());

		System.out.print("Enter Basic Salary: ");
		double basicSalary = scanner.nextDouble();

		System.out.print("Enter Overtime Pay: ");
		double overtimePay = scanner.nextDouble();

		System.out.print("Enter Deductions: ");
		double deductions = scanner.nextDouble();

		// Creating a Payroll object with user input
		Payroll payroll = new Payroll(employeeID, payPeriodStartDate, payPeriodEndDate, basicSalary, overtimePay,
				deductions);
		new PayrollServiceDao().GeneratePayroll(payroll);
	}
	/**
     * Retrieves a payroll by ID.
     */
	public void GetPayrollById() {
		// Implementation to retrieve a payroll by ID
		System.out.println();
		System.out.print("Enter Payroll Id : ");
		int payrollId = scanner.nextInt();
		Payroll payroll2 = new PayrollServiceDao().GetPayrollById(payrollId);
		System.out.println(payroll2);
	}
	/**
     * Retrieves payrolls for a specific employee.
     */

	public void GetPayrollsForEmployee() {
		// Implementation to retrieve payrolls for a specific employee
		System.out.println();
		System.out.print("Enter Employee Id : ");
		int empId = scanner.nextInt();
		payrollList = new PayrollServiceDao().GetPayrollsForEmployee(empId);
		for (Payroll payroll2 : payrollList) {
			System.out.println(payroll2);
		}
		System.out.println("payrolls are displayed successfully for employee" + empId);
	}
	 /**
     * Retrieves payrolls for a specific period.
     */
	public void GetPayrollsForPeriod() {
		// Implementation to retrieve payrolls for a specific period
		System.out.println();
		System.out.print("Enter the Start Date : ");
		Date startDate = parseDate(scanner.nextLine());
		System.out.print("Enter the End Date : ");
		Date endDate = parseDate(scanner.nextLine());
		payrollList = new PayrollServiceDao().GetPayrollsForPeriod(new java.sql.Date(startDate.getTime()),
				new java.sql.Date(endDate.getTime()));
		for (Payroll payroll3 : payrollList) {
			System.out.println(payroll3);
		}
		System.out.println("payrolls displayed successfully");
	}
}