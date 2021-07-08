package com.infy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infy.dto.CustomerDTO;
import com.infy.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public String createCustomer(CustomerDTO dto) {
		return customerRepository.createCustomer(dto);
	}
	@Override
	public String fetchCustomer() {
		return customerRepository.fetchCustomer();
	}
    @Override
	public void deleteCustomer(long phoneNumber) {
		try {
			customerRepository.deleteCustomer(phoneNumber);
		} catch (Exception e) {
			logger.info("In log Exception ");
			logger.error(e.getMessage(),e);
		}
	}
}
