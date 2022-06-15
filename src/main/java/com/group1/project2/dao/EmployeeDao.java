package com.group1.project2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group1.project2.models.entity.EmployeeEntity;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer> {
	
	//validate login
	@Query(value = "SELECT * FROM employee_details WHERE email = '?1' AND password = crypt('?2', password)", nativeQuery = true)
	EmployeeEntity findByEmailAndPassword(String email, String password);
	
}
