package com.hexaware.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hexaware.exception.EmployeeNotFoundException;
import com.hexaware.model.Employee;
import com.hexaware.util.DatabaseContext;
/**
 * Data Access Object (DAO) class for managing employee data in the database.
 */
public class EmployeeServiceDao {
	private static Connection connection = DatabaseContext.getConnection();
	/**
     * Retrieves an employee from the database by their ID.
     * 
     * @param employeeId The ID of the employee to retrieve.
     * @return An Employee object representing the retrieved employee, or null if the employee is not found.
     */	
	public Employee GetEmployeeById(int employeeId) {

		try {
			String q1 = "SELECT * FROM employee WHERE EmployeeID = ?";
			PreparedStatement pstmt1 = connection.prepareStatement(q1);
			pstmt1.setInt(1, employeeId);
			ResultSet rs1 = pstmt1.executeQuery();
			// check Employee is present or not of given id
			if (rs1.next()) {
				// Employee is found in the database
                // Retrieve employee details from the result set
                // Create and return an Employee object
				int eID = rs1.getInt("EmployeeId");
				String fristName = rs1.getString("First_name");
				String lastName = rs1.getString("Last_name");
				Date dateOfBirth = (Date) rs1.getDate("DateOfBirth");
				String gender = rs1.getString("Gender");
				String email = rs1.getString("Email");
				String phoneNumber = rs1.getString("PhoneNumber");
				String address = rs1.getString("Address");
				String position = rs1.getString("Position");
				Date joiningDate = (Date) rs1.getDate("JoiningDate");
				Date terminationDate = (Date) rs1.getDate("TerminationDate");
				Employee employee = new Employee(eID, fristName, lastName, dateOfBirth, gender, email, phoneNumber,
						address, position, joiningDate, terminationDate);

				// Close the PreparedStatement
				pstmt1.close();
				// return employee
				return employee;
			} else {
				// employee is not present in database so we are throwing Exception
				throw new EmployeeNotFoundException("Employee not Find of id : " + employeeId);
			}

		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return null;
	}
	/**
     * Retrieves all employees from the database.
     * 
     * @return An ArrayList of Employee objects representing all employees in the database, or null if no employees are found.
     */
	public ArrayList<Employee> GetAllEmployees() {
		// Implementation to retrieve all employees from the database	
		try {
			String q1 = "SELECT * FROM employee";
			PreparedStatement pstmt1 = connection.prepareStatement(q1);
			ResultSet rs1 = pstmt1.executeQuery();
			// check employess data present in database or not

			// Employee type arrayList to store employee data
			ArrayList<Employee> employeeList = new ArrayList<>();
			while (rs1.next()) {
				int eID = rs1.getInt("EmployeeID");
				String fristName = rs1.getString("First_name");
				String lastName = rs1.getString("Last_name");
				Date dateOfBirth = (Date) rs1.getDate("DateOfBirth");
				String gender = rs1.getString("Gender");
				String email = rs1.getString("Gender");
				String phoneNumber = rs1.getString("PhoneNumber");
				String address = rs1.getString("Address");
				String position = rs1.getString("Position");
				Date joiningDate = (Date) rs1.getDate("JoiningDate");
				Date terminationDate = (Date) rs1.getDate("TerminationDate");
				Employee employee = new Employee(eID, fristName, lastName, dateOfBirth, gender, email, phoneNumber,
						address, position, joiningDate, terminationDate);

				employeeList.add(employee);
			}
			if (employeeList.isEmpty()) {
				throw new EmployeeNotFoundException("There is no Employee data in record");
			}
			return employeeList;
		} catch (EmployeeNotFoundException enf) {
			enf.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	 /**
     * Adds a new employee to the database.
     * 
     * @param employeeData The Employee object representing the employee to be added.
     */
	public void AddEmployee(Employee employeeData) {
		// Implementation to add a new employee to the database
		try {
			String q1 = "INSERT INTO employee (EmployeeId, First_name, Last_name, DateOfBirth, Gender, "
					+ "Email, PhoneNumber, Address, Position, JoiningDate, TerminationDate) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = connection.prepareStatement(q1);
			// Set the parameter values using the employeeData
			pstmt.setInt(1, employeeData.getEmployeeID());
			pstmt.setString(2, employeeData.getFirstName());
			pstmt.setString(3, employeeData.getLastName());
			pstmt.setDate(4, new java.sql.Date(employeeData.getDateOfBirth().getTime()));
			pstmt.setString(5, employeeData.getGender());
			pstmt.setString(6, employeeData.getEmail());
			pstmt.setString(7, employeeData.getPhoneNumber());
			pstmt.setString(8, employeeData.getAddress());
			pstmt.setString(9, employeeData.getPosition());
			pstmt.setDate(10, new java.sql.Date(employeeData.getJoiningDate().getTime()));
			if (employeeData.getTerminationDate() != null) {
				pstmt.setDate(11, new java.sql.Date(employeeData.getTerminationDate().getTime()));
			} else {
				pstmt.setDate(11, null);
			}

			int affectedRows = pstmt.executeUpdate();
			// check weather employee added or not
			if (affectedRows > 0) {
				System.out.println("Employee added successfully.");
			} else {
				System.out.println("Failed to add employee.");
			}

			// Close the PreparedStatement
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/**
     * Updates an existing employee in the database.
     * 
     * @param employeeData The Employee object representing the updated employee data.
     * @return The updated Employee object if the update is successful, otherwise null.
     */
	public Employee UpdateEmployee(Employee employeeData) {
		// Implementation to update an existing employee in the database
		try {

			String q1 = "SELECT * FROM employee WHERE EmployeeId = ?";
			PreparedStatement pstmt1 = connection.prepareStatement(q1);
			pstmt1.setInt(1, employeeData.getEmployeeID());
			ResultSet rs1 = pstmt1.executeQuery();
			// check employee is present in the database or not
			if (!rs1.next()) {
				throw new EmployeeNotFoundException(
						"Employee not Find of id : " + employeeData.getEmployeeID() + " to update");
			} else {

				String updateQuery = "UPDATE employee SET First_name=?, Last_name=?, DateOfBirth=?, "
						+ "Gender=?, Email=?, PhoneNumber=?, Address=?, Position=?, "
						+ "JoiningDate=?, TerminationDate=? WHERE EmployeeID=?";

				// Prepare the statement with the query
				PreparedStatement pstmt = connection.prepareStatement(updateQuery);

				// Set the parameter values using the employeeData object
				pstmt.setString(1, employeeData.getFirstName());
				pstmt.setString(2, employeeData.getLastName());
				pstmt.setDate(3, (Date) employeeData.getDateOfBirth());
				pstmt.setString(4, employeeData.getGender());
				pstmt.setString(5, employeeData.getEmail());
				pstmt.setString(6, employeeData.getPhoneNumber());
				pstmt.setString(7, employeeData.getAddress());
				pstmt.setString(8, employeeData.getPosition());
				pstmt.setDate(9, (Date) employeeData.getJoiningDate());
				if (employeeData.getTerminationDate() != null) {
					pstmt.setDate(10, new java.sql.Date(employeeData.getTerminationDate().getTime()));
				} else {
					pstmt.setDate(10, null);
				}
				pstmt.setInt(11, employeeData.getEmployeeID());

				// Execute the query
				int rowsAffected = pstmt.executeUpdate();
				pstmt.close();
				pstmt1.close();
				if (rowsAffected > 0) {
					System.out.println("Employee updated successfully.");
					return employeeData; // Return the updated employee
				} else {
					System.out.println("Failed to update employee.");
					return null;
				}
			}

		} catch (EmployeeNotFoundException enf) {
			enf.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
     * Removes an employee from the database by their ID.
     * 
     * @param employeeId The ID of the employee to be removed.
     */
	public void RemoveEmployee(int employeeId) {
		// Implementation to remove an employee from the database
		try {

			String q1 = "SELECT * FROM employee WHERE EmployeeID = ?";
			PreparedStatement pstmt1 = connection.prepareStatement(q1);
			pstmt1.setInt(1, employeeId);
			ResultSet rs1 = pstmt1.executeQuery();
			// check employee is present in the database or not
			if (!rs1.next()) {
				throw new EmployeeNotFoundException("Employee not Find of id : " + employeeId + " to remove");
			}
			// Query to delete employee from employee table
			String deleteQuery = "DELETE FROM employee WHERE EmployeeID = ?";
			PreparedStatement pstmt = connection.prepareStatement(deleteQuery);
			pstmt.setInt(1, employeeId);
			int rowsAffected = pstmt.executeUpdate();

			// check operation performed successfully or not
			if (rowsAffected > 0) {
				System.out.println("Employee removed successfully.");
			} else {
				System.out.println("Failed to remove employee. Employee ID not found.");
			}

		} catch (EmployeeNotFoundException enf) {
			enf.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
