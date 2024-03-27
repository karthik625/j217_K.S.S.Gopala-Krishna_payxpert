	package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hexaware.exception.PayrollGenerationException;
import com.hexaware.model.Payroll;
import com.hexaware.util.DatabaseContext;
/**
 * Data Access Object (DAO) class for managing payroll data in the database.
 */
public class PayrollServiceDao {
	private static Connection connection = DatabaseContext.getConnection();
	 /**
     * Generates a new payroll record and adds it to the database.
     * 
     * @param payroll The Payroll object representing the payroll record to be generated and added.
     */
	public void GeneratePayroll(Payroll payroll) {
		// Implementation to generate a new payroll record and add it to the database
		try {

			String q1 = "INSERT INTO Payroll (EmployeeId, PayPeriodStartDate, PayPeriodEndDate, "
					+ "BasicSalary, OvertimePay, Deductions) VALUES ( ?, ?, ?, ?, ?, ? )";
			PreparedStatement pstmt = connection.prepareStatement(q1);
			pstmt.setInt(1, payroll.getEmployeeID());
			pstmt.setDate(2, new java.sql.Date(payroll.getPayPeriodStartDate().getTime()));
			pstmt.setDate(3, new java.sql.Date(payroll.getPayPeriodEndDate().getTime()));
			pstmt.setDouble(4, payroll.getBasicSalary());
			pstmt.setDouble(5, payroll.getOvertimePay());
			pstmt.setDouble(6, payroll.getDeductions());

			int affectedRows = pstmt.executeUpdate();
			// check query successfully get executed or not
			if (affectedRows > 0) {
				System.out.println("Payroll added successfully.");
			} else {
				throw new PayrollGenerationException("Failed to Generate payroll.");
			}

		} catch (PayrollGenerationException pge) {
			pge.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
     * Retrieves a payroll record from the database by its ID.
     * 
     * @param payrollId The ID of the payroll record to retrieve.
     * @return A Payroll object representing the retrieved payroll record, or null if not found.
     */
	public Payroll GetPayrollById(int payrollId) {
		// Implementation to retrieve a payroll record from the database by its ID
		try {

			String q1 = "SELECT * FROM Payroll WHERE PayrollID = ?";
			PreparedStatement pstmt = connection.prepareStatement(q1);
			pstmt.setInt(1, payrollId);
			ResultSet resultSet = pstmt.executeQuery();
			if (!resultSet.next()) {
				System.out.println("Payroll Data is Empty");
				return null;
			} else {
				// extract data in local variables
				int payrollID1 = resultSet.getInt("PayrollID");
				int employeeID = resultSet.getInt("EmployeeID");
				Date payPeriodStartDate = resultSet.getDate("PayPeriodStartDate");
				Date payPeriodEndDate = resultSet.getDate("PayPeriodEndDate");
				double basicSalary = resultSet.getDouble("BasicSalary");
				double overtimePay = resultSet.getDouble("OvertimePay");
				double deductions = resultSet.getDouble("Deductions");
				double netSalary = resultSet.getDouble("NetSalary");
				Payroll payroll = new Payroll(payrollID1, employeeID, payPeriodStartDate, payPeriodEndDate, basicSalary,
						overtimePay, deductions, netSalary);
				return payroll;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return null;
	}
	/**
     * Retrieves all payroll records for a specific employee from the database.
     * 
     * @param employeeId The ID of the employee whose payroll records are to be retrieved.
     * @return An ArrayList of Payroll objects representing the payroll records for the specified employee, or null if not found.
     */
	public ArrayList<Payroll> GetPayrollsForEmployee(int employeeId) {
		// Implementation to retrieve all payroll records for a specific employee from the database
		try {

			String q1 = "SELECT * FROM Payroll WHERE EmployeeID = ?";
			PreparedStatement pstmt = connection.prepareStatement(q1);
			pstmt.setInt(1, employeeId);
			ResultSet resultSet = pstmt.executeQuery();

			ArrayList<Payroll> empPayrolllist = new ArrayList<>();
			while (resultSet.next()) {
				int payrollID1 = resultSet.getInt("PayrollID");
				int employeeID = resultSet.getInt("EmployeeID");
				Date payPeriodStartDate = resultSet.getDate("PayPeriodStartDate");
				Date payPeriodEndDate = resultSet.getDate("PayPeriodEndDate");
				double basicSalary = resultSet.getDouble("BasicSalary");
				double overtimePay = resultSet.getDouble("OvertimePay");
				double deductions = resultSet.getDouble("Deductions");
				double netSalary = resultSet.getDouble("NetSalary");
				Payroll payroll = new Payroll(payrollID1, employeeID, payPeriodStartDate, payPeriodEndDate, basicSalary,
						overtimePay, deductions, netSalary);
				empPayrolllist.add(payroll);
			}
			if (empPayrolllist.isEmpty()) {
				System.out.println("Payroll Data is Empty for employee id : " + employeeId);
				return null;
			}
			return empPayrolllist;

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}
	 /**
     * Retrieves all payroll records for a specific period from the database.
     * 
     * @param startDate The start date of the period for which payroll records are to be retrieved.
     * @param endDate   The end date of the period for which payroll records are to be retrieved.
     * @return An ArrayList of Payroll objects representing the payroll records for the specified period, or null if not found.
     */
	public ArrayList<Payroll> GetPayrollsForPeriod(Date startDate, Date endDate) {
		// Implementation to retrieve all payroll records for a specific period from the database
		try {

			String q1 = "SELECT * FROM Payroll WHERE PayPeriodStartDate BETWEEN ? AND ?";
			PreparedStatement pstmt = connection.prepareStatement(q1);
			pstmt.setDate(1, new java.sql.Date(startDate.getTime()));
			pstmt.setDate(2, new java.sql.Date(endDate.getTime()));
			ResultSet resultSet = pstmt.executeQuery();

			ArrayList<Payroll> empPayrolllist = new ArrayList<>();
			while (resultSet.next()) {
				int payrollID1 = resultSet.getInt("PayrollID");
				int employeeID = resultSet.getInt("EmployeeID");
				Date payPeriodStartDate = resultSet.getDate("PayPeriodStartDate");
				Date payPeriodEndDate = resultSet.getDate("PayPeriodEndDate");
				double basicSalary = resultSet.getDouble("BasicSalary");
				double overtimePay = resultSet.getDouble("OvertimePay");
				double deductions = resultSet.getDouble("Deductions");
				double netSalary = resultSet.getDouble("NetSalary");
				Payroll payroll = new Payroll(payrollID1, employeeID, payPeriodStartDate, payPeriodEndDate, basicSalary,
						overtimePay, deductions, netSalary);
				empPayrolllist.add(payroll);
			}
			if (empPayrolllist.isEmpty()) {
				System.out.println("Payroll Data not found ");
				return null;
			}
			return empPayrolllist;

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;

	}

}
