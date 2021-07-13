package com.infy.EmployeeDetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.EmployeeDetails.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	List<Employee> findByUnit(String unit);
	
}
