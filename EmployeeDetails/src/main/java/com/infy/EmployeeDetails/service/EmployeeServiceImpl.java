package com.infy.EmployeeDetails.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.EmployeeDetails.dto.EmployeeDTO;
import com.infy.EmployeeDetails.entity.Employee;
import com.infy.EmployeeDetails.exception.EmployeeException;
import com.infy.EmployeeDetails.repository.EmployeeRepository;

@Service(value = "employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private Environment environment;
	@Override
	public EmployeeDTO getEmployee(Integer employeeId) throws EmployeeException {
		Optional<Employee> empOp = employeeRepository.findById(employeeId);
		Employee employee = empOp.orElseThrow(()-> new EmployeeException(environment.getProperty("Service.INVALID_EMPLOYEEID")));
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmpId(employee.getEmpId());
		employeeDTO.setName(employee.getName());
		employeeDTO.setUnit(employee.getUnit());
		employeeDTO.setAddress(employee.getAddress());
		return employeeDTO;
	}

	@Override
	public Integer addEmployee(EmployeeDTO employeeDTO){
		Employee employee = new Employee();
		employee.setEmpId(employeeDTO.getEmpId());
		employee.setName(employeeDTO.getName());
		employee.setUnit(employeeDTO.getUnit());
		employee.setAddress(employeeDTO.getAddress());
		employeeRepository.save(employee);
		return employee.getEmpId();
	}
	
	@Override
	public List<EmployeeDTO> getEmployeeByUnit(String unit){
		Iterable<Employee> employees = employeeRepository.findByUnit(unit);
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		employees.forEach(employee -> {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmpId(employee.getEmpId());;
			employeeDTO.setName(employee.getName());
			employeeDTO.setUnit(employee.getUnit());
			employeeDTO.setAddress(employee.getAddress());
			employeeDTOs.add(employeeDTO);
		});
		return employeeDTOs;
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() throws EmployeeException {
		Iterable<Employee> employees = employeeRepository.findAll();
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		employees.forEach(employee -> {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmpId(employee.getEmpId());;
			employeeDTO.setName(employee.getName());
			employeeDTO.setUnit(employee.getUnit());
			employeeDTO.setAddress(employee.getAddress());
			employeeDTOs.add(employeeDTO);
		});
		if (employeeDTOs.isEmpty())
			throw new EmployeeException(environment.getProperty("Service.EMPLOYEE_NOT_FOUND"));
		return employeeDTOs;
	}

	@Override
	public String updateEmployee(Integer employeeId, String unit) throws EmployeeException {
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		Employee employee = optional.orElseThrow(() -> new EmployeeException(environment.getProperty("Service.INVALID_EMPLOYEEID")));
		employee.setUnit(unit);
		return "Employee with id "+employeeId+" has been updated successfully!";
	}

	@Override
	public String deleteEmployee(Integer employeeId) throws EmployeeException {
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		optional.orElseThrow(() -> new EmployeeException(environment.getProperty("Service.INVALID_EMPLOYEEID")));
		employeeRepository.deleteById(employeeId);
		return "Employee with id "+employeeId+" has been deleted successfully!";
	}

}
