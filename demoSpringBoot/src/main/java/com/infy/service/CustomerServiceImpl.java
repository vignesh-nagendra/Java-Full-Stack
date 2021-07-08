package com.infy.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {
	@Value("10")
	private int count;
	public String fetchCustomer() {
		return " The no of customers fetched are : " + count;
	}
	public String createCustomer() {
		return "Customer is successfully created";
	}
}
