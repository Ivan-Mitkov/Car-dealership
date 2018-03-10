package com.example.demo;

import java.util.List;
import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Customer;
import com.example.demo.services.CustomerServisceImpl;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {

	private CustomerServisceImpl customerServisceImpl;
	
	@Autowired
	public ConsoleRunner(CustomerServisceImpl customerServisceImpl) {
		this.customerServisceImpl = customerServisceImpl;
	}


	@Override
	public void run(String... args) throws Exception {
		long theId=10;
		customerServisceImpl.getCustomer(theId);
		List<Customer>customer= customerServisceImpl.getCustomersOrderedByBirthDate();
		print(customer);
		List<Customer> customer2 = customerServisceImpl.getCustomersOrderedByBirthDateDesc();
		print(customer2);
		
	}
	public void print(List<Customer> customer) {
		
		for(Customer c:customer) {
			System.out.println(c);
		}
	}
	

}
