package com.hexaware.dao.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hexaware.dao.PayrollServiceDao;
import com.hexaware.model.Payroll;
/**
 * Testcase for payrollservicedao
 */
public class PayRollServiceDaoTest {
	PayrollServiceDao payroll;
	/**
     * Set up method to initialize objects before each test case.
     */
	@Before
	public void setUp() {
		System.out.println("From Setup() PayrollServiceDao");
		payroll = new PayrollServiceDao();
	}
	/**
     * Test case to process payroll for multiple employees.
     * 
     * @throws ParseException If there's an error in parsing dates.
     */
	@Test
   public void processPayrollForMultipleEmployees() throws ParseException {

        // Define payroll details for Employee 1
        int payrollId1 = 12;
        int employeeId1 = 1;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String startdatestring="2024-04-01";
		Date startDate1 = sdf.parse(startdatestring);
		String enddatestring="2024-04-31";
	    Date endDate1 = sdf.parse(enddatestring);
	
        double basicSalary1 = 50000.0;
        double overtimePay1 = 2000.0;
        double deductions1 = 5000.0;
        double netSalary1 = basicSalary1 + overtimePay1 - deductions1;

        Payroll payrolll = new Payroll(payrollId1, employeeId1, startDate1, endDate1, basicSalary1, overtimePay1, deductions1, netSalary1);
        assertNotNull(payrolll);

        // Define payroll details for Employee 2
        int payrollId2 = 13;
        int employeeId2 = 2;
        String startdatestring2="2024-04-01";
		Date startDate2 = sdf.parse(startdatestring);
		String enddatestring2="2024-04-31";
	    Date endDate2 = sdf.parse(enddatestring);
        double basicSalary2 = 60000.0;
        double overtimePay2 = 2200.0;
        double deductions2 = 6000.0;
        double netSalary2 = basicSalary2 + overtimePay2 - deductions2;

        Payroll payroll2 = new Payroll(payrollId2, employeeId2, startDate2, endDate2, basicSalary2, overtimePay2, deductions2, netSalary2);
        assertNotNull(payroll2);

        try {
            // Generate payroll for Employee 1
            payroll.GeneratePayroll(payrolll);
            // Generate payroll for Employee 2
            payroll.GeneratePayroll(payroll2);

           
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
	}
	/**
     * Tear down method to clean up objects after each test case.
     */
	@After
	public void tearDown() {
		System.out.println("From tearDown() PayrollServiceDao");
		payroll =null;
	}
}

