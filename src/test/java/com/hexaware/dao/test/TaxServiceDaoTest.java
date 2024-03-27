package com.hexaware.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.time.Year;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.dao.TaxServiceDao;

/**
 * Test case for class TaxServiceDao
 */
public class TaxServiceDaoTest {
	TaxServiceDao taxservice;
	/**
     * Set up method executed before each test case.
     */
	@Before
	public void setUp() {
		System.out.println("From Setup() Payroll");
		taxservice = new TaxServiceDao();
	}
	/**
     * Test case to verify tax calculation for high-income employees.
     */
	@Test
	public void verifyTaxCalculationForHighIncomeEmployee() {
		int employeeId = 4;
		Year taxYear = Year.of(2024); // Replace with the desired tax year

		// Act
		try {
			double tax = (taxservice.CalculateTax(employeeId, taxYear)) * 0.2;
			System.out.println(tax);
			double expectedValue = 9060.0;
			assertEquals(expectedValue, tax, 0.0);
		} catch (Exception e) {
			fail("Exception occurred: " + e.getMessage());
		}
	}
	/**
     * Tear down method to clean up objects after each test case.
     */
	@After
	public void tearDown() {
		System.out.println("From tearDown() TaxServiceDao");
		taxservice =null;
	}
}
