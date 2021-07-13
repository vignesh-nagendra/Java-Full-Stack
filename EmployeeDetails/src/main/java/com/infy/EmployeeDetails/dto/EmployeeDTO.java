package com.infy.EmployeeDetails.dto;

import javax.validation.constraints.NotNull;

public class EmployeeDTO {
	
	private Integer empId;
	@NotNull(message = "Employee name should'nt be null")
	private String name;
	private String unit;
	private String address;
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", name=" + name + ", unit=" + unit 
				+ ", address=" + address + "]";
	}
	

}
