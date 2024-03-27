package com.hexaware.dao.test;

import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.dao.EmployeeServiceDao;
import com.hexaware.model.Employee;
/**
 * Test class for EmployeeServiceDao.
 */
public class EmployeeServiceDaoTest {
	EmployeeServiceDao employeeservice;
	/**
     * Setup method to initialize objects before each test.
     */
	@Before
	public void setUp() {
		System.out.println("From Setup() EmployeeServiceDao");
		employeeservice = new EmployeeServiceDao();
	}
	/**
     * Test method to verify error handling for invalid employee data.
     * @throws ParseException if there's an error in parsing the date.
     */
	@Test
	public void VerifyErrorHandlingForInvalidEmployeeData() throws ParseException {		
		Employee invalidEmployee = employeeservice.GetEmployeeById(101);
        assertNull(invalidEmployee);
		
	}
	/**
     * Tear down method to clean up objects after each test.
     */
	@After
	public void tearDown() {
		System.out.println("From tearDown() EmployeeServiceDao");
		employeeservice =null;
	}
}
