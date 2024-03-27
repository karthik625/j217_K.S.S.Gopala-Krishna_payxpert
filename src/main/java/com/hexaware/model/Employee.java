package com.hexaware.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
/**
 * Represents an Employee in the system.
 */
public class Employee {
	private int EmployeeID;
	Date DateOfBirth, JoiningDate, TerminationDate;
	private String FirstName, LastName, Gender, Email, PhoneNumber, Address, Position;
	/**
     * Constructs an Employee object with specified attributes.
     * 
     * @param employeeID      The ID of the employee.
     * @param firstName       The first name of the employee.
     * @param lastName        The last name of the employee.
     * @param dateOfBirth     The date of birth of the employee.
     * @param gender          The gender of the employee.
     * @param email           The email address of the employee.
     * @param phoneNumber     The phone number of the employee.
     * @param address         The address of the employee.
     * @param position        The position or job title of the employee.
     * @param joiningDate     The date when the employee joined the company.
     * @param terminationDate The date when the employee left the company.
     */
	public Employee(int employeeID, String firstName, String lastName, Date dateOfBirth, String gender, String email,
			String phoneNumber, String address, String position, Date joiningDate, Date terminationDate) {

		EmployeeID = employeeID;
		FirstName = firstName;
		LastName = lastName;
		DateOfBirth = dateOfBirth;
		Gender = gender;
		Email = email;
		PhoneNumber = phoneNumber;
		Address = address;
		Position = position;
		JoiningDate = joiningDate;
		TerminationDate = terminationDate;
	}
	/**
     * Default constructor for Employee class.
     */
	public Employee() {
		super();
	}
	// Getters and setters for all attributes
	/**
     * Retrieves the employee's ID.
     * 
     * @return The ID of the employee.
     */
	public int getEmployeeID() {
		return EmployeeID;
	}
	/**
     * Sets the employee's ID.
     * 
     * @param employeeID The ID of the employee.
     */
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	/**
     * Retrieves the employee's date of birth.
     * 
     * @return The date of birth of the employee.
     */
	public Date getDateOfBirth() {
		return DateOfBirth;
	}
	/**
     * Sets the employee's date of birth.
     * 
     * @param dateOfBirth The date of birth of the employee.
     */
	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	/**
     * Retrieves the employee's joining date.
     * 
     * @return The joining date of the employee.
     */
	public Date getJoiningDate() {
		return JoiningDate;
	}
	 /**
     * Sets the employee's joining date.
     * 
     * @param joiningDate The joining date of the employee.
     */
	public void setJoiningDate(Date joiningDate) {
		JoiningDate = joiningDate;
	}
	/**
     * Retrieves the employee's termination date.
     * 
     * @return The termination date of the employee.
     */
	public Date getTerminationDate() {
		return TerminationDate;
	}
	 /**
     * Sets the employee's termination date.
     * 
     * @param terminationDate The termination date of the employee.
     */
	public void setTerminationDate(Date terminationDate) {
		TerminationDate = terminationDate;
	}
	 /**
     * Retrieves the employee's first name.
     * 
     * @return The first name of the employee.
     */
	public String getFirstName() {
		return FirstName;
	}
	/**
     * Sets the employee's first name.
     * 
     * @param firstName The first name of the employee.
     */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	/**
     * Retrieves the employee's last name.
     * 
     * @return The last name of the employee.
     */
	public String getLastName() {
		return LastName;
	}
	/**
     * Sets the employee's last name.
     * 
     * @param lastName The last name of the employee.
     */
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	/**
     * Retrieves the employee's gender.
     * 
     * @return The gender of the employee.
     */
	public String getGender() {
		return Gender;
	}
	 /**
     * Sets the employee's gender.
     * 
     * @param gender The gender of the employee.
     */
	public void setGender(String gender) {
		Gender = gender;
	}
	/**
     * Retrieves the employee's email.
     * 
     * @return The email address of the employee.
     */
	public String getEmail() {
		return Email;
	}
	 /**
     * Sets the employee's email.
     * 
     * @param email The email address of the employee.
     */
	public void setEmail(String email) {
		Email = email;
	}
	/**
     * Retrieves the employee's phone number.
     * 
     * @return The phone number of the employee.
     */
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	 /**
     * Sets the employee's phone number.
     * 
     * @param phoneNumber The phone number of the employee.
     */
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	/**
     * Retrieves the employee's address.
     * 
     * @return The address of the employee.
     */
	public String getAddress() {
		return Address;
	}
	 /**
     * Sets the employee's address.
     * 
     * @param address The address of the employee.
     */
	public void setAddress(String address) {
		Address = address;
	}
	/**
     * Retrieves the employee's position.
     * 
     * @return The position of the employee.
     */
	public String getPosition() {
		return Position;
	}
	/**
     * Sets the employee's position.
     * 
     * @param position The position of the employee.
     */
	public void setPosition(String position) {
		Position = position;
	}

	/**
     * Calculates the age of the employee based on the date of birth.
     * 
     * @param dobirth The date of birth of the employee in string format (yyyy-MM-dd).
     * @return The age of the employee.
     */
	public int CalculateAge(String dobirth) {
		LocalDate dob = LocalDate.parse(dobirth);
		LocalDate currentDate = LocalDate.now();
		int age = (Period.between(dob, currentDate)).getYears();
		return age;
	}
	/**
     * Returns a string representation of the Employee object.
     */
	@Override
	public String toString() {
		return "Employee{" + "employeeID=" + EmployeeID + ", firstName='" + FirstName + '\'' + ", lastName='" + LastName
				+ '\'' + ", dateOfBirth='" + DateOfBirth + '\'' + ", gender='" + Gender + '\'' + ", email='" + Email
				+ '\'' + ", phoneNumber='" + PhoneNumber + '\'' + ", address='" + Address + '\'' + ", position='"
				+ Position + '\'' + ", joiningDate='" + JoiningDate + '\'' + ", terminationDate='" + TerminationDate
				+ '\'' + '}';
	}
}
