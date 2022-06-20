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
import com.group1.project2.models.pojo.ReimbursementForm;
import com.group1.project2.models.pojo.ReimbursementPojo;
import com.group1.project2.service.MainService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ReimbursementController {
	@Autowired
	MainService mainServ;
	
	@GetMapping("/reimbursement")
	public List<ReimbursementPojo> getAllReimbursements() {
		try {
			return mainServ.getAllRequests();
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/reimbursement/{status}")
	public List<ReimbursementPojo> getAllReimbursementsByStatus(@PathVariable("status") String status) {
		try {
			return mainServ.getAllRequestsByStatus(status);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/reimbursement/employee/{emp_id}")
	public List<ReimbursementPojo> getReimbursementsByEmployee(@PathVariable("emp_id") int id) {
		try {
			return mainServ.getEmployeeRequests(id);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/reimbursement/{status}/{emp_id}")
	public List<ReimbursementPojo> getReimbursementsByEmployeeAndStatus(@PathVariable("status") String status, @PathVariable("emp_id") int id) {
		try {
			return mainServ.viewMyRequests(id, status);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PutMapping("/reimbursement")
	public ReimbursementPojo updateReimbursement(@RequestBody ReimbursementPojo rbPojo) {
		try {
			return mainServ.updateRequest(rbPojo);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("/reimbursement")
	public ReimbursementPojo createReimbursement(@RequestBody ReimbursementForm rbForm) {
		try {
			return mainServ.submitRequest(rbForm.getEmployee(), rbForm.getAmount());
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
