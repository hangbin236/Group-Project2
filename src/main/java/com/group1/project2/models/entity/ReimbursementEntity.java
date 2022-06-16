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
	private int rb_id;
	
	@Column(name="rb_status")
	private String rb_status;
	
	@Column(name="rb_amount")
	private double rb_amount;
	
	@Column(name="rb_timestamp")
	private Timestamp rb_timestamp;
	
	@ManyToOne
	@JoinColumn(name="emp_id", nullable=false)
	private EmployeeEntity employee;
	
	public ReimbursementEntity() {
		
	}
	
	public ReimbursementEntity(double rb_amount) {
		super();
		this.rb_amount = rb_amount;
		rb_status = "pending";
		rb_timestamp = new Timestamp(System.currentTimeMillis());
	}

	public ReimbursementEntity(String rb_status, double rb_amount, Timestamp rb_timestamp, EmployeeEntity employee) {
		super();
		this.rb_status = rb_status;
		this.rb_amount = rb_amount;
		this.rb_timestamp = rb_timestamp;
		this.employee = employee;
	}

	public ReimbursementEntity(int rb_id, String rb_status, double rb_amount, Timestamp rb_timestamp,
			EmployeeEntity employee) {
		super();
		this.rb_id = rb_id;
		this.rb_status = rb_status;
		this.rb_amount = rb_amount;
		this.rb_timestamp = rb_timestamp;
		this.employee = employee;
	}

	public int getRb_id() {
		return rb_id;
	}

	public void setRb_id(int rb_id) {
		this.rb_id = rb_id;
	}

	public String getRb_status() {
		return rb_status;
	}

	public void setRb_status(String rb_status) {
		this.rb_status = rb_status;
	}

	public double getRb_amount() {
		return rb_amount;
	}

	public void setRb_amount(double rb_amount) {
		this.rb_amount = rb_amount;
	}

	public Timestamp getRb_timestamp() {
		return rb_timestamp;
	}

	public void setRb_timestamp(Timestamp rb_timestamp) {
		this.rb_timestamp = rb_timestamp;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employee, rb_amount, rb_id, rb_status, rb_timestamp);
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
		return Objects.equals(employee, other.employee)
				&& Double.doubleToLongBits(rb_amount) == Double.doubleToLongBits(other.rb_amount)
				&& rb_id == other.rb_id && Objects.equals(rb_status, other.rb_status)
				&& Objects.equals(rb_timestamp, other.rb_timestamp);
	}

	@Override
	public String toString() {
		return "ReimbursementEntity [rb_id=" + rb_id + ", rb_status=" + rb_status + ", rb_amount=" + rb_amount
				+ ", rb_timestamp=" + rb_timestamp + ", employee=" + employee + "]";
	}
	
	
}
