package com.infytel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infytel.dto.CustomerDTO;
import com.infytel.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	  @Autowired
	  private CustomerRepository  repository; 
	  
	public void insertCustomer(CustomerDTO customer) {
		repository.saveAndFlush(CustomerDTO.prepareCustomerEntity(customer));
	
	}
	public void removeCustomer(Long phoneNo) {
		 repository.deleteById(phoneNo);
		
	}

}
