package com.hexaware.controller;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.hexaware.dao.TaxServiceDao;
import com.hexaware.model.Tax;
/**
 * Class to manage tax-related operations.
 */
public class TaxService implements ITaxService{
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Tax> taxList = new ArrayList<>();
	 /**
     * Calculates tax for an employee.
     */
	public void CalculateTax() {
		System.out.print("Enter employee ID : ");
		int empId = scanner.nextInt();
		System.out.println("Enter Year : ");
		// Date year = parseDate(scanner.next());
		int Year1 = scanner.nextInt();
		Year year = Year.of(Year1);
		Double calculatedTax = new TaxServiceDao().CalculateTax(empId, year);
		System.out.println("Tax : " + calculatedTax);

	}
	/**
     * Retrieves a tax record by ID.
     */
	public void GetTaxById() {
		System.out.println("enter taxId");
		int taxId = scanner.nextInt();
		Tax tax = new TaxServiceDao().GetTaxById(taxId);
		System.out.println(tax);
		System.out.println("Tax record dispayed successfully");
	}
	 /**
     * Retrieves tax records for a specific employee.
     */
	public void GetTaxesForEmployee() {

		System.out.print("Enter employee id : ");
		int empId = scanner.nextInt();
		taxList = new TaxServiceDao().GetTaxesForEmployee(empId);
		for (Tax tax2 : taxList) {
			System.out.println(tax2);
		}
		System.out.println("tax report for the employee" + " " + empId + " " + "generated succesfully");
	}
	/**
     * Retrieves tax records for a specific year.
     */
	public void GetTaxesForYear() {
		System.out.print("Enter year : ");
		int Year2 = scanner.nextInt();
		Year year1 = Year.of(Year2);
		taxList = new TaxServiceDao().GetTaxesForYear(year1);
		for (Tax tax3 : taxList) {
			System.out.println(tax3);
		}
		System.out.println("tax report generated succesfully");
	}
}
