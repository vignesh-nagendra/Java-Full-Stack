package com.infy.EmployeeDetails.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.EmployeeDetails.dto.EmployeeDTO;
import com.infy.EmployeeDetails.dto.ErrorMessage;
import com.infy.EmployeeDetails.entity.Employee;
import com.infy.EmployeeDetails.exception.EmployeeException;
import com.infy.EmployeeDetails.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin
@RestController
@RequestMapping("/Api")
public class EmployeeAPI {
	@Autowired
	private EmployeeService employeeService;
	
	public static Logger LOGGER = LoggerFactory.getLogger(EmployeeAPI.class);
	
	@GetMapping(value = "/Employee/{id}")
	@ApiResponses(value= {@ApiResponse(code=200,message="Employee fetched sucessfully",response=Employee.class),
			@ApiResponse(code=401,message="No such Employee exists!!",response=ErrorMessage.class),
			@ApiResponse(code=403,message="FORBIDDEN",response=ErrorMessage.class),
			@ApiResponse(code=404,message="NOT FOUND",response=ErrorMessage.class)})
	@ApiOperation(value = "Find employee by id", notes = "Provide an employee id to fetch the details of an employee", response = Employee.class)
	public ResponseEntity<EmployeeDTO> getEmployee(@ApiParam(value = "ID value for the employee you need to retrieve",example="1", required = true)@PathVariable Integer id) throws EmployeeException{
		LOGGER.info("Employee fetched sucessfully based on employeeId");
		return new ResponseEntity<>(employeeService.getEmployee(id),HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/Employee")
	@ApiResponses(value= {@ApiResponse(code=200,message="Employee added sucessfully",response=Employee.class),
			@ApiResponse(code=401,message="Employee already exists!!",response=ErrorMessage.class),
			@ApiResponse(code=403,message="FORBIDDEN",response=ErrorMessage.class),
			@ApiResponse(code=404,message="NOT FOUND",response=ErrorMessage.class)})
	public ResponseEntity<String> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) throws EmployeeException{
		Integer id = employeeService.addEmployee(employeeDTO);
		LOGGER.info("Employee Inserted sucessfully");
		return new ResponseEntity<>("Employee with id "+id+" added successfully",HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/Employee/{unit}")
	@ApiResponses(value= {@ApiResponse(code=200,message="Employee fetched sucessfully",response=Employee.class),
			@ApiResponse(code=401,message="No such Employee exists!!",response=ErrorMessage.class),
			@ApiResponse(code=403,message="FORBIDDEN",response=ErrorMessage.class),
			@ApiResponse(code=404,message="NOT FOUND",response=ErrorMessage.class)})
	public ResponseEntity<List<EmployeeDTO>> getEmployeeByunit(@ApiParam(value = "Unit value for the employee you need to retrieve",required = true)@PathVariable String unit){
		LOGGER.info("Employee fetched sucessfully based on employeeUnit");
		return new ResponseEntity<>(employeeService.getEmployeeByUnit(unit),HttpStatus.OK);
	}
	
	@GetMapping(value = "/Employee")
	@ApiResponses(value= {@ApiResponse(code=200,message="Employees fetched sucessfully",response=Employee.class),
			@ApiResponse(code=401,message="No Employee exists!!",response=ErrorMessage.class),
			@ApiResponse(code=403,message="FORBIDDEN",response=ErrorMessage.class),
			@ApiResponse(code=404,message="NOT FOUND",response=ErrorMessage.class)})
	public ResponseEntity<List<EmployeeDTO>> getAllEmployee() throws EmployeeException{
		LOGGER.info("employees fetched sucessfully");
		return new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.OK);
	}
	
	@PutMapping(value = "/Employee/{employeeId}")
	@ApiResponses(value= {@ApiResponse(code=200,message="Employee Updated sucessfully",response=Employee.class),
			@ApiResponse(code=401,message="Employee update failed",response=ErrorMessage.class),
			@ApiResponse(code=403,message="FORBIDDEN",response=ErrorMessage.class),
			@ApiResponse(code=404,message="NOT FOUND",response=ErrorMessage.class)})
	public ResponseEntity<String> updateEmployee(@PathVariable Integer employeeId,@RequestBody EmployeeDTO employeeDTO) throws EmployeeException{
		String msg = employeeService.updateEmployee(employeeId, employeeDTO.getUnit());
		LOGGER.info("Employee updated sucessfully");
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/Employee/{employeeId}")
	@ApiResponses(value= {@ApiResponse(code=200,message="Employee deleted sucessfully",response=Employee.class),
			@ApiResponse(code=401,message="No such Employee exists!!",response=ErrorMessage.class),
			@ApiResponse(code=403,message="FORBIDDEN",response=ErrorMessage.class),
			@ApiResponse(code=404,message="NOT FOUND",response=ErrorMessage.class)})
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeId) throws EmployeeException{
		String msg = employeeService.deleteEmployee(employeeId);
		LOGGER.info("Employee deleted sucessfully");
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}

}
