package com.group1.project2.models.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reimbursement_details")
public class ReimbursementEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rb_id")
	private int id;
	
	@Column(name="rb_status")
	private String status;
	
	@Column(name="rb_amount")
	private double amount;
	
	@Column(name="rb_timestamp")
	private Timestamp timestamp;
	
	@ManyToOne
	@JoinColumn(name="emp_id", nullable=false)
	private EmployeeEntity employee;
	
	public ReimbursementEntity() {
		
	}

	public ReimbursementEntity(double amount) {
		super();
		this.amount = amount;
		status = "pending";
		timestamp = new Timestamp(System.currentTimeMillis());
	}

	public ReimbursementEntity(int id, String status, double amount, Timestamp timestamp, EmployeeEntity employee) {
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

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
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
		ReimbursementEntity other = (ReimbursementEntity) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(employee, other.employee) && id == other.id && Objects.equals(status, other.status)
				&& Objects.equals(timestamp, other.timestamp);
	}

	@Override
	public String toString() {
		return "ReimbursementEntity [id=" + id + ", status=" + status + ", amount=" + amount + ", timestamp="
				+ timestamp + ", employee=" + employee + "]";
	}

	
	
}
