package com.infy.EmployeeDetails.service;

import java.util.List;

import com.infy.EmployeeDetails.dto.EmployeeDTO;
import com.infy.EmployeeDetails.exception.EmployeeException;

public interface EmployeeService {
	
	public EmployeeDTO getEmployee(Integer employeeId) throws EmployeeException;
	public Integer addEmployee(EmployeeDTO employeeDTO);
	public List<EmployeeDTO> getEmployeeByUnit(String unit);
	public List<EmployeeDTO> getAllEmployee() throws EmployeeException;
	public String updateEmployee(Integer employeeId, String unit) throws EmployeeException; 
	public String deleteEmployee(Integer employeeId) throws EmployeeException;

}
