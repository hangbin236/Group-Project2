package com.group1.project2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group1.project2.dao.EmployeeDao;
import com.group1.project2.dao.ReimbursementDao;
import com.group1.project2.exception.ApplicationException;
import com.group1.project2.models.entity.EmployeeEntity;
import com.group1.project2.models.pojo.EmployeePojo;
import com.group1.project2.models.pojo.ReimbursementPojo;

@Service
public class MainServiceImpl implements MainService {
	
	@Autowired
	EmployeeDao empDao;
	@Autowired
	ReimbursementDao rbDao;
	
	public MainServiceImpl() {
		
	}
	
	@Override
	public EmployeePojo validateLogin(String email, String password) throws ApplicationException {
//		EmployeeEntity empEntity = empDao.
		return null;
	}

	@Override
	public EmployeePojo getEmployee(int emp_id) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeePojo updateEmployee(EmployeePojo empPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeePojo> getAllEmployees() throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbursementPojo> getAllRequests() throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbursementPojo> getAllRequestsByStatus(String status) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbursementPojo> getEmployeeRequests(EmployeePojo empPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReimbursementPojo updateRequest(ReimbursementPojo rbPojo) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReimbursementPojo submitRequest(int emp_id, double amount) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReimbursementPojo> viewMyRequests(int emp_id, String status) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}
