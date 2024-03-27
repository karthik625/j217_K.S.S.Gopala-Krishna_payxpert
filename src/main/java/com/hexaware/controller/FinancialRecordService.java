package com.hexaware.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.hexaware.dao.FinancialRecordServiceDao;
import com.hexaware.model.FinancialRecord;

/**
 * Implementation of the IFinancialRecordService interface providing methods for managing financial records.
 */
public class FinancialRecordService implements IFinancialRecordService {
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<FinancialRecord> financialRecordsList = new ArrayList<>();

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
     * Adds a new financial record.
     */
	public void AddFinancialRecord() {
		// Taking user input for FinancialRecord attributes
		System.out.println();
		// Taking user input for FinancialRecord attributes
		System.out.print("Enter Record ID: ");
		int recordID = scanner.nextInt();

		System.out.print("Enter Employee ID: ");
		int employeeID = scanner.nextInt();

		System.out.print("Enter Record Date (YYYY-MM-DD): ");
		Date recordDate = parseDate(scanner.next());

		System.out.print("Enter Description: ");
		scanner.nextLine();
		String description = scanner.nextLine();

		System.out.print("Enter Amount: ");
		double amount = scanner.nextDouble();

		System.out.print("Enter Record Type: ");
		scanner.nextLine();
		String recordType = scanner.nextLine();

		new FinancialRecordServiceDao().AddFinancialRecord(employeeID, description, amount, recordType);
		System.out.println("successfull added");
	}
	 /**
     * Retrieves a financial record by its ID.
     */
	public void GetFinancialRecordById() {
		// Implementation to retrieve a financial record by ID
		System.out.println("Enter Record Id : ");
		int financialRecoedId = scanner.nextInt();
		FinancialRecord financialRecord = new FinancialRecordServiceDao().GetFinancialRecordById(financialRecoedId);
		System.out.println(financialRecord);
		System.out.println("financial record displayed successfully");
	}
	/**
     * Retrieves financial records for a specific employee.
     */
	public void GetFinancialRecordsForEmployee() {
		// Implementation to retrieve financial records for a specific employee
		System.out.println();
		System.out.println("Enter Employee ID : ");
		int empId = scanner.nextInt();
		financialRecordsList = new FinancialRecordServiceDao().GetFinancialRecordsForEmployee(empId);
		for (FinancialRecord financialRecord2 : financialRecordsList) {
			System.out.println(financialRecord2);
		}
		System.out.println("Financial records are displayed successfully");
	}
	/**
     * Retrieves financial records for a specific date.
     */
	public void GetFinancialRecordsForDate() {
		// Implementation to retrieve financial records for a specific date
		System.out.println("Enter Date (YYYY-MM-DD): ");
		Date date = parseDate(scanner.nextLine());
		financialRecordsList = new FinancialRecordServiceDao()
				.GetFinancialRecordsForDate(new java.sql.Date(date.getTime()));
		for (FinancialRecord financialRecord2 : financialRecordsList) {
			System.out.println(financialRecord2);
		}
	}
}
