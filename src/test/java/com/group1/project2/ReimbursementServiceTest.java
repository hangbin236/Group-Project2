package com.group1.project2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.lenient;

import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.beans.BeanUtils;

import com.group1.project2.dao.ReimbursementDao;
import com.group1.project2.exception.ApplicationException;
import com.group1.project2.models.entity.EmployeeEntity;
import com.group1.project2.models.entity.ReimbursementEntity;
import com.group1.project2.models.pojo.EmployeePojo;
import com.group1.project2.models.pojo.ReimbursementPojo;

import com.group1.project2.service.MainServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ReimbursementServiceTest {
	
	@InjectMocks
	private MainServiceImpl serviceTest;
	
	@Mock
	private ReimbursementDao daoMock;
	
	@Test
	public void firstTest() {
		assertTrue(true);
	}
	
	@Test
	public void getAllRequestsTest() {		
	
		List<ReimbursementEntity> returnRbEntities = new ArrayList<ReimbursementEntity>();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		EmployeeEntity empEntity1 = new EmployeeEntity("password", 100, "Carl", "Jones", "cjones@gmail.com");
		EmployeePojo empPojo1 = new EmployeePojo(0, "password", 100, "Carl", "Jones", "cjones@gmail.com");
		
		ReimbursementEntity rbEntity1 = new ReimbursementEntity(10, "pending", 200, timestamp, empEntity1);
		ReimbursementEntity rbEntity2 = new ReimbursementEntity(13, "pending", 150, timestamp, empEntity1);
		
		returnRbEntities.add(rbEntity1);
		returnRbEntities.add(rbEntity2);
		
		ReimbursementPojo rbPojo1 = new ReimbursementPojo(10, "pending", 200, timestamp, empPojo1);
		ReimbursementPojo rbPojo2 = new ReimbursementPojo(13, "pending", 150, timestamp, empPojo1);
		
		when(daoMock.findAll()).thenReturn(returnRbEntities);
		
		
		List<ReimbursementPojo> expectedRbPojos = new ArrayList<ReimbursementPojo>();
		expectedRbPojos.add(rbPojo1);
		expectedRbPojos.add(rbPojo2);
		
		List<ReimbursementPojo> actualRbPojos = null;
		
		try {
			actualRbPojos = serviceTest.getAllRequests();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		
		assertEquals(expectedRbPojos, actualRbPojos);
	
	}
	
	@Test
	public void getRequestByStatusTest() {
		
		List<ReimbursementEntity> returnRbPendingEntities = new ArrayList<ReimbursementEntity>();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String status = "pending";
		
		EmployeeEntity empEntity1 = new EmployeeEntity("password", 100, "Carl", "Jones", "cjones@gmail.com");
		EmployeePojo empPojo1 = new EmployeePojo(0, "password", 100, "Carl", "Jones", "cjones@gmail.com");
		
		ReimbursementEntity rbEntity1 = new ReimbursementEntity(10, "pending", 200, timestamp, empEntity1);
		ReimbursementEntity rbEntity2 = new ReimbursementEntity(13, "pending", 150, timestamp, empEntity1);
		ReimbursementEntity rbEntity3 = new ReimbursementEntity(14, "approved", 150, timestamp, empEntity1);
		
		returnRbPendingEntities.add(rbEntity1);
		returnRbPendingEntities.add(rbEntity2);
		
		
		ReimbursementPojo rbPojo1 = new ReimbursementPojo(10, "pending", 200, timestamp, empPojo1);
		ReimbursementPojo rbPojo2 = new ReimbursementPojo(13, "pending", 150, timestamp, empPojo1);
		
		when(daoMock.findByStatus(status)).thenReturn(returnRbPendingEntities);		
		
		List<ReimbursementPojo> expectedRbPojos = new ArrayList<ReimbursementPojo>();
		expectedRbPojos.add(rbPojo1);
		expectedRbPojos.add(rbPojo2);
		
		List<ReimbursementPojo> actualRbPojos = null;
		
		try {
			actualRbPojos = serviceTest.getAllRequestsByStatus(status);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		
		assertEquals(expectedRbPojos, actualRbPojos);
	
		
	}
	
	
	@Test
	public void getRequestByEmployeeTest() {
		
		List<ReimbursementEntity> returnRbEmpEntities = new ArrayList<ReimbursementEntity>();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		int empId = 0;
		
		EmployeeEntity empEntity1 = new EmployeeEntity("password", 100, "Carl", "Jones", "cjones@gmail.com");
		EmployeeEntity empEntity2 = new EmployeeEntity("password", 100, "Mark", "Zuck", "mzuck@gmail.com");
		
		EmployeePojo empPojo1 = new EmployeePojo(0, "password", 100, "Carl", "Jones", "cjones@gmail.com");
		EmployeePojo empPojo2 = new EmployeePojo(1, "password", 100, "Mark", "Zuck", "mzuck@gmail.com");
		
		ReimbursementEntity rbEntity1 = new ReimbursementEntity(10, "pending", 200, timestamp, empEntity1);
		ReimbursementEntity rbEntity2 = new ReimbursementEntity(11, "pending", 150, timestamp, empEntity1);		
		ReimbursementEntity rbEntity3 = new ReimbursementEntity(12, "pending", 200, timestamp, empEntity2);
		ReimbursementEntity rbEntity4 = new ReimbursementEntity(13, "pending", 150, timestamp, empEntity2);
		
		returnRbEmpEntities.add(rbEntity1);
		returnRbEmpEntities.add(rbEntity2);		
		
		ReimbursementPojo rbPojo1 = new ReimbursementPojo(10, "pending", 200, timestamp, empPojo1);
		ReimbursementPojo rbPojo2 = new ReimbursementPojo(11, "pending", 150, timestamp, empPojo1);
		
		when(daoMock.findByEmployeeId(empId)).thenReturn(returnRbEmpEntities);	
		
		
		List<ReimbursementPojo> expectedRbPojos = new ArrayList<ReimbursementPojo>();
		expectedRbPojos.add(rbPojo1);
		expectedRbPojos.add(rbPojo2);
		
		List<ReimbursementPojo> actualRbPojos = null;
		
		try {
			actualRbPojos = serviceTest.getEmployeeRequests(empId);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		
		assertEquals(expectedRbPojos, actualRbPojos);
		
	}
	
	
	@Test
	public void updateRequestTest() {
		/********************************UNDER CONSTRUCTION********************************************/
	}
	
	
	@Test
	public void submitRequestTest() {
		
		/********************************UNDER CONSTRUCTION********************************************/
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		EmployeeEntity empEntity1 = new EmployeeEntity("password", 100, "Carl", "Jones", "cjones@gmail.com");
		EmployeePojo empPojo1 = new EmployeePojo(0, "password", 100, "Carl", "Jones", "cjones@gmail.com");
		
		ReimbursementEntity rbEntity1 = new ReimbursementEntity(1, "pending", 250, timestamp, empEntity1 );
	
		
		lenient().when(daoMock.save(rbEntity1)).thenReturn(rbEntity1);
		
		ReimbursementPojo expectedPojo = new ReimbursementPojo(14, "pending", 250, timestamp, empPojo1);
		ReimbursementPojo actualPojo = null;
		
		try {
			actualPojo = serviceTest.submitRequest(empPojo1, 250);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		
		assertEquals(expectedPojo, actualPojo);
		
	}
	
	
	@Test
	public void getMyRequestsTest() {
		
		List<ReimbursementEntity> returnRbEmpEntities = new ArrayList<ReimbursementEntity>();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		int empId = 0;
		String status = "pending";
		
		EmployeeEntity empEntity1 = new EmployeeEntity("password", 100, "Carl", "Jones", "cjones@gmail.com");
		EmployeeEntity empEntity2 = new EmployeeEntity("password", 100, "Mark", "Zuck", "mzuck@gmail.com");
		
		EmployeePojo empPojo1 = new EmployeePojo(0, "password", 100, "Carl", "Jones", "cjones@gmail.com");
		EmployeePojo empPojo2 = new EmployeePojo(1, "password", 100, "Mark", "Zuck", "mzuck@gmail.com");
		
		ReimbursementEntity rbEntity1 = new ReimbursementEntity(10, "pending", 200, timestamp, empEntity1);
		ReimbursementEntity rbEntity2 = new ReimbursementEntity(11, "approved", 150, timestamp, empEntity1);		
		ReimbursementEntity rbEntity3 = new ReimbursementEntity(12, "approved", 200, timestamp, empEntity2);
		ReimbursementEntity rbEntity4 = new ReimbursementEntity(13, "denied", 150, timestamp, empEntity2);
		
		returnRbEmpEntities.add(rbEntity1);
		// returnRbEmpEntities.add(rbEntity2);		
		
		ReimbursementPojo rbPojo1 = new ReimbursementPojo(10, "pending", 200, timestamp, empPojo1);
		ReimbursementPojo rbPojo2 = new ReimbursementPojo(11, "pending", 150, timestamp, empPojo1);
		
		when(daoMock.findByEmployeeIdAndStatus(empId, status)).thenReturn(returnRbEmpEntities);	
		
		
		List<ReimbursementPojo> expectedRbPojos = new ArrayList<ReimbursementPojo>();
		expectedRbPojos.add(rbPojo1);
		// expectedRbPojos.add(rbPojo2); 
		
		List<ReimbursementPojo> actualRbPojos = null;
		
		try {
			actualRbPojos = serviceTest.viewMyRequests(empId, status);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		
		assertEquals(expectedRbPojos, actualRbPojos);
		
	}
	
	
}















