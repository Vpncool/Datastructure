package com.elegant.testing.junit;

public class EmployeeBusinessLogic {

	// calculate the yearly salary of employee
	public double yearlySalary(EmployeeDetails employee) {
		double yearlySalary = 0.0;
		yearlySalary = employee.getSalary() * 12;
		return yearlySalary;
	}

	// calculate the appraisal amount of employee
	public double appraisal(EmployeeDetails employee) {
		double appraisal = 0.0;
		if (employee.getSalary() < 10000)
			appraisal = 500;
		else
			appraisal = 1000;
		return appraisal;
	}
}
