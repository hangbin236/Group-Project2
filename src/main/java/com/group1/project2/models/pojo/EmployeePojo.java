package com.group1.project2.models.pojo;

import java.util.Objects;

public class EmployeePojo {
	
	private int id;
	private String password;
	private int job_code;
	private String fname;
	private String lname;
	private String email;
	
	public EmployeePojo() {
		super();
	}

	public EmployeePojo(int id, String password, int job_code, String fname, String lname, String email) {
		super();
		this.id = id;
		this.password = password;
		this.job_code = job_code;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public int hashCode() {
		return Objects.hash(email, fname, id, job_code, lname, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeePojo other = (EmployeePojo) obj;
		return Objects.equals(email, other.email) && Objects.equals(fname, other.fname) && id == other.id
				&& job_code == other.job_code && Objects.equals(lname, other.lname)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "EmployeePojo [id=" + id + ", password=" + password + ", job_code=" + job_code + ", fname=" + fname
				+ ", lname=" + lname + ", email=" + email + "]";
	}

	
	
	
}