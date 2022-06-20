package com.group1.project2.models.pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class ReimbursementPojo {

	private int id;
	private String status;
	private double amount;
	private Timestamp timestamp;
	private EmployeePojo employee;
	
	public ReimbursementPojo() {
		super();
	}

	public ReimbursementPojo(int id, String status, double amount, Timestamp timestamp, EmployeePojo employee) {
		super();
		this.id = id;
		this.status = status;
		this.amount = amount;
		this.timestamp = timestamp;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public EmployeePojo getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeePojo employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, employee, id, status, timestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementPojo other = (ReimbursementPojo) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(employee, other.employee) && id == other.id && Objects.equals(status, other.status)
				&& Objects.equals(timestamp, other.timestamp);
	}

	@Override
	public String toString() {
		return "ReimbursementPojo [id=" + id + ", status=" + status + ", amount=" + amount + ", timestamp=" + timestamp
				+ ", employee=" + employee + "]";
	}

	
	
}