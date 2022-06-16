package com.group1.project2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group1.project2.dao.EmployeeDao;
import com.group1.project2.dao.ReimbursementDao;
import com.group1.project2.exception.ApplicationException;
import com.group1.project2.models.entity.EmployeeEntity;
import com.group1.project2.models.entity.ReimbursementEntity;
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
		Optional<EmployeeEntity> empEntity = empDao.findByEmailAndPassword(email, password);
		EmployeePojo empPojo = null;
		if(empEntity.isPresent()) {
			EmployeeEntity fetchedEmpEntity = empEntity.get();
			empPojo = new EmployeePojo();
			BeanUtils.copyProperties(fetchedEmpEntity, empPojo);
		}
		return empPojo;
	}

	@Override
	public EmployeePojo getEmployee(int emp_id) throws ApplicationException {
		Optional<EmployeeEntity> empEntity = empDao.findById(emp_id);
		EmployeePojo empPojo = null;
		if(empEntity.isPresent()) {
			EmployeeEntity fetchedEmpEntity = empEntity.get();
			empPojo = new EmployeePojo();
			BeanUtils.copyProperties(fetchedEmpEntity, empPojo);
		}
		return empPojo;
	}

	@Override
	public EmployeePojo updateEmployee(EmployeePojo empPojo) throws ApplicationException {
		EmployeeEntity empEntity = new EmployeeEntity();
		BeanUtils.copyProperties(empPojo, empEntity);
//		EmployeeEntity returnedEmpEntity = empDao.save(empEntity);
		return empPojo;
	}

	@Override
	public List<EmployeePojo> getAllEmployees() throws ApplicationException {
		List<EmployeeEntity> allEmployeesEntity = empDao.findAll();
		List<EmployeePojo> allEmployeesPojo = new ArrayList<EmployeePojo>();
		
		for(EmployeeEntity fetchedEmpEntity : allEmployeesEntity) {
			EmployeePojo returnedEmpPojo = new EmployeePojo();
			BeanUtils.copyProperties(fetchedEmpEntity, returnedEmpPojo);
			allEmployeesPojo.add(returnedEmpPojo);
		}
		
		return allEmployeesPojo;
	}

	@Override
	public List<ReimbursementPojo> getAllRequests() throws ApplicationException {
		List<ReimbursementEntity> allRbEntity = rbDao.findAll();
		List<ReimbursementPojo> allRbPojo = new ArrayList<ReimbursementPojo>();
		
		for(ReimbursementEntity fetchedRbEntity : allRbEntity) {
			ReimbursementPojo returnedRbPojo = new ReimbursementPojo();
			BeanUtils.copyProperties(fetchedRbEntity, returnedRbPojo);
			allRbPojo.add(returnedRbPojo);
		}
		return allRbPojo;
	}

	@Override
	public List<ReimbursementPojo> getAllRequestsByStatus(String status) throws ApplicationException {
		List<ReimbursementEntity> allRbEntity = rbDao.findByStatus(status);
		List<ReimbursementPojo> allRbPojo = new ArrayList<ReimbursementPojo>();
		
		for(ReimbursementEntity fetchedRbEntity : allRbEntity) {
			ReimbursementPojo returnedRbPojo = new ReimbursementPojo();
			BeanUtils.copyProperties(fetchedRbEntity, returnedRbPojo);
			allRbPojo.add(returnedRbPojo);
		}
		return allRbPojo;
	}

	@Override
	public List<ReimbursementPojo> getEmployeeRequests(EmployeePojo empPojo) throws ApplicationException {
		EmployeeEntity empEntity = new EmployeeEntity();
		BeanUtils.copyProperties(empPojo, empEntity);
		
		List<ReimbursementEntity> allRbEntity = rbDao.findByEmployee(empEntity);
		List<ReimbursementPojo> allRbPojo = new ArrayList<ReimbursementPojo>();
		
		for(ReimbursementEntity fetchedRbEntity : allRbEntity) {
			ReimbursementPojo returnedRbPojo = new ReimbursementPojo();
			BeanUtils.copyProperties(fetchedRbEntity, returnedRbPojo);
			allRbPojo.add(returnedRbPojo);
		}
		return allRbPojo;
	}

	@Override
	public ReimbursementPojo updateRequest(ReimbursementPojo rbPojo) throws ApplicationException {
		ReimbursementEntity rbEntity = new ReimbursementEntity();
		BeanUtils.copyProperties(rbPojo, rbEntity);
		rbDao.save(rbEntity);
		return rbPojo;
	}

	@Override
	public ReimbursementPojo submitRequest(EmployeePojo empPojo, double amount) throws ApplicationException {
		EmployeeEntity empEntity = new EmployeeEntity();
		BeanUtils.copyProperties(empPojo, empEntity);
		ReimbursementEntity rbEntity = new ReimbursementEntity();
		rbEntity.setRb_amount(amount);
		rbEntity.setEmployee(empEntity);
		
		rbEntity = rbDao.save(rbEntity);
		ReimbursementPojo rbPojo = new ReimbursementPojo();
		BeanUtils.copyProperties(rbEntity, rbPojo);
		return rbPojo;
	}

	@Override
	public List<ReimbursementPojo> viewMyRequests(EmployeePojo empPojo, String status) throws ApplicationException {
		EmployeeEntity empEntity = new EmployeeEntity();
		BeanUtils.copyProperties(empPojo, empEntity);
		
		List<ReimbursementEntity> allRbEntity = rbDao.findByEmployeeAndStatus(empEntity, status);
		List<ReimbursementPojo> allRbPojo = new ArrayList<ReimbursementPojo>();
		
		for(ReimbursementEntity fetchedRbEntity : allRbEntity) {
			ReimbursementPojo returnedRbPojo = new ReimbursementPojo();
			BeanUtils.copyProperties(fetchedRbEntity, returnedRbPojo);
			allRbPojo.add(returnedRbPojo);
		}
		return allRbPojo;
	}

}
