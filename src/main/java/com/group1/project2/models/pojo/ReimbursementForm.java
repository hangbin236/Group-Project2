package com.group1.project2.models.pojo;

public class ReimbursementForm {
	
	private double amount;
	private EmployeePojo employee;
	
	public ReimbursementForm() {
		
	}
	
	public ReimbursementForm(double amount, EmployeePojo employee) {
		super();
		this.amount = amount;
		this.employee = employee;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public EmployeePojo getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeePojo employee) {
		this.employee = employee;
	}
	
	

}
