package com.group1.project2.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group1.project2.models.entity.EmployeeEntity;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer> {
	
	Optional<EmployeeEntity> findByEmailAndPassword(String email, String password);
	
}
