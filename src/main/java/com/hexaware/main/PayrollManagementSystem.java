package com.hexaware.main;
import java.text.ParseException;
import java.util.Scanner;
import com.hexaware.controller.*;
import com.hexaware.controller.EmployeeService;
/**
 * Main class for the Payroll Management System application.
 * @author karthik
 */
public class PayrollManagementSystem {
    static EmployeeService employeeservice=new EmployeeService();
    static PayrollService payrollservice=new PayrollService();
    static FinancialRecordService financialrecord=new FinancialRecordService();
    static TaxService taxservice=new TaxService();
    /**
     * Main method for starting the application.
     * 
     * @param args Arguments passed to the application.
     * @throws ParseException If there's an error parsing input.
     */
    public static void main(String[] args) throws ParseException {
		// Code for user interaction
	    Scanner scanner =new Scanner(System.in);
	    System.out.println();
	    String ch = null;
	    do {
	    //Display the menu options.
	    System.out.println(" -------- PayXpert, The Payroll Management System --------");
	    System.out.println(" Employee : 1");
	    System.out.println(" Payroll : 2");
	    System.out.println(" Employee FinancialRecord : 3");
	    System.out.println(" Tax : 4");
	    // Prompt user for input
	    System.out.print("Select option : ");
	    // Read user input
	    int option=scanner.nextInt();
	    // Process user input
	    switch(option) {
	    // Handle different options
	    case 1:{
	    	System.out.println();
			System.out.println("--- Employee ---");
			System.out.println("Get Employee By Id : 1");
			System.out.println("Get All Employees : 2");
			System.out.println("Add Employee : 3");
			System.out.println("Update Employee : 4");
			System.out.println("Remove Employee : 5");
			System.out.println(" Back : 6");
			System.out.print("Select option : ");
			int option2=scanner.nextInt();
			switch(option2){
			case 1:
				employeeservice.GetEmployeeById();
				break;
			case 2:
			    employeeservice.GetAllEmployees();
			    break;
			case 3:
                employeeservice.AddEmployee();
                break;
			case 4:
				employeeservice.UpdateEmployee();
				break;
			case 5:
				employeeservice.RemoveEmployee();
				break;
			case 6:
				break;
			default:
				System.out.println("Wrong choice try again");
				break;
			}
	    }
	    break;
	    case 2:{
	    	System.out.println();
			System.out.println("--- Payroll ---");
			System.out.println(" Generate Payroll : 1");
			System.out.println(" Get Payroll By Id : 2");
			System.out.println(" Get Payrolls For Employee : 3");
			System.out.println(" Get Payrolls For Period : 4");
			System.out.println(" Back : 5");
			System.out.print("Select option :");
			int option2=scanner.nextInt();
			switch(option2) {
			case 1:
				payrollservice.GeneratePayroll();
				break;
			case 2:
				payrollservice.GetPayrollById();
				break;
			case 3:
				payrollservice.GetPayrollsForEmployee();
				break;
			case 4:
				payrollservice.GetPayrollsForPeriod();
				break;
			case 5:
				break;
			default:
				System.out.println("Wrong choice try again");
			    break;
			}
	    }
	    break; 
	    case 3:{
	    	System.out.println();
			System.out.println("--- FinancialRecordService ---");
			System.out.println(" AddFinancialRecord : 1");
			System.out.println(" GetFinancialRecordById : 2");
			System.out.println(" GetFinancialRecordsForEmployee : 3");
			System.out.println(" GetFinancialRecordsForDate : 4");
			System.out.println(" Back : 5");
			System.out.print("Select option : ");
			int option2=scanner.nextInt();
			switch(option2) {
			case 1:
				financialrecord.AddFinancialRecord();
				break;
			case 2:
				financialrecord.GetFinancialRecordById();
				break;
			case 3:
				financialrecord.GetFinancialRecordsForEmployee();
				break;
			case 4:
				financialrecord.GetFinancialRecordsForDate();
				break;
			case 5:
				break;
			default:
				System.out.println("wrong choice try again");
				break;
			}
	    }
	    break;
	    case 4:{
	    	System.out.println();
			System.out.println("--- Tax ---");
			System.out.println(" Calculate Tax : 1");
			System.out.println(" Get Tax By Id : 2");
			System.out.println(" Get Taxes For Employee : 3");
			System.out.println(" Get Taxes For Year : 4");
			System.out.println(" Back : 5");
			System.out.print("Select option : ");
			int option2=scanner.nextInt();
			switch(option2) {
			case 1:
				taxservice.CalculateTax();
				break;
			case 2:
				taxservice.GetTaxById();
				break;
			case 3:
				taxservice.GetTaxesForEmployee();
				break;
			case 4:
				taxservice.GetTaxesForYear();
				break;
			case 5:
				break;
			default:
				System.out.println("Invalid choice try again");
				break;
			}	
	    }
	    break;
	    default: 
			System.out.println("Enter the right choice. ");
	    break;
	    }
	    // Ask user if they want to continue
	    System.out.println("Do you want to continue? Y or y");
		ch = scanner.next();
	    }while (ch.equals("Y") || ch.equals("y"));
	    // Exit message
	    System.out.println("Thanks for using our system !!!");
		System.exit(0);
	    scanner.close();
	    
			
	    }
}

