package com.group1.project2.models.entity;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee_details")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int emp_id;
	
	@Column(name="password")
	private String password;
	
	@Column(name="job_code")
	private int job_code;
	
	@Column(name="fname")
	private String fname;

	@Column(name="lname")
	private String lname;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy="employee")
	private Set<ReimbursementEntity> reimbursements;
	
	public EmployeeEntity() {
		
	}

	public EmployeeEntity(String password, int job_code, String fname, String lname, String email) {
		super();
		this.password = password;
		this.job_code = job_code;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}

	public EmployeeEntity(int emp_id, String password, int job_code, String fname, String lname, String email) {
		super();
		this.emp_id = emp_id;
		this.password = password;
		this.job_code = job_code;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getJob_code() {
		return job_code;
	}

	public void setJob_code(int job_code) {
		this.job_code = job_code;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [emp_id=" + emp_id + ", password=" + password + ", job_code=" + job_code + ", fname="
				+ fname + ", lname=" + lname + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, emp_id, fname, job_code, lname, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeEntity other = (EmployeeEntity) obj;
		return Objects.equals(email, other.email) && emp_id == other.emp_id && Objects.equals(fname, other.fname)
				&& job_code == other.job_code && Objects.equals(lname, other.lname)
				&& Objects.equals(password, other.password);
	}
	
	
	
}
