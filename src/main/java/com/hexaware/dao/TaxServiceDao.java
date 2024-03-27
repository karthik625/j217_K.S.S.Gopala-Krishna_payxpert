package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;

import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.exception.TaxCalculationException;
import com.hexaware.model.Tax;
import com.hexaware.util.DatabaseContext;
/**
 * Data Access Object (DAO) class for managing tax-related data in the database.
 */
public class TaxServiceDao {
	static Connection connection = DatabaseContext.getConnection();
	/**
     * Calculates and records the tax for a specified employee and tax year.
     * 
     * @param employeeId The ID of the employee for whom tax is to be calculated and recorded.
     * @param taxYear    The tax year for which tax is to be calculated and recorded.
     * @return The taxable income for the specified employee and tax year.
     */
	public double CalculateTax(int employeeId, Year taxYear) {
		// Implementation to calculate and record tax for a specified employee and tax year
		try {
			String q1 = "SELECT 1 FROM Employee WHERE EmployeeID = ?";
			PreparedStatement pstmt1 = connection.prepareStatement(q1);
			pstmt1.setInt(1, employeeId);
			ResultSet rs1 = pstmt1.executeQuery();
			if (!rs1.next()) { // check for employee
				throw (new EmployeeNotFoundException("No employee with id:" + employeeId + " exists"));
			}

			double taxableIncome = 0;
			String q2 = "SELECT SUM(NetSalary)  FROM payroll WHERE EmployeeID = ? AND YEAR(PayPeriodEndDate) = ?";
			PreparedStatement pstmt2 = connection.prepareStatement(q2);
			pstmt2.setInt(1, employeeId);
			pstmt2.setInt(2, taxYear.getValue());
			ResultSet rs2 = pstmt2.executeQuery();
			if (rs2.next()) {// if found for that year

				taxableIncome = rs2.getDouble(1);

				String q3 = "INSERT INTO Tax ( EmployeeID, TaxYear, TaxableIncome, TaxAmount) VALUES (?, ?, ?, ?)";
				PreparedStatement pstmt3 = connection.prepareStatement(q3);

				pstmt3.setInt(1, employeeId);
				pstmt3.setInt(2, taxYear.getValue());
				pstmt3.setDouble(3, taxableIncome);
				Double taxamount = taxableIncome * 0.2;
				pstmt3.setDouble(4, taxamount);

				int affectedRows = pstmt3.executeUpdate();
				if (affectedRows > 0) {
					System.out.println("Tax record added successfully.");
				} else {
					throw new SQLException("Failed to insert tax record.");
				}

				return taxableIncome;
			} else {//
				throw (new TaxCalculationException(
						"No record found to calculate tax for eid:" + employeeId + " for taxyear" + taxYear));
			}
		} catch (EmployeeNotFoundException enfe) {
			enfe.printStackTrace();
		} catch (TaxCalculationException tce) {
			tce.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return 0;
	}
	/**
     * Retrieves a tax record from the database by its ID.
     * 
     * @param taxId The ID of the tax record to retrieve.
     * @return A Tax object representing the retrieved tax record, or null if not found.
     */
	public Tax GetTaxById(int taxId) {
		 // Implementation to retrieve a tax record from the database by its ID
		try {
			String q1 = "SELECT * FROM Tax WHERE TaxID = ?";
			PreparedStatement pstmt1 = connection.prepareStatement(q1);
			pstmt1.setInt(1, taxId);
			ResultSet rs1 = pstmt1.executeQuery();
			if (rs1.next()) {
				int taxid = rs1.getInt("TaxID");
				int empid = rs1.getInt("EmployeeID");
				Year year = Year.of(rs1.getInt("TaxYear"));
				double taxableincome = rs1.getDouble("TaxableIncome");
				double taxamount = rs1.getDouble("TaxAmount");
				Tax tx = new Tax(taxid, empid, year, taxableincome, taxamount);
				return tx;
			} else {
				throw (new TaxCalculationException("No record found for taxid:" + taxId));
			}
		} catch (TaxCalculationException tce) {
			tce.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
     * Retrieves all tax records for a specific employee from the database.
     * 
     * @param employeeId The ID of the employee whose tax records are to be retrieved.
     * @return An ArrayList of Tax objects representing the tax records for the specified employee, or null if not found.
     */
	public ArrayList<Tax> GetTaxesForEmployee(int employeeId) {
		// Implementation to retrieve all tax records for a specific employee from the database
		try {
			String q1 = "SELECT 1 FROM Employee WHERE EmployeeID = ?";
			PreparedStatement pstmt1 = connection.prepareStatement(q1);
			pstmt1.setInt(1, employeeId);
			ResultSet rs1 = pstmt1.executeQuery();
			if (!rs1.next()) { // check for employee
				throw (new EmployeeNotFoundException("No employee with id:" + employeeId + " exists"));
			}

			ArrayList<Tax> taxsofeid = new ArrayList<Tax>();

			String q2 = "SELECT * FROM Tax WHERE employeeId = ?";
			PreparedStatement pstmt2 = connection.prepareStatement(q2);
			pstmt2.setInt(1, employeeId);
			ResultSet rs2 = pstmt2.executeQuery();
			while (rs2.next()) {
				int taxid = rs2.getInt("TaxID");
				int empid = rs2.getInt("EmployeeID");
				Year year = Year.of(rs2.getInt("TaxYear"));
				double taxableincome = rs2.getDouble("TaxableIncome");
				double taxamount = rs2.getDouble("TaxAmount");
				Tax tx = new Tax(taxid, empid, year, taxableincome, taxamount);
				taxsofeid.add(tx);
			}
			if (taxsofeid.isEmpty()) {
				throw (new TaxCalculationException("No record found for employeeId:" + employeeId));
			}
			return taxsofeid;
		} catch (EmployeeNotFoundException enfe) {
			enfe.printStackTrace();
		} catch (TaxCalculationException tce) {
			tce.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
     * Retrieves all tax records for a specific tax year from the database.
     * 
     * @param taxYear The tax year for which tax records are to be retrieved.
     * @return An ArrayList of Tax objects representing the tax records for the specified tax year, or null if not found.
     */
	public ArrayList<Tax> GetTaxesForYear(Year taxYear) {
		// Implementation to retrieve all tax records for a specific tax year from the database
		try {
			String q1 = "SELECT * FROM Tax WHERE TaxYear = ?";
			PreparedStatement pstmt1 = connection.prepareStatement(q1);
			pstmt1.setInt(1, taxYear.getValue());
			ResultSet rs1 = pstmt1.executeQuery();
			ArrayList<Tax> taxesforty = new ArrayList<Tax>();
			while (rs1.next()) {
				int taxid = rs1.getInt("TaxID");
				int empid = rs1.getInt("EmployeeID");
				Year year = Year.of(rs1.getInt("TaxYear"));
				double taxableincome = rs1.getDouble("TaxableIncome");
				double taxamount = rs1.getDouble("TaxAmount");
				Tax tx = new Tax(taxid, empid, year, taxableincome, taxamount);
				taxesforty.add(tx);
			}
			if (taxesforty.isEmpty()) {
				throw (new TaxCalculationException("No record found for taxyear:" + taxYear));
			}
			return taxesforty;
		} catch (TaxCalculationException tce) {
			tce.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
