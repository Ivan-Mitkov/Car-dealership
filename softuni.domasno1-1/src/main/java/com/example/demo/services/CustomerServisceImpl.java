package com.example.demo.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entity.Customer;

@Service
public class CustomerServisceImpl implements CustomerService{
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServisceImpl(CustomerRepository customerRepository) {
		this.customerRepository=customerRepository;
	}
	
	@Override
	@Transactional
	public List<Customer> getCustomersOrderedByBirthDate() {
		List<Customer> customers=new ArrayList<>();
		customers=(List<Customer>) customerRepository
				.findAll();
		
		List<Customer>result=customers.stream()
				.sorted((Comparator.comparing(Customer::getBirthDate)
						.thenComparing(Customer::getIsYoungDriver).reversed()))
				.collect(Collectors.toList());
		return result;
	}
	@Override
	@Transactional
	public List<Customer> getCustomersOrderedByBirthDateDesc() {
		List<Customer> customers=new ArrayList<>();
		customers=(List<Customer>) customerRepository
				.findAll();
		
		List<Customer>result=customers.stream()
				.sorted((Comparator.comparing(Customer::getBirthDate).reversed()
						.thenComparing(Customer::getIsYoungDriver).reversed()))
				.collect(Collectors.toList());
		return result;
		
	}
	

	@Transactional
	@Override
	public void saveCustomer(Customer theCustomer) {
		customerRepository.save(theCustomer);
		
	}

	@Transactional
	@Override
	public void editCustomer(Customer theCustomer) {
		customerRepository.save(theCustomer);
		
	}

	@Transactional
	@Override
	public Customer getCustomer(long theId) {
		Customer customer = null;
		if(customerRepository.existsById(theId)) {		
			customer =(Customer)customerRepository.findById(theId).get();
			return customer;
		}
		else {
			return customer;
		}
	}

	@Transactional
	@Override
	public void deleteCustomer(long theId) {
		customerRepository.deleteById(theId);
		
	}

	

}
