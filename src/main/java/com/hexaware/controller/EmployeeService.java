package com.hexaware.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.hexaware.dao.EmployeeServiceDao;
import com.hexaware.model.Employee;

/**
 * Implementation of the IEmployeeService interface providing methods for
 * managing employees.
 */
public class EmployeeService implements IEmployeeService {
	private static Date parseDate(String dateString) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dateFormat.parse(dateString);
		} catch (ParseException e) {
			System.err.println("Error parsing date. Using current date instead.");
			return new Date();
		}
	}

	static Scanner scanner = new Scanner(System.in);
	static Employee employee = null;
	static ArrayList<Employee> empList = new ArrayList<>();

	/**
	 * Retrieves an employee by ID and displays the details.
	 */
	public void GetEmployeeById() {
		System.out.print("Enter Employee ID : ");
		int empId = scanner.nextInt();
		employee = new EmployeeServiceDao().GetEmployeeById(empId);
		System.out.println(employee);
		System.out.println("employee displayed Successfully");

	}
	/**
     * Retrieves all employees and displays their details.
     */
	public void GetAllEmployees() {
		System.out.println();
		System.out.println();
		empList = new EmployeeServiceDao().GetAllEmployees();
		for (Employee employee : empList) {
			System.out.println(employee);
		}
		System.out.println("all employees Displayed successfully");
	}
	/**
     * Adds a new employee.
     */
	public void AddEmployee() {
		// Implementation to add a new employee
		System.out.print("Enter Employee ID: ");
		int employeeID = scanner.nextInt();

		System.out.print("Enter First Name: ");
		String firstName = scanner.next();

		System.out.print("Enter Last Name: ");
		String lastName = scanner.next();

		System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
		Date dateOfBirth = parseDate(scanner.next());

		System.out.print("Enter Gender: ");
		String gender = scanner.next();

		System.out.print("Enter Email: ");
		String email = scanner.next();

		System.out.print("Enter Phone Number: ");
		String phoneNumber = scanner.next();

		System.out.print("Enter Address: ");
		String address = scanner.next();

		System.out.print("Enter Position: ");
		String position = scanner.nextLine();
		scanner.nextLine();

		System.out.print("Enter Joining Date (YYYY-MM-DD): ");
		String joiningDateString = scanner.next();
		Date joiningDate = parseDate(joiningDateString);

		System.out.print("Enter Termination Date (or type null) (YYYY-MM-DD): ");
		String terminationDateString = scanner.next();
		Date terminationDate = terminationDateString.equals("null") ? null : parseDate(terminationDateString);
		Employee employee = new Employee();
		employee.setEmployeeID(employeeID);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setDateOfBirth(dateOfBirth);
		employee.setGender(gender);
		employee.setEmail(email);
		employee.setPhoneNumber(phoneNumber);
		employee.setAddress(address);
		employee.setPosition(position);
		employee.setJoiningDate(joiningDate);
		employee.setTerminationDate(terminationDate);
		new EmployeeServiceDao().AddEmployee(employee);
	}
	/**
     * Updates an existing employee's details.
     */
	public void UpdateEmployee() {
		// Implementation to update an existing employee's details
		String ch1 = "";
		System.out.print("Enter Employee ID : ");
		int empId = scanner.nextInt();
		do {
			System.out.println("Enter which data to update");
			System.out.println("First Name : 1");
			System.out.println("Last Name : 2");
			System.out.println("Date of Birth : 3");
			System.out.println("Gender : 4");
			System.out.println("Email : 5");
			System.out.println("Phone Number : 6");
			System.out.println("Address : 7");
			System.out.println("Position : 8");
			System.out.println("Joinning Date : 9");
			System.out.println("Termination Date : 10");
			System.out.println("exit : 11");
			System.out.print("Enter choice : ");
			int ch = scanner.nextInt();
			scanner.nextLine();
			Employee obj = new EmployeeServiceDao().GetEmployeeById(empId);
			switch (ch) {
			case 1:
				System.out.print("Enter Frist Name : ");
				obj.setFirstName(scanner.nextLine());
				new EmployeeServiceDao().UpdateEmployee(obj);
				break;
			case 2:
				System.out.print("Enter Last Name : ");
				obj.setLastName(scanner.nextLine());
				new EmployeeServiceDao().UpdateEmployee(obj);
				break;
			case 3:
				System.out.print("Enter Date Of Birth : ");
				obj.setDateOfBirth(parseDate(scanner.nextLine()));
				new EmployeeServiceDao().UpdateEmployee(obj);
				break;
			case 4:
				System.out.print("Enter Gender : ");
				obj.setGender(scanner.next());
				new EmployeeServiceDao().UpdateEmployee(obj);
				break;
			case 5:
				System.out.print("Enter Email : ");
				obj.setEmail(scanner.next());
				new EmployeeServiceDao().UpdateEmployee(obj);
				break;
			case 6:
				System.out.print("Enter Phone Number : ");
				obj.setPhoneNumber(scanner.nextLine());
				new EmployeeServiceDao().UpdateEmployee(obj);
				break;
			case 7:
				System.out.print("Enter Address : ");
				obj.setAddress(scanner.nextLine());
				new EmployeeServiceDao().UpdateEmployee(obj);
				break;
			case 8:
				System.out.println("Enter Position : ");
				obj.setPosition(scanner.nextLine());
				new EmployeeServiceDao().UpdateEmployee(obj);
				break;
			case 9:
				System.out.println("Enter Joinning Date : ");
				obj.setJoiningDate(parseDate(scanner.nextLine()));
				new EmployeeServiceDao().UpdateEmployee(obj);
				break;
			case 10:
				System.out.println("Enter termination Date : ");
				// obj.setTerminationDate(parseDate(scanner.nextLine()));
				// new EmployeeServiceDao().UpdateEmployee(obj);
				String terminationDateString = scanner.next();
				Date terminationDate = terminationDateString.equals("null") ? null : parseDate(terminationDateString);
				obj.setTerminationDate(terminationDate);
				new EmployeeServiceDao().UpdateEmployee(obj);
				break;
			default:
				System.out.println("Exiting");
				break;
			}
			System.out.println(" Want to update same employee again (y/n)");
			ch1 = scanner.next().toLowerCase();
		} while (ch1.equals("y"));
	}

	 /**
     * Removes an employee.
     */
	public void RemoveEmployee() {
		// Implementation to remove an employee
		System.out.print("Enter Employee ID : ");
		int empId = scanner.nextInt();
		new EmployeeServiceDao().RemoveEmployee(empId);
		System.out.println(empId + "removed successfully");
	}
}
