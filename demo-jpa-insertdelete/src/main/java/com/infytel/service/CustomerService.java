package com.infytel.service;

import com.infytel.dto.CustomerDTO;

public interface CustomerService {

	public void insertCustomer(CustomerDTO customer) ;
	public void removeCustomer(Long phoneNo);
}
