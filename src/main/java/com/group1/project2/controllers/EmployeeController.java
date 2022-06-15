package com.group1.project2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group1.project2.models.pojo.EmployeePojo;
import com.group1.project2.service.MainService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	MainService mainServ;
	
	
	
	@PostMapping("/login")
	public EmployeePojo login() {
		return null;
	}
}
