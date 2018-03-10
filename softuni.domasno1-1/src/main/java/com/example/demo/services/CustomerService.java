package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Customer;

public interface CustomerService {
	
	public void saveCustomer(Customer theCustomer);

	public void editCustomer(Customer theCustomer);
	
	public Customer getCustomer(long theId);

	public void deleteCustomer(long theId);

	public List<Customer> getCustomersOrderedByBirthDate();

	public List<Customer> getCustomersOrderedByBirthDateDesc();
	

}
