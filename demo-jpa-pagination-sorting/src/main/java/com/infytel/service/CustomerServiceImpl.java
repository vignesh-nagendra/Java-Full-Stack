package com.infytel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;
import com.infytel.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	  @Autowired
	  private CustomerRepository  repository; 
	  
	public void insertCustomer(CustomerDTO customer) {
		repository.saveAndFlush(CustomerDTO.prepareCustomerEntity(customer));

	}
	
	@Override
	public Page<Customer> findAll(Pageable page) {

		return repository.findAll(page);
		
	}
	@Override
	public List<Customer> findAll(Sort sort) {
	
		return repository.findAll(sort);
	}

}
