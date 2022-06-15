package com.group1.project2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group1.project2.models.entity.EmployeeEntity;
import com.group1.project2.models.entity.ReimbursementEntity;

@Repository
public interface ReimbursementDao extends JpaRepository<ReimbursementEntity, Integer> {
	List<ReimbursementEntity> findByStatus(String status);
	List<ReimbursementEntity> findByEmployee(EmployeeEntity employee);
	List<ReimbursementEntity> findByEmployeeAndStatus(EmployeeEntity employee, String status);
}