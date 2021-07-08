package com.infytel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infytel.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
