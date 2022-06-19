package com.group1.project2.exception;

public class EmployeeNotFoundException extends Exception{
	
	int empId;
	
	public EmployeeNotFoundException(int empId) {
		this.empId = empId;
	}
	
	@Override
	public String getMessage() {
		return "Emp with ID: " + empId + "not found!";
	}

}
