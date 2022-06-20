package com.group1.project2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.lenient;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.beans.BeanUtils;

import com.group1.project2.dao.EmployeeDao;
import com.group1.project2.exception.ApplicationException;
import com.group1.project2.models.entity.EmployeeEntity;
import com.group1.project2.models.pojo.EmployeePojo;

import com.group1.project2.service.MainServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@InjectMocks
	private MainServiceImpl serviceTest;

	@Mock
	private EmployeeDao daoMock;

	@Test
	public void firstTest() {
		assertTrue(true);
	}

	@Test
	public void validateLoginTest() {

		Optional<EmployeeEntity> empEntity = Optional
				.of(new EmployeeEntity("password", 100, "Carl", "Jones", "cjones@gmail.com"));
		String password = "password";
		String email = "cjones@gmail.com";

		when(daoMock.findByEmailAndPassword(email, password)).thenReturn(empEntity);

		EmployeePojo expectedPojo = new EmployeePojo(0, "password", 100, "Carl", "Jones", "cjones@gmail.com");
		EmployeePojo actualPojo = null;

		try {
			actualPojo = serviceTest.validateLogin(email, password);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

		assertEquals(expectedPojo, actualPojo);

	}

	@Test
	public void getEmployeeTest() {

		Optional<EmployeeEntity> empEntity = Optional
				.of(new EmployeeEntity("password", 100, "Carl", "Jones", "cjones@gmail.com"));

		when(daoMock.findById(0)).thenReturn(empEntity);

		EmployeePojo expectedPojo = new EmployeePojo(0, "password", 100, "Carl", "Jones", "cjones@gmail.com");
		EmployeePojo actualPojo = null;

		try {
			actualPojo = serviceTest.getEmployee(0);
		} catch (ApplicationException e1) {
			e1.printStackTrace();
		}

		assertEquals(expectedPojo, actualPojo);

	}

	@Test
	public void updateEmployeeTest() {

		EmployeeEntity updateEmpEntity = new EmployeeEntity("password", 100, "Leia", "Organa", "lorgana@gmail.com");
		EmployeePojo sendPojo = new EmployeePojo(0, "password", 100, "Leia", "Organa", "lorgana@gmail.com");

		lenient().when(daoMock.save(updateEmpEntity)).thenReturn(updateEmpEntity);

		EmployeePojo actualPojo = null;
		EmployeePojo testPojo = null;

		try {
			actualPojo = serviceTest.updateEmployee(sendPojo);
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

		assertEquals(sendPojo, actualPojo);

	}

	@Test
	public void getAllEmployeesTest() {

		List<EmployeeEntity> returnEmpEntities = new ArrayList<EmployeeEntity>();

		EmployeeEntity empEntity1 = new EmployeeEntity("password", 100, "Carl", "Jones", "cjones@gmail.com");
		EmployeeEntity empEntity2 = new EmployeeEntity("password", 100, "Phil", "Huff", "phuff@gmail.com");

		returnEmpEntities.add(empEntity1);
		returnEmpEntities.add(empEntity2);

		EmployeePojo empPojo1 = new EmployeePojo();
		EmployeePojo empPojo2 = new EmployeePojo();
		BeanUtils.copyProperties(empEntity1, empPojo1);
		BeanUtils.copyProperties(empEntity2, empPojo2);

		when(daoMock.findAll()).thenReturn(returnEmpEntities);

		List<EmployeePojo> expectedPojos = new ArrayList<EmployeePojo>();
		expectedPojos.add(empPojo1);
		expectedPojos.add(empPojo2);

		List<EmployeePojo> actualPojos = null;

		try {
			actualPojos = serviceTest.getAllEmployees();
		} catch (ApplicationException e) {
			e.printStackTrace();
		}

		assertEquals(expectedPojos, actualPojos);

	}

}
