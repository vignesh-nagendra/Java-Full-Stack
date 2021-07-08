package com.infytel;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.infytel.dto.CustomerDTO;
import com.infytel.service.CustomerService;

@SpringBootApplication
public class Client implements CommandLineRunner{

	@Autowired
	ApplicationContext context;
	@Autowired
	CustomerService service;
	
	public static void main(String[] args) {
		SpringApplication.run(Client.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		CustomerDTO customer1= new CustomerDTO(7022713754L, "Adam", 27, 'M', "Chicago", 1);
		CustomerDTO customer2= new CustomerDTO(7022713744L, "Susan", 27, 'F', "Alberta", 2);
		CustomerDTO customer3= new CustomerDTO(7022713722L, "Lucy", 27, 'F', "MUMBAI", 3);
		//invoke service layer method to insert Customer
		service.insertCustomer(customer1);
		service.insertCustomer(customer2);
		service.insertCustomer(customer3);
		System.out.println("Records are successfully added..");
		
		System.out.println("Enter the phone Number of the Customer which has to be deleted.");
		Scanner scanner = new Scanner(System.in);
		Long phoneNo = scanner.nextLong();

		// Invoking Service layer method to remove Customer details from
		// Customer table
		service.removeCustomer(phoneNo);
		System.out.println("Record Deleted");
		
		scanner.close();
		

}

		
	}

