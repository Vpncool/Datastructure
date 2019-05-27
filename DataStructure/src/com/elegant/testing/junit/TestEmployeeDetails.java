package com.elegant.testing.junit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestEmployeeDetails {

	EmployeeDetails employee = new EmployeeDetails();
	EmployeeBusinessLogic logic = new EmployeeBusinessLogic();

	// test check for appraisal
	@Test
	public void appraisalTest() {
		employee.setName("Vipin");
		employee.setAge(22);
		employee.setSalary(11000);
		double appraisal = logic.appraisal(employee);
		assertEquals(1000, appraisal, 0.0);
	}

	@Test
	public void yearlySalary() {
		employee.setName("Anjali");
		employee.setAge(22);
		employee.setSalary(20000);
		double yearlySalary = logic.yearlySalary(employee);
		assertEquals(96000, yearlySalary, 0.0);
	}
}
