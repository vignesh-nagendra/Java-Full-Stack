package com.infytel.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;

public interface CustomerService {

	public void insertCustomer(CustomerDTO customer) ;
	Page<Customer> findAll(Pageable page);
	List<Customer> findAll(Sort sort);

}