package com.example.demo;

import java.util.List;
import java.util.Set;
import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Car;
import com.example.demo.entity.Customer;
import com.example.demo.services.CarsServisceImpl;
import com.example.demo.services.CustomerServisceImpl;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {

	@Autowired
	private CustomerServisceImpl customerServisceImpl;
	
	private CarsServisceImpl carService;
	
	
	public ConsoleRunner(CustomerServisceImpl customerServisceImpl) {
		this.customerServisceImpl = customerServisceImpl;
	}

	@Autowired
	public ConsoleRunner(CarsServisceImpl carService) {
		this.carService = carService;
	}

	@Override
	public void run(String... args) throws Exception {
//		List<Customer>customer= customerServisceImpl.getCustomersOrderedByBirthDate();
//		print(customer);
//		List<Customer> customer2 = customerServisceImpl.getCustomersOrderedByBirthDateDesc();
//		print(customer2);
		String make="Opel";
		List<Car>cars=carService.getCarsByMake(make);
		print(cars);
		List<String>makers=carService.getCarMakers();
		print(makers);
	}
	public<T> void print(Iterable<T> customer) {
		
		for(T c:customer) {
			System.out.println(c);
		}
	}
	

}
