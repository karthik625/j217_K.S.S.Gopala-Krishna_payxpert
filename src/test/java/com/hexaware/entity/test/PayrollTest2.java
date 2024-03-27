package com.hexaware.entity.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.model.Payroll;

/**
 * Test class for the Payroll class.
 */
public class PayrollTest2 {
	Payroll payroll;

	/**
	 * Set up method to initialize objects before each test case.
	 */
	@Before
	public void setUp() {
		System.out.println("From Setup() Payroll");
		payroll = new Payroll();
	}

	/**
	 * Test case to calculate net salary after deduction.
	 */
	@Test
	public void CalcutateNetSalaryAfterDeduction() {

		payroll.setBasicSalary(1000.0);
		payroll.setOvertimePay(300.0);

		double actualSalary = 1300;
		assertEquals(payroll.getBasicSalary()+payroll.getOvertimePay(), actualSalary, 0.0);

	}
	/**
     * Tear down method to clean up objects after each test case.
     */
	@After
	public void tearDown() {
		System.out.println("From tearDown() Payroll");
		payroll = null;
	}
}
