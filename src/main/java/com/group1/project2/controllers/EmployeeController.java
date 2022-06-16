package com.group1.project2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group1.project2.exception.ApplicationException;
import com.group1.project2.models.pojo.EmployeePojo;
import com.group1.project2.models.pojo.LoginForm;
import com.group1.project2.service.MainService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	MainService mainServ;
	
	
	
	@PostMapping("/login")
	public EmployeePojo login(@RequestBody LoginForm login) {
		EmployeePojo employee = null;
		try {
			employee = mainServ.validateLogin(login.getUsername(), login.getPassword());
			System.out.println(login.getUsername());
			System.out.println(login.getPassword());
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}
	
	@GetMapping("/employee/{emp_id}")
	public EmployeePojo getEmployee(@PathVariable("emp_id") int id) {
		try {
			return mainServ.getEmployee(id);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PutMapping("/employee")
	public EmployeePojo updateEmployee(@RequestBody EmployeePojo empPojo) {
		try {
			return mainServ.updateEmployee(empPojo);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/employee")
	public List<EmployeePojo> getAllEmployees() {
		try {
			return mainServ.getAllEmployees();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
