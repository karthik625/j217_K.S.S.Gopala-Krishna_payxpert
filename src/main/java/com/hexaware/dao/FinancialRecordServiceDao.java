package com.hexaware.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.exception.FinancialRecordException;
import com.hexaware.model.FinancialRecord;
import com.hexaware.util.DatabaseContext;
/**
 * Data Access Object (DAO) class for managing financial record data in the database.
 */
public class FinancialRecordServiceDao {
	private static Connection connection = DatabaseContext.getConnection();
	/**
     * Adds a new financial record to the database.
     * 
     * @param employeeId   The ID of the employee associated with the financial record.
     * @param description  The description of the financial record.
     * @param amount       The amount of the financial record.
     * @param recordType   The type of the financial record.
     */
	public void AddFinancialRecord(int employeeId, String description, double amount, String recordType) {
		// Implementation to add a new financial record to the database
		try {
			String q1 = "SELECT 1 FROM Employee WHERE EmployeeID = ?";
			PreparedStatement pstmt1 = connection.prepareStatement(q1);
			pstmt1.setInt(1, employeeId);
			ResultSet rs1 = pstmt1.executeQuery();
			if (rs1.next()) { // check for employee
				// if employee present then
				String q2 = "INSERT INTO FinancialRecord (EmployeeID, RecordDate, Description, Amount, RecordType) "
						+ "VALUES (?, CURRENT_DATE, ?, ?, ?)";
				PreparedStatement pstmt2 = connection.prepareStatement(q2);
				pstmt2.setInt(1, employeeId);
				pstmt2.setString(2, description);
				pstmt2.setDouble(3, amount);
				pstmt2.setString(4, recordType);
				pstmt2.executeUpdate();
			} else {// if employee not present
				throw (new EmployeeNotFoundException("No employee with id:" + employeeId + " exists"));
			}
		} catch (EmployeeNotFoundException enfe) {
			enfe.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
	/**
     * Retrieves a financial record from the database by its ID.
     * 
     * @param recordId The ID of the financial record to retrieve.
     * @return A FinancialRecord object representing the retrieved financial record, or null if not found.
     */
	public FinancialRecord GetFinancialRecordById(int recordId) {
		// Implementation to retrieve a financial record from the database by its ID
		try {
			String q1 = "SELECT * FROM FinancialRecord WHERE RecordID = ?";
			PreparedStatement pstmt1 = connection.prepareStatement(q1);
			pstmt1.setInt(1, recordId);
			ResultSet rs1 = pstmt1.executeQuery();
			if (rs1.next()) {// check if recordId present or not
				// if present
				int recordid = rs1.getInt("RecordID");
				int employeeid = rs1.getInt("EmployeeID");
				Date recordDate = rs1.getDate("RecordDate");
				String description = rs1.getString("Description");
				Double amount = rs1.getDouble("Amount");
				String recordtype = rs1.getString("RecordType");
				FinancialRecord fr = new FinancialRecord(recordid, employeeid, recordDate, description, recordtype,
						amount);
				return fr;
			} else {// if not present
				throw (new FinancialRecordException("No such record with record id " + recordId + " found"));
			}
		} catch (FinancialRecordException fre) {
			fre.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
     * Retrieves all financial records for a specific employee from the database.
     * 
     * @param employeeId The ID of the employee whose financial records are to be retrieved.
     * @return An ArrayList of FinancialRecord objects representing the financial records for the specified employee, or null if not found.
     */
	public ArrayList<FinancialRecord> GetFinancialRecordsForEmployee(int employeeId) {
		// Implementation to retrieve all financial records for a specific employee from the database
		try {
			// check if employee present in employee table
			String q1 = "SELECT 1 FROM Employee WHERE EmployeeID = ?";
			PreparedStatement pstmt1 = connection.prepareStatement(q1);
			pstmt1.setInt(1, employeeId);
			ResultSet rs1 = pstmt1.executeQuery();
			if (!rs1.next()) { // check for employee
				throw (new EmployeeNotFoundException("employee with empid: " + employeeId + " doesnot exist"));
			}

			// if present
			ArrayList<FinancialRecord> financialRecords = new ArrayList<FinancialRecord>();
			String q2 = "SELECT * FROM financialrecord WHERE EmployeeID = ?";
			PreparedStatement pstmt2 = connection.prepareStatement(q2);
			pstmt2.setInt(1, employeeId);
			ResultSet rs2 = pstmt2.executeQuery();
			while (rs2.next()) {
				int recordid = rs2.getInt("RecordID");
				int employeeid = rs2.getInt("EmployeeID");
				Date recordDate = rs2.getDate("RecordDate");
				String description = rs2.getString("Description");
				Double amount = rs2.getDouble("Amount");
				String recordtype = rs2.getString("RecordType");
				FinancialRecord fr = new FinancialRecord(recordid, employeeid, recordDate, description, recordtype,
						amount);
				financialRecords.add(fr);
			}
			if (financialRecords.isEmpty()) {
				throw (new FinancialRecordException("No record found for employeeId: " + employeeId));
			}
			return financialRecords;
		} catch (EmployeeNotFoundException enfe) {
			enfe.printStackTrace();
		} catch (FinancialRecordException fre) {
			fre.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
     * Retrieves all financial records for a specific date from the database.
     * 
     * @param recordDate The date for which financial records are to be retrieved.
     * @return An ArrayList of FinancialRecord objects representing the financial records for the specified date, or null if not found.
     */
	public ArrayList<FinancialRecord> GetFinancialRecordsForDate(Date recordDate) {
		ArrayList<FinancialRecord> financialRecords = new ArrayList<>();
		 // Implementation to retrieve all financial records for a specific date from the database
		try {
			String q1 = "SELECT * FROM FinancialRecord WHERE RecordDate = ?";
			PreparedStatement pstmt1 = connection.prepareStatement(q1);
			java.sql.Date sqlRecordDate = new java.sql.Date(recordDate.getTime());
			pstmt1.setDate(1, sqlRecordDate);
			ResultSet rs1 = pstmt1.executeQuery();
			while (rs1.next()) {
				int recordid = rs1.getInt("RecordID");
				int employeeid = rs1.getInt("EmployeeID");
				Date recorddate = rs1.getDate("RecordDate");
				String description = rs1.getString("Description");
				Double amount = rs1.getDouble("Amount");
				String recordtype = rs1.getString("RecordType");
				FinancialRecord fr = new FinancialRecord(recordid, employeeid, recorddate, description, recordtype,
						amount);
				financialRecords.add(fr);
			}
			if (financialRecords.isEmpty()) {
				throw (new FinancialRecordException(
						"Financial Records on RecordDate: " + recordDate + " does not exist"));
			}
			return financialRecords;
		} catch (FinancialRecordException enfe) {
			enfe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
