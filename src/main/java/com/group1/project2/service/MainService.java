package com.group1.project2.service;

import java.util.List;

import com.group1.project2.exception.ApplicationException;
import com.group1.project2.models.pojo.EmployeePojo;
import com.group1.project2.models.pojo.ReimbursementPojo;

public interface MainService {
	EmployeePojo validateLogin(String email, String password) throws ApplicationException;
	EmployeePojo getEmployee(int emp_id) throws ApplicationException;
	EmployeePojo updateEmployee(EmployeePojo empPojo) throws ApplicationException;
	List<EmployeePojo> getAllEmployees() throws ApplicationException;
	
	List<ReimbursementPojo> getAllRequests() throws ApplicationException;
	List<ReimbursementPojo> getAllRequestsByStatus(String status) throws ApplicationException;
	List<ReimbursementPojo> getEmployeeRequests(EmployeePojo empPojo) throws ApplicationException;
//	boolean updateRequestStatus(int rb_id, String newStatus) throws ApplicationException;
//	boolean updateRequestDetail(int rb_id, double newAmount) throws ApplicationException;
	ReimbursementPojo updateRequest(ReimbursementPojo rbPojo) throws ApplicationException;
	ReimbursementPojo submitRequest(EmployeePojo empPojo, double amount) throws ApplicationException;
	List<ReimbursementPojo> viewMyRequests(EmployeePojo empPojo, String status) throws ApplicationException;
}